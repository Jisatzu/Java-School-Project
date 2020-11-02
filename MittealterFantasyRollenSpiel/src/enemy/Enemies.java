package enemy;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

import javafx.scene.shape.Ellipse;
import repetitiveStuff.Tab;
import test.Enemy;
import thebase.HumanBeeing;

// import java.util.Random;

/**
 * /** This class if for all the enemys that have to be generated.
 * 
 * 
 * @author Batuhan Avci
 *
 */
public abstract class Enemies extends HumanBeeing {
	
	public static void main(String[] args) {
		//Enemies.registerEnemies(Arrays.asList(Assasin.class, Bandit_Archer.class, Goblin.class));
		registerEnemy(Goblin.class);
		Enemies testEnemy = createEnemy(Orc.class);
		Enemies rdmEnemy = createRandomEnemy();
		
		System.out.println(Enemies.getAllStats(testEnemy));
		System.out.println(Enemies.getAllStats(rdmEnemy));
	}
	
	private static List<Class<Enemies>> enemies = new ArrayList<>();
	
	@SuppressWarnings("unchecked")
	public static void registerEnemy(Class<? extends Enemies> enemy) {
		enemies.add((Class<Enemies>) enemy);
	}
	
	@SuppressWarnings("unchecked")
	public static void registerEnemies(List<Class<? extends Enemies>> list) {
		list.forEach(e -> list.add((Class<Enemies>) e));
	}
	
	public static Enemies createEnemy(Class<? extends Enemies> class1) {
		try {
			return class1.newInstance();
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
	public static Enemies createRandomEnemy() {
		Integer rdm = (int) Math.floor(Math.random() * enemies.size());
		Class<? extends Enemies> enemy = enemies.get(rdm);
		return createEnemy(enemy);
	}
	
	/**
	 * The amount of healthpoints the enemy has.
	 */
	private int hp;
	/**
	 * The amount of dmg the enemy has.
	 */
	private int dmg;
	/**
	 * The amount of def the enemy has.
	 */
	private int def;
	/**
	 * The amount of xp the enemy gives.
	 */
	private int xp;
	/**
	 * The amount of money the enemy has.
	 */
	private int money;
	/**
	 * The name that the enemy has.
	 */
	private String name;
	private int mana;
	/**
	 * The death checker.
	 */
	private boolean dead = false;
	/**
	 * the Id from the Enemy
	 */
	private int id;
	/**
	 * Number for the highest ID possible
	 */
	private final int maxEnemyID = 7;
	private static ArrayList<Enemies> enemyListToCreateFrom = new ArrayList<Enemies>();

	/**
	 * This Constructor creates every single enemy that is in this game.
	 * 
	 * @param name  the name of the enemy
	 * @param HP    the amount of health points of that enemy has
	 * @param DMG   the amount of damage of that the enemy can deal
	 * @param DEF   the amount of defense that the enemy has
	 * @param XP    the amount of xp that the enemy gives to the player.
	 * @param money the amount of money that the enemy gives to the player.
	 */
	public Enemies(String name, int baseHP, int baseDmg, int baseArmor, int XP, int money, int mana) {
		super(name, baseHP, baseArmor, baseDmg, XP, money, false);
		/*
		 * enemyListToCreateFrom.add(new Assasin(0)); enemyListToCreateFrom.add(new
		 * Bandit(0)); enemyListToCreateFrom.add(new Bandit_Archer(0));
		 * enemyListToCreateFrom.add(new Goblin(0)); enemyListToCreateFrom.add(new
		 * Hobgoblin(0)); enemyListToCreateFrom.add(new Orc(0));
		 * enemyListToCreateFrom.add(new Pixie(0));
		 */
		hp = baseHP;
		dmg = baseDmg;
		def = baseArmor;
		xp = XP;
		this.mana = mana;
		this.money = money;
		this.name = name;
	}

	/**
	 * This method creates random values from 2 values.
	 * 
	 * @param min This is the minimum value that the enemy can have.
	 * @param max this is the maximum value that the enemy can have.
	 * @return Returns the random value.
	 */
	protected static int enemyValueGenerator(int min, int max) {
		int value = new Random().nextInt(max);
		if (value < min) {
			value = min;
		}
		return value;
	}

	public static String getAllStats(Enemies e) {
		return Tab.left(10, e.getDef() + " def ") + Tab.left(15, e.getHp() + " hp ")
				+ Tab.left(40, e.getDmg() + " dmg ") + Tab.left(20, e.getXp() + " xp ");
	}

	public int getDef() {
		return def;
	}

	public int getDmg() {
		return dmg;
	}

	public int getHp() {
		return hp;
	}

	public int getMoney() {
		return money;
	}

	public int getXp() {
		return xp;
	}

	public String getName() {
		return name;
	}

	public int getMana() {
		return mana;
	}

	/**
	 * Sets the amount of hp the enemy has left.
	 * 
	 * @param hp the amount of damage that the enemy received.
	 */
	public void setHp(int hp) {
		this.hp = hp;
	}

	public boolean getDead() {
		return dead;
	}

	/**
	 * Sets the enemy to dead.
	 */
	public void setDead() {
		dead = true;
	}
}
