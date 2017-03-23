import java.util.Map;
import java.util.HashMap;
import spark.ModelAndView;
import spark.template.velocity.VelocityTemplateEngine;
import static spark.Spark.*;

public class App {
  public static void main(String[] args) {
    staticFileLocation("/public");
    String layout = "templates/layout.vtl";
    // Initialize some heroes
    Hero hero1 = new Hero("Storm", 123, "Weather control", 14, 10);
    Hero hero2 = new Hero("Professor X", 123, "Mind control", 14, 2);
    // Hero hero1 = new Hero();

    get("/", (request, response) -> {
      Map<String, Object> model = new HashMap<String, Object>();
      model.put("template", "templates/index.vtl");
      model.put("squads", Squad.all());
      model.put("heroes", Hero.all());
      return new ModelAndView(model, layout);
    }, new VelocityTemplateEngine());

    get("/squads/new", (request, response) -> {
      Map<String, Object> model = new HashMap<String, Object>();
      model.put("heroes", Hero.all());
      model.put("template", "templates/squad-form.vtl");
      return new ModelAndView(model, layout);
    }, new VelocityTemplateEngine());

    post("/squad", (request, response) -> {
      Map<String, Object> model = new HashMap<String, Object>();
      String name = request.queryParams("name");
      String cause = request.queryParams("cause");
      String[] selectedHeroes = request.queryParamsValues("heroes");
      // System.out.println(request.queryParamsValues("heroes").length);
      Squad newSquad = new Squad(name, cause);
      for (String hero : selectedHeroes) {
        // System.out.println("hero is " + hero);
        // System.out.println(Hero.all().size());
        // System.out.println(Hero.getHero(hero) instanceof Hero);
        // System.out.println(Hero.getHero(hero));
        newSquad.addHero(Hero.getHero(hero));
      }
      model.put("squads", Squad.all());

      model.put("template", "templates/index.vtl");
      return new ModelAndView(model, layout);
    }, new VelocityTemplateEngine());

    get("/squads/:squadID", (request, response) -> {
      Map<String, Object> model = new HashMap<String, Object>();
      model.put("squad", Squad.all().get(request.params(":squadID")));
      model.put("template", "templates/squad.vtl");
      return new ModelAndView(model, layout);
    }, new VelocityTemplateEngine());

  }
}
