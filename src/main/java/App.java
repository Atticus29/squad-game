import java.util.Map;
import java.util.HashMap;
import spark.ModelAndView;
import spark.template.velocity.VelocityTemplateEngine;
import static spark.Spark.*;
// import java.util.List;

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
      return new ModelAndView(model, layout);
    }, new VelocityTemplateEngine());

    get("/heroes/new", (request, response) -> {
      Map<String, Object> model = new HashMap<String, Object>();
      model.put("template", "templates/hero-form.vtl");
      return new ModelAndView(model, layout);
    }, new VelocityTemplateEngine());

    post("/heroes", (request, response) -> {
      Map<String, Object> model = new HashMap<String, Object>();
      String name = request.queryParams("name");
      String power = request.queryParams("power");
      int age = Integer.parseInt(request.queryParams("age"));
      int attack = Integer.parseInt(request.queryParams("attack"));
      int defense = Integer.parseInt(request.queryParams("defense"));
      Hero newHero = new Hero(name, age, power, attack, defense);

      model.put("squads", Squad.all());
      model.put("template", "templates/index.vtl");
      return new ModelAndView(model, layout);
    }, new VelocityTemplateEngine());

    get("/squads/new", (request, response) -> {
      Map<String, Object> model = new HashMap<String, Object>();
      model.put("heroes", Hero.all());
      model.put("template", "templates/squad-form.vtl");
      return new ModelAndView(model, layout);
    }, new VelocityTemplateEngine());

    get("/squads", (request, response) -> {
      Map<String, Object> model = new HashMap<String, Object>();
      model.put("template", "templates/index.vtl");
      model.put("squads", Squad.all());
      return new ModelAndView(model, layout);
    }, new VelocityTemplateEngine());

    post("/squads", (request, response) -> {
      Map<String, Object> model = new HashMap<String, Object>();
      String name = request.queryParams("name");
      String cause = request.queryParams("cause");
      String[] selectedHeroes = request.queryParamsValues("heroes");
      Squad newSquad = new Squad(name, cause);
      for (String hero : selectedHeroes) {
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

    post("/squads/:squadID", (request, response) -> {
      Map<String, Object> model = new HashMap<String, Object>();
      String[] selectedHeroes = request.queryParamsValues("heroes");
      Squad currentSquad = Squad.all().get(request.params(":squadID"));
      for (String hero : selectedHeroes) {
        currentSquad.addHero(Hero.getHero(hero));
      }

      model.put("squad", currentSquad);
      model.put("template", "templates/squad.vtl");
      return new ModelAndView(model, layout);
    }, new VelocityTemplateEngine());

    get("/squads/:squadID/heroes/new", (request, response) -> {
      Map<String, Object> model = new HashMap<String, Object>();
      model.put("squadID", request.params(":squadID"));
      model.put("heroes", Hero.getAvailableHeros());
      model.put("template", "templates/available-heroes.vtl");
      return new ModelAndView(model, layout);
    }, new VelocityTemplateEngine());

    get("/squads/:squadID/heroes/:heroID", (request, response) -> {
      Map<String, Object> model = new HashMap<String, Object>();
      model.put("squadID", request.params(":squadID"));
      model.put("hero", Hero.getHero(request.params(":heroID")));
      model.put("template", "templates/hero.vtl");
      return new ModelAndView(model, layout);
    }, new VelocityTemplateEngine());


  }
}
