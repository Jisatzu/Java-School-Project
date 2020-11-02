package equipment;

import bodyEquip.HandEquipment;

/**
 * This class let's the programmer create an Inventory for all characters. It is possible to equip None Player Character too.
 * 
 * @author Batuhan Avci
 *
 */
public class Inventory {
	/**
	 * The constructor for the player, IF the character should not have any equipment allready.
	 */
	public Inventory() {
	}

	/**
	 * This Constructor is for all None Player Character and Character that have any kind of equipment.
	 * 
	 * @param isplayer  checks if it is a player or None Player Character.
	 * @param leftHand  checks if the weapon belongs into the left hand.
	 * @param rightHand checks if the weapon belongs into the right hand.
	 * @param bothhands checks if the weapon belongs into the right hand.
	 * @param boots     Checks if there are boots.
	 * @param chest     Checks if there is a chest to equip.
	 * @param pants     Checks if there pants to equip.
	 * @param gauntlets Checks if are gauntlets to equip.
	 * @param helmets   Checks if there is a helemt to equip.
	 */
	public Inventory(boolean isplayer, HandEquipment leftHand, HandEquipment rightHand, HandEquipment bothhands, TheArmorEquipment boots, TheArmorEquipment chest, TheArmorEquipment pants, TheArmorEquipment gauntlets, TheArmorEquipment helmets) {
		this.lefthand = leftHand;
		this.righthand = rightHand;
		this.bothhands = bothhands;
		this.pants = pants;
		this.boots = boots;
		this.chest = chest;
		this.gauntlets = gauntlets;
		this.helmet = helmets;
	}

	private HandEquipment lefthand = null;
	/**
	 * The Equipment Slot for all One Hand Weapons for the Right hand.
	 * 
	 */
	private HandEquipment righthand = null;
	/**
	 * The Equipment Slot for all Two Hand Weapons for Both hands.
	 * 
	 */
	private HandEquipment bothhands = null;
	/**
	 * * The Equipment Slot for all Pants.
	 * 
	 */
	private TheArmorEquipment pants = null;
	/**
	 * * The Equipment Slot for all Boots.
	 * 
	 */
	private TheArmorEquipment boots = null;
	/**
	 * * The Equipment Slot for all Chest.
	 * 
	 */
	private TheArmorEquipment chest = null;
	/**
	 * * The Equipment Slot for all Gauntlets.
	 * 
	 */
	private TheArmorEquipment gauntlets = null;
	/**
	 * The Equipment Slot for all Helmets.
	 */
	private TheArmorEquipment helmet = null;

	/**
	 * The Amount of Health potions available for the Unit.
	 */
	private int healthPotionAmount = 0;
	/**
	 * The Amount of Mana potions available for the Unit.
	 */
	private int manaPotionAmount = 0;
	/**
	 * The Amount of Armor the equipped Helmet delivers.
	 */
	private int helmetdef;
	/**
	 * The Amount of Damage the equipped Helmet delivers.
	 */
	private int helmetdmg;
	/**
	 * The Amount of Armor the equipped Boots delivers.
	 */
	private int bootsdef;
	/**
	 * The Amount of Damage the equipped Boots delivers.
	 */
	private int bootsdmg;
	/**
	 * The Amount of Armor the equipped Chests delivers.
	 */
	private int chestdef;
	/**
	 * The Amount of Damage the equipped Chests delivers.
	 */
	private int chestdmg;
	/**
	 * The Amount of Armor the equipped Pants delivers.
	 */
	private int pantsdef;
	/**
	 * The Amount of Damage the equipped Pants delivers.
	 */
	private int pantsdmg;
	/**
	 * The Amount of Armor the equipped Gauntlets delivers.
	 */
	private int gauntletsdef;
	/**
	 * The Amount of Damage the equipped Gauntlets delivers.
	 */
	private int gauntletsdmg;
	/**
	 * The Amount of Damage the equipped Weapon in the left hand delivers.
	 */
	private int weapondmgleft;
	/**
	 * The Amount of Armor the equipped Weapon in the left hand delivers.
	 */
	private int weapondefleft;
	/**
	 * The Amount of Armor the equipped Weapon in the right hand delivers.
	 */
	private int weapondefright;
	/**
	 * The Amount of Damage the equipped Weapon in the right hand delivers.
	 */
	private int weapondmgright;
	/**
	 * The Amount of Armor the equipped Weapon in the both hands delivers.
	 */
	private int weapondefboth;
	/**
	 * The Amount of Damage the equipped Weapon in the both hands delivers.
	 */
	private int weapondmgboth;

	/**
	 * Used to list your Item that is Equipped at the current time.
	 * 
	 * @return returns the Boots that are Equipped.
	 */
	public TheArmorEquipment getBoots() {
		return boots;
	}

	/**
	 * Used to list your Item that is Equipped at the current time.
	 * 
	 * @return returns the Chest that are Equipped.
	 */
	public TheArmorEquipment getChest() {
		return chest;
	}

	/**
	 * Used to list your Item that is Equipped at the current time.
	 * 
	 * @return returns the Gauntlets that are Equipped.
	 */
	public TheArmorEquipment getGauntlets() {
		return gauntlets;
	}

	/**
	 * Used to list your Item that is Equipped at the current time.
	 * 
	 * @return returns the Helmets that are Equipped.
	 */
	public TheArmorEquipment getHelmet() {
		return helmet;
	}

	/**
	 * Used to list your Item that is Equipped at the current time.
	 * 
	 * @return returns the Pants that are Equipped.
	 */
	public TheArmorEquipment getPants() {
		return pants;
	}

	/**
	 * Used to list your Item that is Equipped at the current time.
	 * 
	 * @return returns the Equipment from both hands.
	 */
	public HandEquipment getBothhands() {
		return bothhands;
	}

