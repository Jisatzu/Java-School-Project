package equipment;

/**
 * This class is made for the purpose that the Programmer can create ArrayList for Armor and that he knows that the content is for sure Armor.
 * 
 * @author Batuhan Avci
 *
 */
public class TheArmorEquipment extends Equipment {

	public TheArmorEquipment(String itemName, int amount, int baseCost, MaterialsForEquipment material, int totalDef, int totalDmg) {
		super(itemName, amount, baseCost, totalDef, totalDmg, material);
	}

}
