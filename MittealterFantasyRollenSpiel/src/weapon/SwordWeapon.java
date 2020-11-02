package weapon;

import bodyEquip.HandEquipment;
import equipment.MaterialsForEquipment;

/**
 * This class is for creating an Swords.
 * 
 * @author Batuhan Avci
 *
 */
public class SwordWeapon extends HandEquipment {

	public SwordWeapon(int amount, MaterialsForEquipment material, boolean oneHanded) {
		super(amount, material, oneHanded, 5);
	}

}