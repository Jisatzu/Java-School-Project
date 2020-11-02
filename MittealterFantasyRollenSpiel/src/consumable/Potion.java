package consumable;

import bodyEquip.PouchForConsumable;

public class Potion extends PouchForConsumable {

	public Potion(String name, int amount, int price, Consumable type, int healthrecovery, int manarecovery) {
		super(name, amount, price, type, healthrecovery, manarecovery);
	}

}
