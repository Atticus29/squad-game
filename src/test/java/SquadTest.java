import org.junit.*;
import static org.junit.Assert.*;
import java.util.Map;
import java.util.HashMap;

public class SquadTest {

  private Squad testSquad1;

  @Before
  public void setUp(){
    testSquad1 = new Squad("Avengers", "Rake in billions");
  }

  @Test
  public void squad_instantiatesCorrectly(){
    assertTrue(testSquad1 instanceof Squad);
  }

  @Test
  public void getName_returnsNameCorrectly_avengers(){
    assertEquals("Avengers", testSquad1.getName());
  }

  @Test
  public void getMax_returnsMaxSizeCorrectly_8(){
    assertEquals(8, testSquad1.getMax());
  }

  @Test
  public void getCause_returnsCauseCorrectly_String(){
    assertEquals("Rake in billions", testSquad1.getCause());
  }

  @Test
  public void clear_resetsInstances_0(){
    Squad testSquad2 = new Squad("Justice league", "Rake in tens");
    assertEquals(2, Squad.all().size());
    Squad.clear();
    assertEquals(0, Squad.all().size());
    // Squad testSquad3 = new Squad("Justice league", "Rake in billions and protect a world that hates and fears them");
    // assertEquals(1, Squad.all().size());
  }

  @Test
  public void getHeroes_returnsHashOfHeroes_true(){
    Hero newHero1 = new Hero("Batman", 41, "resourcefulness", 4, 5);
    testSquad1.addHero(newHero1);
    Hero newHero2 = new Hero("Batman", 41, "resourcefulness", 4, 5);
    testSquad1.addHero(newHero2);
    assertTrue(testSquad1.getHeroes() instanceof HashMap);
  }

  @Test
  public void addHero_addsHeroToHeroHash_true(){
    Hero newHero = new Hero("Batman", 41, "resourcefulness", 4, 5);
    testSquad1.addHero(newHero);
    assertTrue(testSquad1.getHeroes().containsKey("Batman"));
  }


  @After
  public void tearDown(){
    Squad.clear();
  }
}
