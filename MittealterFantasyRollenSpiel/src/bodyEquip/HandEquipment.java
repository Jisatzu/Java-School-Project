package bodyEquip;

import equipment.MaterialsForEquipment;
import equipment.TheWeaponEquipment;

/**
 * This Class is mainly used to equip the hands of one person. All weapons are extended by this class, for the reason that all Weapons can be equipped in one or two hands.
 * 
 * @author Batuhan.Avci
 * 
 */
public class HandEquipment extends TheWeaponEquipment {
	private int weaponID;
	private boolean oneHanded;
	private MaterialsForEquipment material;

	public HandEquipment(int amount, MaterialsForEquipment material, boolean oneHanded, int weaponID) {
		super(nameGenerator(oneHanded, weaponID), amount, totalCostGenerator(oneHanded, weaponID, material),
				totalDamageGenerator(oneHanded, weaponID, material),
				totalDefenseGenerator(oneHanded, weaponID, material), material);
		this.material = material;
		this.oneHanded = oneHanded;
		this.weaponID = weaponID;
	}

	private static int totalDamageGenerator(boolean oneHanded, int weaponID, MaterialsForEquipment material) {
		int a = 0;
		if (oneHanded) {
			switch (weaponID) {
				case 1:
					a = 3 + material.getDMGMat();
					break;
				case 2:
					a = 1 + material.getDMGMat();
					break;
				case 3:
					a = 0;
					break;
				case 4:
					a = 2 + material.getDMGMat();
					break;
				case 5:
					a = 4 + material.getDMGMat();
					break;
			}
		} else {
			switch (weaponID) {
				case 1:
					a = 5 + material.getDMGMat();
					break;
				case 2:
					a = 2 + material.getDMGMat();
					break;
				case 4:
					a = 7 + material.getDMGMat();
					break;
				case 5:
					a = 6 + material.getDMGMat();
					break;
			}
		}
		return a;
	}

	private static int totalCostGenerator(boolean oneHanded, int weaponID, MaterialsForEquipment material) {
		int a = 0;
		if (oneHanded) {
			switch (weaponID) {
				case 1:
					a = 7 + material.getPrice();
					break;
				case 2:
					a = 6 + material.getPrice();
					break;
				case 3:
					a = 8 + material.getPrice();
					break;
				case 4:
					a = 5 + material.getPrice();
					break;
				case 5:
					a = 10 + material.getPrice();
					break;
			}
		} else {
			switch (weaponID) {
				case 1:
					a = 10 + material.getPrice();
					break;
				case 2:
					a = 4 + material.getPrice();
					break;
				case 4:
					a = 15 + material.getPrice();
					break;
				case 5:
					a = 16 + material.getPrice();
					break;
			}
		}
		return a;
	}

	private static int totalDefenseGenerator(boolean oneHanded, int weaponID, MaterialsForEquipment material) {
		int a = 0;
		if (oneHanded) {
			switch (weaponID) {
				case 1:
					a = 2 + material.getDEFMat();
					break;
				case 2:
					a = 1 + material.getDEFMat();
					break;
				case 3:
					a = 15 + material.getDEFMat();
					break;
				case 4:
					a = 3 + material.getDEFMat();
					break;
				case 5:
					a = 4 + material.getDEFMat();
					break;
			}
		} else {
			switch (weaponID) {
				case 1:
					a = 3 + material.getDEFMat();
					break;
				case 2:
					a = 2 + material.getDEFMat();
					break;
				case 4:
					a = 5 + material.getDEFMat();
					break;
				case 5:
					a = 6 + material.getDEFMat();
					break;
			}
		}
		return a;
	}

	private static String nameGenerator(boolean oneHanded, int weaponID) {
		String a = "";
		if (oneHanded) {
			switch (weaponID) {
				case 1:
					a = " Axe";
					break;
				case 2:
					a = " Mace";
					break;
				case 3:
					a = " Shield";
					break;
				case 4:
					a = " Spear";
					break;
				case 5:
					a = " Sword";
					break;
			}
		} else {
			switch (weaponID) {
				case 1:
					a = " Battleaxe";
					break;
				case 2:
					a = " Hammer";
					break;
				case 4:
					a = " Halberd";
					break;
				case 5:
					a = " Longsword";
					break;
			}
		}
		return a;
	}


	public boolean getOneHanded() {
		return oneHanded;
	}

	public MaterialsForEquipment getMaterial() {
		return material;
	}

	public int getWeaponID() {
		return weaponID;
	}
}
