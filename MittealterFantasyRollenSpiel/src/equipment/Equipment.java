package equipment;

import equipment.MaterialsForEquipment.MaterialType;
import repetitiveStuff.Tab;

public class Equipment {
	private int amount;
	private String itemName;
	private int totalCost;
	private MaterialsForEquipment material;
	private MaterialType matType;
	private int DEF;
	private int DMG;

	/**
	 * This constructor is for all armor equipment that is available.
	 * 
	 * @param itemName  the name of the armor
	 * @param amount    the quantity of that armor available.
	 * @param totalcost the total cost of that item
	 * @param material  the material that the item is made of
	 * @param totalDef  the total amound of defens that the armor delivers
	 * @param totalDmg  the amount of damage that this item deleivers.
	 */
	public Equipment(String itemName, int amount, int totalcost, int totalDef, int totalDmg, MaterialsForEquipment material) {
		this.amount = amount;
		this.itemName = itemName;
		this.totalCost = totalcost + material.getPrice();
		this.DEF = totalDef;
		this.DMG = totalDmg;
		this.material = material;
		matType = MaterialsForEquipment.getMaterialType(material);
	}

	public int getAmount() {
		return amount;
	}

	public String getItemName() {
		return itemName;
	}

	public MaterialType getMatType() {
		return matType;
	}

	public MaterialsForEquipment getMaterial() {
		return material;
	}

	public int getTotalCost() {
		return totalCost;
	}

	public int getDEF() {
		return DEF;
	}

	public int getDMG() {
		return DMG;
	}

	// public void setAmount(int amount) {
	// this.amount += amount;
	// }

	public void setAmount(int amount, boolean newBuy) {
		if (newBuy) {
			this.amount = amount;
		} else {
			this.amount += amount;
		}
	}

	public String getValues(Equipment e, int i) {
		return Tab.left(10, i + "") + Tab.left(15, e.itemName) + Tab.left(40, e.material + "") + Tab.left(20, e.getTotalCost() + "") + Tab.left(20, e.getDMG() + "") + Tab.left(20, e.getDEF() + "") + Tab.left(20, e.getAmount() + "");
	}

}
