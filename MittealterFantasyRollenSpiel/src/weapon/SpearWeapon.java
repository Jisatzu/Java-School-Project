package weapon;

import bodyEquip.HandEquipment;
import equipment.MaterialsForEquipment;

/**
 * This class is for creating an Spears.
 * 
 * @author Batuhan Avci
 *
 */
public class SpearWeapon extends HandEquipment {

	public SpearWeapon(int amount, MaterialsForEquipment material, boolean oneHanded) {
		super(amount, material, oneHanded, 4);
	}
}