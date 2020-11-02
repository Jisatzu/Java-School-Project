package weapon;

import bodyEquip.HandEquipment;
import equipment.MaterialsForEquipment;

/**
 * This class is for creating an Axe.
 * 
 * @author Batuhan Avci
 *
 */
public class AxeWeapon extends HandEquipment {

	public AxeWeapon(int amount, MaterialsForEquipment material, boolean oneHanded) {
		super(amount, material, oneHanded, 1);
	}

}
