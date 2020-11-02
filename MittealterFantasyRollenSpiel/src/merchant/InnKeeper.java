package merchant;

import java.util.ArrayList;

import actions.Merchant;
import bodyEquip.PouchForConsumable;
import bodyEquip.PouchForConsumable.Consumable;
import consumable.FoodAndDrink;
import people.Player;
import repetitiveStuff.checkAndleaveFuncitons;
import thebase.TheGame;

public class InnKeeper extends Merchant {
	/**
	 * Create the list for all goods
	 */
	private ArrayList<PouchForConsumable> inventoryList;
	/**
	 * Creates the String list for all drink items.
	 */
	/**
	 * Creates the String list for all food items.
	 */
	/**
	 * Checks if the Character wan't to leave or not.
	 */
	boolean leave = false;
	/**
	 * Create amount of money that the inn has.
	 */
	private int innMoney;
	private ArrayList<Integer> indexOfRealList;

	/**
	 * The constructor to create any inn.
	 *
	 * @param Name         the name of the innkeeper.
	 * @param baseHP       the amount of health points the inn keeper has.
	 * @param baseArmor    the amount of Armor the innkeeper has.
	 * @param baseDmg      the amount of damage the innkeeper has.
	 * @param XP           the amount of xp that the innkeeper gives.
	 * @param money        the amount of money that the innkeeper has.
	 * @param profession   the profession that the mearchant has
	 * @param goods        the goods that the merchant sells
	 * @param building     the building name of the building
	 * @param city         the city where the building is placed
	 * @param playablechar checks if it's a none playable char or not.
	 */
	public InnKeeper(String Name, int baseHP, int baseArmor, int baseDmg, int XP, int money, String profession,
			String goods, String building, String city, boolean playablechar) {
		super(Name, baseHP, baseArmor, baseDmg, XP, money, profession, goods, building, city, playablechar);
		innMoney = money;
		randomiseAmount();
	}

	/**
	 * This let's the player interact with the inn.
	 *
	 * @param playerList This is needed for the bed option. else only one character
	 *                   is fully recovered.
	 * @param f          the character that get's healed by food and drinks.
	 */
	public void innInterAction() {
		int z = 0;
		leave = false;
		while (!leave) {
			z = buyOrSell(true);
			if (z == 1) {
				boolean buy = false;
				while (!buy) {
					// consume
					Consumable b;
					b = getConsumType(checkAndleaveFuncitons.charactertoSmallLetter(
							"What type of material do you wish for? d = drinks | f = food | l = back"));
					if (b == null && getMatChoosing()) {
						buy = checkAndleaveFuncitons.leave(buy);
					} else if (b != null) {
						indexOfRealList = new ArrayList<Integer>();
						indexOfRealList = consumValueWriter(b, inventoryList);
						buyingAndSelling(indexOfRealList, inventoryList, innMoney, false);
					}
				}
			} else if (z == 2) {
				Player.setMoney(10 * TheGame.getPlayerList().size());
				for (Player a : TheGame.getPlayerList().values()) {
					a.setHp(a.getPlayerMaxHP());
					a.setMana(a.getMaxMana());
				}
			} else {
				leave = true;
			}
		}
	}

	/**
	 * Creates the Inventory for the inn.
	 */
	private void creatInventar() {
		inventoryList.add(new FoodAndDrink("Brot", randomValueGenerator(), 30, Consumable.FOOD, 5, 0));
		inventoryList.add(new FoodAndDrink("Käse", randomValueGenerator(), 50, Consumable.FOOD, 10, 0));
		inventoryList.add(new FoodAndDrink("Kräutersuppe", randomValueGenerator(), 70, Consumable.FOOD, 20, 0));
		inventoryList.add(new FoodAndDrink("Hühner Keule", randomValueGenerator(), 90, Consumable.FOOD, 30, 0));
		inventoryList.add(new FoodAndDrink("Festmahl", randomValueGenerator(), 100, Consumable.FOOD, 40, 0));
		inventoryList.add(new FoodAndDrink("Milch", randomValueGenerator(), 30, Consumable.DRINKS, 0, 5));
		inventoryList.add(new FoodAndDrink("Bier", randomValueGenerator(), 50, Consumable.DRINKS, 0, 10));
		inventoryList.add(new FoodAndDrink("Met", randomValueGenerator(), 70, Consumable.DRINKS, 0, 20));
		inventoryList.add(new FoodAndDrink("Rum", randomValueGenerator(), 90, Consumable.DRINKS, 0, 30));
		inventoryList.add(new FoodAndDrink("Wein", randomValueGenerator(), 100, Consumable.DRINKS, 0, 40));
	}

	/**
	 * Method to be sure that all the lists have been renewed.
	 */
	public void randomiseAmount() {
		inventoryList = new ArrayList<>();
		creatInventar();
	}
}