	/**
	 * Used to list your Item that is Equipped at the current time.
	 * 
	 * @return returns the Equipment from the Left hand.
	 */
	public HandEquipment getLefthand() {
		return lefthand;
	}

	/**
	 * Used to list your Item that is Equipped at the current time.
	 * 
	 * @return returns the Equipment from the Right hand.
	 */
	public HandEquipment getRighthand() {
		return righthand;
	}

	/**
	 * Get's the Equipped item for the Left hand and adds the Values of that item to the Damage and Armor value to the players Statistics.
	 * 
	 * @param Equpis the Weapon for the left hand that is chosen.
	 */
	public void equipingLeftHand(HandEquipment lefthand) {
		bothhands = null;
		if (lefthand != null) {
			this.lefthand = lefthand;
			weapondefleft = lefthand.getDEF();
			weapondmgleft = lefthand.getDMG();
			System.out.println("Sie haben " + this.lefthand.getItemName() + " ausgerüstet.");
		}
	}

	/**
	 * Get's the Equipped item for the Right hand adds the Values of that item to the Damage and Armor value to the players Statistics.
	 * 
	 * @param Equpis the Weapon for the right hand that is chosen.
	 */
	public void equipingRightHand(HandEquipment righthand) {
		bothhands = null;
		if (righthand != null) {
			this.righthand = righthand;
			weapondefright = righthand.getDEF();
			weapondmgright = righthand.getDMG();
			System.out.println("Sie haben " + righthand.getItemName() + " ausgerüstet.");
		}
	}

	/**
	 * Get's the Equipped item for Both hands and adds the Values of that item to the Damage and Armor value to the players Statistics.
	 * 
	 * @param Equpis the Weapon for the both hands that is chosen.
	 */
	public void equipingBothHands(HandEquipment bothhands) {
		lefthand = null;
		righthand = null;
		if (bothhands != null) {
			this.bothhands = bothhands;
			weapondefboth = bothhands.getDEF();
			weapondmgboth = bothhands.getDMG();
			System.out.println("Sie haben " + bothhands.getItemName() + " ausgerüstet.");
		}

	}

	/**
	 * Get's the Equipped item for Boots and adds the Values of that item to the Damage and Armor value to the players Statistics.
	 * 
	 * @param Equpis the Pants that is chosen.
	 */
	public void equipingBoots(TheArmorEquipment boots) {
		this.boots = boots;
		bootsdef = boots.getDEF();
		bootsdmg = boots.getDMG();
		System.out.println("Sie haben " + boots.getItemName() + " ausgerüstet.");
	}

	/**
	 * Get's the Equipped item for Pants and adds the Values of that item to the Damage and Armor value to the players Statistics.
	 * 
	 * @param Equpis the Pants that is chosen.
	 */
	public void equipingPants(TheArmorEquipment pants) {
		this.pants = pants;
		pantsdef = pants.getDEF();
		pantsdmg = pants.getDMG();
		System.out.println("Sie haben " + pants.getItemName() + " ausgerüstet.");
	}

	/**
	 * Get's the Equipped item for Chest and adds the Values of that item to the Damage and Armor value to the players Statistics.
	 * 
	 * @param Equpis the Chest that is chosen.
	 */
	public void equipingChest(TheArmorEquipment chest) {
		this.chest = chest;
		chestdef = chest.getDEF();
		chestdmg = chest.getDMG();
		System.out.println("Sie haben " + chest.getItemName() + " ausgerüstet.");
	}

	/**
	 * Get's the Equipped item for Gauntlets and adds the Values of that item to the Damage and Armor value to the players Statistics.
	 * 
	 * @param Equpis the Gauntlets that is chosen.
	 */
	public void equipingGauntlets(TheArmorEquipment gauntlets) {
		this.gauntlets = gauntlets;
		gauntletsdef = gauntlets.getDEF();
		gauntletsdmg = gauntlets.getDMG();
		System.out.println("Sie haben " + gauntlets.getItemName() + " ausgerüstet.");
	}

	/**
	 * Get's the Equipped item for Helmets and adds the Values of that item to the Damage and Armor value to the players Statistics.
	 * 
	 * @param Equpis the Helmets that is chosen.
	 */
	public void equipingHelmets(TheArmorEquipment helmet) {
		this.helmet = helmet;
		helmetdef = helmet.getDEF();
		helmetdmg = helmet.getDMG();
		System.out.println("Sie haben " + helmet.getItemName() + " ausgerüstet.");
	}

	public int getHealthPotionAmount() {
		return healthPotionAmount;
	}

	public int getManaPotionAmount() {
		return manaPotionAmount;
	}

	public int getBootsdef() {
		return bootsdef;
	}

	public int getBootsdmg() {
		return bootsdmg;
	}

	public int getChestdef() {
		return chestdef;
	}

	public int getChestdmg() {
		return chestdmg;
	}

	public int getGauntletsdef() {
		return gauntletsdef;
	}

	public int getGauntletsdmg() {
		return gauntletsdmg;
	}

	public int getHelmetdef() {
		return helmetdef;
	}

	public int getHelmetdmg() {
		return helmetdmg;
	}

	public int getPantsdef() {
		return pantsdef;
	}

	public int getPantsdmg() {
		return pantsdmg;
	}

	public int getWeapondefboth() {
		return weapondefboth;
	}

	public int getWeapondefleft() {
		return weapondefleft;
	}

	public int getWeapondefright() {
		return weapondefright;
	}

	public int getWeapondmgboth() {
		return weapondmgboth;
	}

	public int getWeapondmgleft() {
		return weapondmgleft;
	}

	public int getWeapondmgright() {
		return weapondmgright;
	}

}
