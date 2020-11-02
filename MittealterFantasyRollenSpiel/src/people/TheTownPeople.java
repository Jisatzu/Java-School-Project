package people;

import thebase.HumanBeeing;

public class TheTownPeople extends HumanBeeing {
	/**
	 * Attribute for the Name of a person.
	 */
	private String name;
	/**
	 * Attribute for the Profession of a person.
	 */
	private String profession;
	/**
	 * Attribute for the building that the person has.
	 */
	private String building;
	/**
	 * Attribute for the goods that the person sells.
	 */
	private String goods;

	/**
	 * This constructor is for Intractable People but have only to say something.
	 * 
	 * @param name       The Name of that Person
	 * @param profession The Profession of that Person.
	 * @param City       The City that the Person is living.
	 */
	public TheTownPeople(String Name, int baseHP, int baseArmor, int baseDmg, int XP, int money, String City, boolean playablechar) {
		super(Name, baseHP, baseArmor, baseDmg, XP, money, playablechar);
		// TODO Auto-generated constructor stub
	}

	/**
	 * This Constructor creates the People that sell goods in a City
	 * 
	 * @param name       The name of the People that live in that town and have a Interaction with the player.
	 * @param profession The Profession of the People living in the Town.
	 * @param building   The Building that the People they have.
	 * @param goods      The Goods that the People sells.
	 */
	public TheTownPeople(String Name, int baseHP, int baseArmor, int baseDmg, int XP, int money, String profession, String building, String goods, boolean playablechar) {
		super(Name, baseHP, baseArmor, baseDmg, XP, money, playablechar);
		this.building = building;
		this.profession = profession;
		this.goods = goods;
	}

	/**
	 * This Method is used to greet the player. The player get's to know with whom he is talking and what his profession is.
	 */
	public void greeting() {
		System.out.println("Greetings my friend. I am " + name + ".");
		System.out.println("I am the master " + profession + "of this " + building);
		System.out.println("The goods that i am dealing with are " + goods);
	}

	public String getBuilding() {
		return building;
	}
}
