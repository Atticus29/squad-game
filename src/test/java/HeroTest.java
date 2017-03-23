import org.junit.*;
import static org.junit.Assert.*;

public class HeroTest {

  @Test
  public void hero_instantiatesCorrectly() {
    Hero testHero = new Hero("spiderman", 32, "web slinging", 10, 7);
    assertEquals(true, testHero instanceof Hero);
  }

  @Test
  public void getName_returnsNameCorrectly_spiderman() {
    Hero testHero = new Hero("spiderman", 32, "web slinging", 10, 7);
    assertEquals("spiderman", testHero.getName());
  }

  @Test
  public void getAge_returnsAgeCorrectly_spiderman() {
    Hero testHero = new Hero("spiderman", 32, "web slinging", 10, 7);
    assertEquals(32, testHero.getAge());
  }

  @Test
  public void getPower_returnsPowerCorrectly_spiderman() {
    Hero testHero = new Hero("spiderman", 32, "web slinging", 10, 7);
    assertEquals("web slinging", testHero.getPower());
  }

  @Test
  public void getAttack_returnsAttackCorrectly_spiderman() {
    Hero testHero = new Hero("spiderman", 32, "web slinging", 10, 7);
    assertEquals(10, testHero.getAttack());
  }

  @Test
  public void getDefense_returnsDefenseCorrectly_spiderman() {
    Hero testHero = new Hero("spiderman", 32, "web slinging", 10, 7);
    assertEquals(7, testHero.getDefense());
  }

  @Test
  public void all_returnsCorrectSize() {
    Hero.clear();
    assertEquals(0, Hero.all().size());
    Hero testHero = new Hero("spiderman", 32, "web slinging", 10, 7);
    assertEquals(1, Hero.all().size());
  }

  @Test
  public void clear_returnsCorrectSize() {
    Hero.clear();
    Hero testHero = new Hero("spiderman", 32, "web slinging", 10, 7);
    assertEquals(1, Hero.all().size());
    Hero.clear();
    assertEquals(0, Hero.all().size());
  }

  @Test
  public void getHero_returnsHeroCorrectly() {
    Hero.clear();
    Hero testHero = new Hero("spiderman", 32, "web slinging", 10, 7);
    assertEquals(testHero, Hero.getHero("spiderman"));
  }

}
