import java.util.Map;
import java.util.HashMap;

public class Hero {
  private String mName;
  private int mAge;
  private String mPower;
  private int mAttack;
  private int mDefense;
  private static Map<String, Hero> instances = new HashMap<String, Hero>();

  public Hero(String name, int age, String power, int attack, int defense) {
    mName = name;
    mAge = age;
    mPower = power;
    mAttack = attack;
    mDefense = defense;
    instances.put(name, this);
  }

  public String getName() {
    return mName;
  }

  public int getAge() {
    return mAge;
  }

  public String getPower() {
    return mPower;
  }

  public int getAttack() {
    return mAttack;
  }

  public int getDefense() {
    return mDefense;
  }

  public static Map<String, Hero> all() {
    return instances;
  }

  public static void clear() {
    instances.clear();
  }

  public static Hero getHero(String name) {
    return instances.get(name);
  }

}
