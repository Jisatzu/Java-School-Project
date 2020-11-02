package armor;

import equipment.MaterialsForEquipment;
import equipment.TheArmorEquipment;

/**
 * This Class is for all Gauntlets that are used in this Game. It extends TheArmorEquipment.
 * 
 * @author Batuhan.Avci
 *
 */
public class Gauntlet extends TheArmorEquipment {
	/**
	 * Set's the base Damage for all Gauntlets.
	 */
	private static int basedmg = 0;
	/**
	 * Set's the base Armor for all Gauntlets.
	 */
	private static int baseDef = 1;
	private static int price = 4;
	private static String name = "Gauntlet";

	/**
	 * The Constructor to create a Gauntlets.
	 * 
	 * @param name     The Name for the Gauntlets.
	 * @param amount   The Available amount that are existing.
	 * @param material The Material that is used to create the Gauntlets.
	 */
	public Gauntlet(int amount, MaterialsForEquipment material) {
		super(name, amount, price, material, baseDef + material.getDEFMat(), basedmg + material.getDMGMat());
	}
}
