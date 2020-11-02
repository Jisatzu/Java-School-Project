package armor;

import equipment.MaterialsForEquipment;
import equipment.TheArmorEquipment;

/**
 * This Class is for all Boots that are used in this Game. It extends TheArmorEquipment.
 * 
 * @author Batuhan.Avci
 *
 */
public class Boot extends TheArmorEquipment {
	/**
	 * Set's the base Damage for all Boots.
	 */
	private static int basedmg = 0;
	/**
	 * Set's the base Armor for all Boots.
	 */
	private static int baseDef = 1;
	/**
	 * Set's the base Cost for all Boots to 5.
	 */
	private static int basePrice = 5;

	private static String name = "Boots";

	/**
	 * The Constructor to create a Boot.
	 * 
	 * @param name     The Name for the Boots.
	 * @param amount   The Available amount that are existing.
	 * @param material The Material that is used to create the Boots.
	 */
	public Boot(int amount, MaterialsForEquipment material) {
		super(name, amount, basePrice, material, baseDef + material.getDEFMat(), basedmg + material.getDMGMat());
	}
}
