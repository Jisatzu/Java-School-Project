package armor;

import equipment.MaterialsForEquipment;
import equipment.TheArmorEquipment;

/**
 * This Class is for all Chest that are used in this Game. It extends TheArmorEquipment.
 * 
 * @author Batuhan.Avci
 *
 */
public class Chest extends TheArmorEquipment {
	/**
	 * Set's the base Damage for all Chest.
	 */
	private static int basedmg = 0;
	/**
	 * Set's the base Armor for all Chest.
	 */
	private static int baseDef = 4;
	/**
	 * Set's the basecost for all chests.
	 */
	private static int price = 7;
	private static String name = "Chest";

	/**
	 * The Constructor to create a Chest.
	 * 
	 * @param name     The Name for the Chest.
	 * @param amount   The Available amount that are existing.
	 * @param material The Material that is used to create the Chest.
	 */
	public Chest(int amount, MaterialsForEquipment material) {
		super(name, amount, price, material, baseDef + material.getDEFMat(), basedmg + material.getDMGMat());
	}
}
