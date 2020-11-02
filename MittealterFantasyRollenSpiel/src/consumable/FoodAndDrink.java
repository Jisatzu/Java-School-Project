package consumable;

import bodyEquip.PouchForConsumable;

public class FoodAndDrink extends PouchForConsumable {

	/**
	 * This constructor creates every consumable items that are not potions.
	 * 
	 * @param name          The name of the consumable
	 * @param amount        the amount of that item available.
	 * @param price         the price of that item
	 * @param type          the consumable type of that item
	 * @param healtRecovery the amount of health it recovers
	 * @param manaRecovery  the amount of mana it recovers.
	 */
	public FoodAndDrink(String name, int amount, int price, Consumable type, int healtRecovery, int manaRecovery) {
		super(name, amount, price, type, healtRecovery, manaRecovery);
	}
}
