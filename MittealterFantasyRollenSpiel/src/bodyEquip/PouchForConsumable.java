package bodyEquip;

import repetitiveStuff.Tab;

/**
 * This class if for the purpose that the player can equip any kind of consumable items.
 * 
 * @author Batuhan Avci
 *
 */
public class PouchForConsumable {
	private int healthRecovery;
	private int manaRecovery;
	private String itemName;
	private int itemAmount;
	private int price;
	private Consumable consumableType;

	/**
	 * This Constructor is for all consumables that are not potions that are going into any Inventory.
	 * 
	 * @param itemName       The name of the item
	 * @param itemAmount     the amount that is available int the inventory
	 * @param price          the price that the item sells at.
	 * @param type           the type of consumable it is.
	 * @param healthRecovery the amount of health the item recovers.
	 * @param manaRecovery   the amount of mana that the item it recovers
	 */
	public PouchForConsumable(String itemName, int itemAmount, int price, Consumable type, int healthRecovery, int manaRecovery) {
		this.healthRecovery = healthRecovery;
		this.manaRecovery = manaRecovery;
		this.itemName = itemName;
		this.price = price;
		this.consumableType = type;
		this.itemAmount = itemAmount;
	}

	public enum Consumable {
		LEBEN, MANA, FOOD, DRINKS;
	}

	public String getValues(PouchForConsumable po, int i) {
		return Tab.left(10, i + "") + Tab.left(15, po.getItemName()) + Tab.left(20, po.getPrice() + "") + Tab.left(20, po.getHealthRecovery() + "") + Tab.left(20, po.getManaRecovery() + "") + Tab.left(20, po.getItemAmount() + "");
	}

	public Consumable getConsumableType() {
		return consumableType;
	}

	public int getHealthRecovery() {
		return healthRecovery;
	}

	public int getItemAmount() {
		return itemAmount;
	}

	public String getItemName() {
		return itemName;
	}

	public int getManaRecovery() {
		return manaRecovery;
	}

	public int getPrice() {
		return price;
	}

	public void setItemAmount(int itemAmount) {
		this.itemAmount += itemAmount;
	}
}
