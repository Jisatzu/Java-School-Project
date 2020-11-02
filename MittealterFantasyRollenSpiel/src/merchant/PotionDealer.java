package merchant;

import java.util.ArrayList;

import actions.Merchant;
import bodyEquip.PouchForConsumable;
import bodyEquip.PouchForConsumable.Consumable;
import consumable.Potion;
import repetitiveStuff.checkAndleaveFuncitons;

public class PotionDealer extends Merchant {
	private ArrayList<PouchForConsumable> potionList;
	private int potionsShopMoney;
	private boolean leave;
	private ArrayList<Integer> indexOfRealList;

	/**
	 * The constructor to create an inn with it's innkeeper.
	 *
	 * @param Name         The name of the innkeeper
	 * @param baseHP       the HP amount of the innkeeper.
	 * @param baseArmor    the amount of base amore the innkeeper has.
	 * @param baseDmg      amount of baseDmg the innkeeper has.
	 * @param XP           amount of XP the innkeeper has.
	 * @param money        amount of money the innkeeper has.
	 * @param profession   the profession that the innkeeper has.
	 * @param goods        the goods that the inn is selling.
	 * @param building     the building name of the inn
	 * @param city         the city name where the building is.
	 * @param playablechar checks if it's a playable char or not.
	 */
	public PotionDealer(String Name, int baseHP, int baseArmor, int baseDmg, int XP, int money, String profession,
			String goods, String building, String city, boolean playablechar) {
		super(Name, baseHP, baseArmor, baseDmg, XP, money, profession, goods, building, city, playablechar);
		potionsShopMoney = money;
		randomiseAmount();
	}

	/**
	 * Let's the player choose what potion he want's and if he want's to leave.
	 *
	 * @param player The player that is buying the Potions.
	 */
	public void choosePotion() {
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
							"What type of material do you wish for? h = healthpotions | m = manapotions | l = back"));
					if (b == null && getMatChoosing()) {
						buy = checkAndleaveFuncitons.leave(buy);
					} else if (b != null) {
						indexOfRealList = new ArrayList<Integer>();
						indexOfRealList = consumValueWriter(b, potionList);
						buyingAndSelling(indexOfRealList, potionList, potionsShopMoney, false);
					}
				}
			} else if (z == 2) {
				// rest
			} else {
				leave = true;
			}
		}
	}

	/**
	 * Creates the Inventory for the inn.
	 */
	private void creatInventar() {
		potionList.add(new Potion("Sehrschlechterheiltrank", randomValueGenerator(), 30, Consumable.LEBEN, 5, 0));
		potionList.add(new Potion("Schlechterheiltrank", randomValueGenerator(), 50, Consumable.LEBEN, 10, 0));
		potionList.add(new Potion("Normalerheiltrank", randomValueGenerator(), 70, Consumable.LEBEN, 20, 0));
		potionList.add(new Potion("Guterheiltrank", randomValueGenerator(), 90, Consumable.LEBEN, 30, 0));
		potionList.add(new Potion("Himmlischerheiltrank", randomValueGenerator(), 100, Consumable.LEBEN, 40, 0));
		potionList.add(new Potion("Sehrschlechtermanatrank", randomValueGenerator(), 30, Consumable.MANA, 0, 5));
		potionList.add(new Potion("Schlechtermanatrank", randomValueGenerator(), 50, Consumable.MANA, 0, 10));
		potionList.add(new Potion("Normalermanatrank", randomValueGenerator(), 70, Consumable.MANA, 0, 20));
		potionList.add(new Potion("Gutermanatrank", randomValueGenerator(), 90, Consumable.MANA, 0, 30));
		potionList.add(new Potion("Himmlischermanatrank", randomValueGenerator(), 100, Consumable.MANA, 0, 40));
	}

	/**
	 * Method to be sure that all the lists have been renewed.
	 */
	public void randomiseAmount() {
		potionList = new ArrayList<>();
		creatInventar();
	}
}
