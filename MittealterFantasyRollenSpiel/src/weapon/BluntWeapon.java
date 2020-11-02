package weapon;

import bodyEquip.HandEquipment;
import equipment.MaterialsForEquipment;

/**
 * This class is for creating an blunt Weapons.
 * 
 * @author Batuhan Avci
 *
 */
public class BluntWeapon extends HandEquipment {

	public BluntWeapon(int amount, MaterialsForEquipment material, boolean oneHanded) {
		super(amount, material, oneHanded, 2);
	}
}
