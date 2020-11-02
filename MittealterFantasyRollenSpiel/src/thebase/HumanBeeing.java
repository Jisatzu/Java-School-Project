package thebase;

import java.util.ArrayList;

import people.Player;
import repetitiveStuff.Tab;
import skills.Skill;

public class HumanBeeing {
	/**
	 * The Name of that being.
	 */
	private String name;
	/**
	 * The amount of hp the being has.
	 */
	private int baseHP;
	/**
	 * the amount of defense the being has.
	 */
	private int baseArmor;
	/**
	 * The amount of damage the being deals.
	 */
	private int baseDmg;
	/**
	 * The amount of xp that the enemy has or the player starts with.
	 */
	private int xp;
	/**
	 * The amount of money the being has, to drop or to trade with.
	 */
	private int money;
	protected ArrayList<Skill> skilllist;
	/**
	 * The amount of money that the player has. All playable character have one money pool.
	 */
	private static int playermoney;
	/**
	 * This is needed to display all the names of the seen stats.
	 */
	private static final String itemParameters = Tab.left(10, "Item ID ") + Tab.left(15, "Item Name") + Tab.left(40, "Material Typ") + Tab.left(20, "Item Preis") + Tab.left(20, "Schaden") + Tab.left(20, "Verteidigung") + Tab.left(20, "Verfügbar");
	/**
	 * This is needed to display all the names of the seen stats.
	 */
	private static final String potionParameters = Tab.left(10, "Item ID ") + Tab.left(15, "Item Name") + Tab.left(40, "Item Preis") + Tab.left(20, "Lebenwiederherstellung") + Tab.left(20, "Manawiederherstellung") + Tab.left(20, "Verfügbar");

	/**
	 * Constructor for all living beings. This is needed for all Living being else they would not "exist".
	 * 
	 * @param Name         the name of the being
	 * @param baseHPthe    hp of the being
	 * @param baseArmor    the armor of that being
	 * @param baseDmg      the dmg of that being
	 * @param XP           the xp of that being, be it strating xp for playalbe characters or xp for killing it.
	 * @param money        the amount of money that the being has
	 * @param playablechar if it's a playable char or not.
	 */
	public HumanBeeing(String Name, int baseHP, int baseArmor, int baseDmg, int XP, int money, boolean playablechar) {
		this.baseArmor = baseArmor;
		this.baseDmg = baseDmg;
		this.baseHP = baseHP;
		this.name = Name;
		this.xp = XP;
		if (playablechar) {
			Player.setMoney(money);
		} else {
			this.money = money;
		}
	}

	public static int getPlayermoney() {
		return playermoney;
	}

	public int getBaseArmor() {
		return baseArmor;
	}

	public int getBaseDmg() {
		return baseDmg;
	}

	public int getBaseHP() {
		return baseHP;
	}

	public int getMoney() {
		return money;
	}

	public String getName() {
		return name;
	}

	public int getXp() {
		return xp;
	}

	public static String getItemparameters() {
		return itemParameters;
	}

	public static String getPotionParameters() {
		return potionParameters;
	}

	public ArrayList<Skill> getSkilllist() {
		return skilllist;
	}
}
