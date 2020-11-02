package equipment;

/**
 * This class is made for the purpose that the Programmer can create ArrayList for weapons and that he knows that the content is for sure Weapons.
 * 
 * @author Batuhan Avci
 *
 */
public class TheWeaponEquipment extends Equipment {

	public TheWeaponEquipment(String itemName, int amount, int totalCost, int totalDMG, int totalDEF, MaterialsForEquipment material) {
		super(itemName, amount, totalCost, totalDMG, totalDEF, material);
	}
}
