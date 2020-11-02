package armor;

import equipment.MaterialsForEquipment;
import equipment.TheArmorEquipment;

/**
 * This Class is for all Helmets that are used in this Game. It extends TheArmorEquipment.
 * 
 * @author Batuhan.Avci
 *
 */
public class Helmet extends TheArmorEquipment {
	/**
	 * Set's the base Damage for all Helmets.
	 */
	private static int basedmg = 0;
	/**
	 * Set's the base Armor for all Helmets.
	 */
	private static int baseDef = 1;
	/**
	 * Set's the base Cost for all Boots to 8.
	 */
	private static int price = 8;
	private static String name = "Helmet";

	/**
	 * The Constructor to create a Helmets.
	 * 
	 * @param name     The Name for the Helmets.
	 * @param amount   The Available amount that are existing.
	 * @param material The Material that is used to create the Helmets.
	 */

	public Helmet(int amount, MaterialsForEquipment material) {
		super(name, amount, price, material, baseDef + material.getDEFMat(), basedmg + material.getDMGMat());
	}
}
