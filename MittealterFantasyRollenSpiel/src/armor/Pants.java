package armor;

import equipment.MaterialsForEquipment;
import equipment.TheArmorEquipment;

/**
 * This Class is for all Pants that are used in this Game. It extends TheArmorEquipment.
 * 
 * @author Batuhan.Avci
 *
 */
public class Pants extends TheArmorEquipment {
	/**
	 * Set's the base Damage for all Pants.
	 */
	private static int basedmg = 0;
	/**
	 * Set's the base Armor for all Pants.
	 */
	private static int baseDef = 1;
	/**
	 * Set's the base Cost for all Pants to 10.
	 */
	private static int price = 10;
	private static String name = "Pants";

	/**
	 * The Constructor to create a Pants.
	 * 
	 * @param name     The Name for the Pants.
	 * @param amount   The Available amount that are existing.
	 * @param material The Material that is used to create the Pants.
	 */

	public Pants(int amount, MaterialsForEquipment material) {
		super(name, amount, price, material, baseDef + material.getDEFMat(), basedmg + material.getDMGMat());
	}
}
