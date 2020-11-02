package equipment;

import java.util.ArrayList;

import repetitiveStuff.Tab;

/**
 * Creates the List for all Materials available. Puts them all into a ArrayList and separates them by Type.
 * 
 * @author Batuh
 *
 */
public enum MaterialsForEquipment {
	KAMPFLEDER(2, MaterialType.FABRIC, 0, 10), SEIDE(8, MaterialType.FABRIC, 0, 12), MYSTISCHESLEDER(5, MaterialType.FABRIC, 0, 15), LEDER(20, MaterialType.FABRIC, 0, 18), GEHAERTETESLEDER(11, MaterialType.FABRIC, 0, 20), GESCHUPPTESLEDER(10, MaterialType.FABRIC, 0, 22),
	DRACHENLEDER(50, MaterialType.FABRIC, 0, 27), FELLLEDER(50, MaterialType.FABRIC, 0, 24), GESTACHELTESLEDER(20, MaterialType.FABRIC, 0, 25), GOLEMLEDER(100, MaterialType.FABRIC, 0, 30), WYVERNSEIDE(200, MaterialType.FABRIC, 0, 32), ALCHEMIESEIDE(1000, MaterialType.FABRIC, 0, 35),
	KUPFER(2, MaterialType.METAL, 2, 2), STAAL(8, MaterialType.METAL, 7, 7), EISEN(5, MaterialType.METAL, 4, 3), DIAMANT(20, MaterialType.METAL, 12, 10), SILBER(11, MaterialType.METAL, 10, 8), GOLD(10, MaterialType.METAL, 6, 5), VERSTAERKTVERHAERTETESGESTEIN(20, MaterialType.METAL, 20, 30),
	METALVERBUND(20, MaterialType.METAL, 20, 25), MITHRIL(20, MaterialType.METAL, 30, 30), MOONDSTEIN(20, MaterialType.METAL, 40, 45), LEHM(20, MaterialType.METAL, 10, 2), REINESGESTEIN(20, MaterialType.METAL, 30, 40), SANDSTEIN(20, MaterialType.METAL, 12, 4),
	GEHEIMELEGIERUNG(20, MaterialType.METAL, 50, 55), GRANIT(20, MaterialType.METAL, 6, 6), OBSIDIAN(20, MaterialType.METAL, 60, 50), URALTESHOLZ(20, MaterialType.WOOD, 40, 0), KRISTALLHOLZ(20, MaterialType.WOOD, 70, 0), DUNKELHOLZ(20, MaterialType.WOOD, 5, 0),
	DRUIDENHOLZ(20, MaterialType.WOOD, 5, 0), ELFENHOLZ(20, MaterialType.WOOD, 5, 0), STEINHOLZ(20, MaterialType.WOOD, 65, 0), HEILIGESHOLZ(20, MaterialType.WOOD, 60, 0), HOLZ(20, MaterialType.WOOD, 1, 0), LEBENSWURZEL(20, MaterialType.WOOD, 20, 0);
	/**
	 * Generates a List with all Materials from one Type.
	 * 
	 * @param type The type that the list should be sorted after.
	 * @return Retunrs the list with all Materials from one Type.
	 */
	public static ArrayList<MaterialsForEquipment> getType(MaterialType type) {
		ArrayList<MaterialsForEquipment> list = new ArrayList<MaterialsForEquipment>();

		for (MaterialsForEquipment mat : MaterialsForEquipment.values()) {
			if (mat.type == type) {
				list.add(mat);
			}
		}
		return list;
	}

	public static MaterialType getMaterialType(MaterialsForEquipment a) {
		return a.type;
	}

	/**
	 * Create a string that looks nice in the console.
	 * 
	 * @param e the Object that has materials in them.
	 * @return returns a string that is nice to look at in the console.
	 */
	public String getMaterialValues(Equipment e) {
		String values = Tab.left(20, e.getItemName()) + Tab.left(20, this.getName()) + Tab.left(20, e.getTotalCost() + "") + Tab.left(20, e.getDMG() + "") + Tab.left(20, e.getDEF() + "") + Tab.left(20, e.getAmount() + "");
		return values;
	}

	/**
	 * Sets the price for the material.
	 */
	private final int price;
	/**
	 * Sets the name for the material.
	 */
	private final String name;
	/**
	 * Sets the the type for the material.
	 */
	private final MaterialType type;
	/**
	 * Sets the damage value for the material.
	 */
	private final int dmgValues;
	/**
	 * Sets the defense value for the material.
	 */
	private final int defValues;

	/**
	 * This constructor saves the values of all the enums,
	 * 
	 * @param price     the price of the material.
	 * @param type      the type that the material belongs to
	 * @param dmgValues the damage value that this material delivers.
	 * @param defValues the defense value that this material delivers
	 */
	private MaterialsForEquipment(int price, MaterialType type, int dmgValues, int defValues) {
		this.price = price;
		this.name = this.toString();
		this.type = type;
		this.defValues = defValues;
		this.dmgValues = dmgValues;
	}

	public int getPrice() {
		return price;
	}

	public enum MaterialType {
		METAL, WOOD, FABRIC;

	}

	public int getDMGMat() {
		return dmgValues;
	}

	public int getDEFMat() {
		return defValues;
	}

	public String getName() {
		return name;
	}
}
