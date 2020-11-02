package weapon;

import bodyEquip.HandEquipment;
import equipment.MaterialsForEquipment;

/**
 * This class is for creating an Shields.
 * 
 * @author Batuhan Avci
 *
 */
public class Shield extends HandEquipment {

	public Shield(int amount, MaterialsForEquipment material) {
		super(amount, material, true, 3);
	}
}
