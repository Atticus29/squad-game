import java.util.Map;
import java.util.HashMap;

public class Squad {
  private String mName;
  private int mMaxSize;
  private String mCause;
  private static Map<String, Squad> instances = new HashMap<String, Squad>();
  private Map<String, Hero> mHeroes;

  public Squad(String name, String cause){
    mName = name;
    mMaxSize = 8;
    mCause = cause;
    mHeroes = new HashMap<String, Hero>();
    instances.put(name, this);
  }

  public int getMax(){
    return mMaxSize;
  }

  public String getCause(){
    return mCause;
  }

  public String getName(){
    return mName;
  }

  public static Map<String, Squad> all(){
    return instances;
  }

  public static void clear(){
    instances.clear();
  }

  public void addHero(Hero newHero){
    mHeroes.put(newHero.getName(), newHero);
  }

  public Map<String, Hero> getHeroes(){
    return mHeroes;
  }

}
