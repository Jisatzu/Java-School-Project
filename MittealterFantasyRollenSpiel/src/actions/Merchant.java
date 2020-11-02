package actions;

import java.util.ArrayList;
import java.util.Random;

import armor.Boot;
import armor.Chest;
import armor.Gauntlet;
import armor.Helmet;
import armor.Pants;
import bodyEquip.HandEquipment;
import bodyEquip.PouchForConsumable;
import bodyEquip.PouchForConsumable.Consumable;
import consolereader.ConsoleReader;
import consumable.FoodAndDrink;
import consumable.Potion;
import equipment.Equipment;
import equipment.MaterialsForEquipment.MaterialType;
import equipment.TheArmorEquipment;
import equipment.TheWeaponEquipment;
import people.Player;
import people.TheTownPeople;
import repetitiveStuff.Error_Systemouts;
import repetitiveStuff.VaiableInputShower;
import repetitiveStuff.checkAndleaveFuncitons;
import thebase.TheGame;
import weapon.AxeWeapon;
import weapon.BluntWeapon;
import weapon.Shield;
import weapon.SpearWeapon;
import weapon.SwordWeapon;

public abstract class Merchant extends TheTownPeople {

	public Merchant(String Name, int baseHP, int baseArmor, int baseDmg, int XP, int money, String profession,
			String goods, String building, String city, boolean playablechar) {
		super(Name, baseHP, baseArmor, baseDmg, XP, money, profession, building, goods, playablechar);
	}

	/**
	 * With this Boolean, it is checked if he want's to stop the Transaction.
	 */
	private boolean buying = false;

	/**
	 * This is the Integer that lets the player choose if he want's to sell or buy.
	 * It is possible to stop the Transaction midways too.
	 */

	public int buyOrSell(boolean inn) {
		int x = 0;
		boolean buyOrSellChoose = false;
		while (!buyOrSellChoose) {
			if (inn) {
				x = ConsoleReader.readInteger("Do you want to feast or rest? 1 = feast | 2 = rest | 3 = leave");
			} else {
				x = ConsoleReader.readInteger("Do you want to buy or sell? 1 = buy | 2 = sell | 3 = leave");
			}
			if (x == 1) {
				buyOrSellChoose = true;
			} else if (x == 2) {
				buyOrSellChoose = true;
			} else if (x == 3) {
				buyOrSellChoose = true;
			} else {
				buyOrSellChoose = false;
			}
		}
		return x;
	}

	private MaterialType matType;
	private boolean matChoosing;
	private Consumable ConsumType;

	public boolean getMatChoosing() {
		return matChoosing;
	}

	public MaterialType getMatType(Character b) {
		matChoosing = false;
		matType = null;
		if (b == 'm') {
			matType = MaterialType.METAL;
		} else if (b == 'f') {
			matType = MaterialType.FABRIC;
		} else if (b == 'w') {
			matType = MaterialType.WOOD;
		} else if (b == 'l') {
			matChoosing = true;
		} else {
			Error_Systemouts.invalidInput();
		}
		return matType;
	}

	public Consumable getConsumType(Character b) {
		matChoosing = false;
		ConsumType = null;
		if (b == 'l') {
			matChoosing = true;
		} else if (b == 'f') {
			ConsumType = Consumable.FOOD;
		} else if (b == 'd') {
			ConsumType = Consumable.DRINKS;
		} else if (b == 'm') {
			ConsumType = Consumable.DRINKS;
		} else if (b == 'h') {
			ConsumType = Consumable.DRINKS;
		} else {
			Error_Systemouts.invalidInput();
		}
		return ConsumType;
	}

	public <T> int buyingAndSelling(ArrayList<Integer> listOfRealPosition, ArrayList<T> listOfItems, int merchantMoney,
			boolean equipment) {
		int item = 0;
		int transferAmount = 0;
		Character playerCharacter = 0;
		boolean playerChoosing = false;
		boolean itemChoose = false;
		boolean amountChoose = false;
		if (equipment) {
			while (!itemChoose) {
				System.out.println("Which one do you want to buy? 0 = back");
				itemChoose = checkAndleaveFuncitons.playerInputInteger(item = ConsoleReader.readInteger("") - 1,
						listOfRealPosition.size(), null);
				if (item != -1) {
					while (!amountChoose) {
						System.out.println("How many do you want to buy? 0 = back");
						amountChoose = checkAndleaveFuncitons.playerInputInteger(
								transferAmount = ConsoleReader.readInteger(""),
								((Equipment) listOfItems.get(listOfRealPosition.get(item))).getAmount(),
								((Equipment) listOfItems.get(listOfRealPosition.get(item))).getItemName());
						if (transferAmount != 0) {
							merchantMoney = buyEquipment(transferAmount, listOfItems.get(listOfRealPosition.get(item)),
									merchantMoney, true);
						}
					}
				}
			}
			if (amountChoose && itemChoose) {
				while (!playerChoosing && getBuying()) {
					System.out.println("Who should equip this Item?");
					VaiableInputShower.playerChoosingList(TheGame.getPlayerList());
					playerChoosing = checkAndleaveFuncitons.playerChoosage(TheGame.getPlayerList(),
							Character.toLowerCase(playerCharacter = ConsoleReader.readChar("")));
				}
				if (listOfItems.get(listOfRealPosition.get(item)) instanceof TheWeaponEquipment && getBuying()) {
					TheGame.getPlayerList().get(playerCharacter)
							.equipHands((HandEquipment) listOfItems.get(listOfRealPosition.get(item)), transferAmount);// ((HandEquipment)
																														// listOfItems.get(listOfRealPosition.get(item)),
																														// transferAmount,
																														// TheGame.getPlayerList().get(playerCharacter));
				} else if (listOfItems.get(listOfRealPosition.get(item)) instanceof TheArmorEquipment && getBuying()) {
					TheGame.getPlayerList().get(playerCharacter).equipArmor(
							(TheArmorEquipment) listOfItems.get(listOfRealPosition.get(item)), transferAmount);
				}
			}
		} else {
			while (!itemChoose) {
				System.out.println("Which one do you want to buy? 0 = back");
				itemChoose = checkAndleaveFuncitons.playerInputInteger(item = ConsoleReader.readInteger("") - 1,
						listOfRealPosition.size(), null);
				if (item != -1) {
					while (!amountChoose) {
						System.out.println("How many do you want to buy? 0 = back");
						amountChoose = checkAndleaveFuncitons.playerInputInteger(
								transferAmount = ConsoleReader.readInteger(""),
								((PouchForConsumable) listOfItems.get(listOfRealPosition.get(item))).getItemAmount(),
								((PouchForConsumable) listOfItems.get(listOfRealPosition.get(item))).getItemName());
						if (transferAmount != 0) {
							merchantMoney = buyEquipment(transferAmount, listOfItems.get(listOfRealPosition.get(item)),
									merchantMoney, true);
						}
					}
				}
			}
			if (amountChoose && itemChoose) {
				while (!playerChoosing && getBuying()) {
					if (listOfItems.get(listOfRealPosition.get(item)) instanceof FoodAndDrink) {
						System.out.println("Who should consume it?");
						playerChoosing = checkAndleaveFuncitons.playerChoosage(TheGame.getPlayerList(),
								Character.toLowerCase(playerCharacter = ConsoleReader.readChar("")));
					} else if (listOfItems.get(listOfRealPosition.get(item)) instanceof Potion && getBuying()) {
						playerChoosing = !playerChoosing;
					} else {
						Error_Systemouts.Error();
					}
					VaiableInputShower.playerChoosingList(TheGame.getPlayerList());
				}
				if (listOfItems.get(listOfRealPosition.get(item)) instanceof FoodAndDrink && getBuying()) {
					TheGame.getPlayerList().get(playerCharacter).setHp(
							((PouchForConsumable) listOfItems.get(listOfRealPosition.get(item))).getHealthRecovery()
									* transferAmount);
					TheGame.getPlayerList().get(playerCharacter).setMana(
							((PouchForConsumable) listOfItems.get(listOfRealPosition.get(item))).getManaRecovery()
									* transferAmount);
				} else if (listOfItems.get(listOfRealPosition.get(item)) instanceof Potion && getBuying()) {
					Player.getPotions().add(((PouchForConsumable) listOfItems.get(listOfRealPosition.get(item))));
				}
			}
		}
		return merchantMoney;
	}

	/**
	 * Here the player buys something from the shop.
	 * 
	 * @param buyAmount the amount that is bought.
	 * @param itemName  the item name that is bought.
	 * @param amount    the quantity that is bought.
	 * @return the quantity the is bought.
	 */
	private <T> int buyEquipment(int playerBuyingAmount, T e, int merchantMoney, boolean equipment) {
		buying = false;
		Character y = ' ';
		int totalCost = playerBuyingAmount;
		if (equipment) {
			totalCost *= ((Equipment) e).getTotalCost();
			if (Player.getMoneyFromPlayer() < totalCost) {
				System.out.println("Sorry but you don't have enough money for that much.");
			} else {
				while (!buying) {
					System.out.println("Are you sure, that you want to buy " + playerBuyingAmount + " of "
							+ ((Equipment) e).getItemName() + " " + ((Equipment) e).getMaterial());
					System.out.println("It will cost you a total amount of " + totalCost + " gold.");
					buying = checkAndleaveFuncitons
							.yesAndNo(Character.toLowerCase(y = ConsoleReader.readChar("y = Yes | n = No")));
					if (y == 'n') {
						buying = false;
						break;
					}
				}
			}
		} else {
			totalCost *= ((PouchForConsumable) e).getPrice();
			if (Player.getMoneyFromPlayer() < totalCost) {
				System.out.println("Sorry but you don't have enough money for that much.");
			} else {
				while (!buying) {
					System.out.println("Are you sure, that you want to buy " + playerBuyingAmount + " of "
							+ ((PouchForConsumable) e).getItemName());
					System.out.println("It will cost you a total amount of " + totalCost + " gold.");
					buying = checkAndleaveFuncitons
							.yesAndNo(Character.toLowerCase(y = ConsoleReader.readChar("y = Yes | n = No")));
					if (y == 'n') {
						buying = false;
						break;
					}
				}
			}
		}
		if (y == 'y' && buying) {
			Player.setMoney(totalCost * -1);
			merchantMoney += totalCost;
		}
		return merchantMoney;
	}

	public void sellEquipment(boolean weapon) {
		boolean empty = false;
		int i = 1;
		if (weapon) {
			if (Player.getWeaponEquipment().size() != 0) {
				System.out.println(getItemparameters());
				for (Equipment a : Player.getWeaponEquipment()) {
					if (a.getAmount() <= 0) {
					} else {
						System.out.println((a).getValues(a, i));
						i++;
					}
				}
			} else {
				System.out.println("You have not Weapons to sell.");
				empty = true;
			}
		} else {
			if (Player.getArmorEquipment().size() != 0) {
				System.out.println(getItemparameters());
				for (Equipment a : Player.getArmorEquipment()) {
					if (a.getAmount() <= 0) {
					} else {
						System.out.println((a).getValues(a, i));
						i++;
					}
				}
			} else {
				System.out.println("You have not Armor to sell.");
				empty = true;
			}
		}
		if (!empty) {
			if (weapon) {
				System.out.println("What Item do you want to sell?");
				int f = 0;
				boolean x = false;
				while (!x) {
					x = checkAndleaveFuncitons.playerInputInteger(f = ConsoleReader.readInteger("") - 1,
							Player.getWeaponEquipment().size(), null);
				}
				System.out.println(
						"How many do you want to sell? Available = " + Player.getWeaponEquipment().get(f).getAmount());
				x = false;
				int d = 0;
				while (!x) {
					x = checkAndleaveFuncitons.playerInputInteger(d = ConsoleReader.readInteger(""),
							Player.getWeaponEquipment().get(f).getAmount() + 1, null);
				}
				Player.setMoney(Player.getWeaponEquipment().get(f).getTotalCost() * d);
				Player.getWeaponEquipment().get(f).setAmount(-d, false);
				if (Player.getWeaponEquipment().get(f).getAmount() == 0) {
					Player.getWeaponEquipment().remove(f);
				}
			} else {
				System.out.println("What Item do you want to sell?");
				int f = 0;
				boolean x = false;
				while (!x) {
					x = checkAndleaveFuncitons.playerInputInteger(f = ConsoleReader.readInteger("") - 1,
							Player.getArmorEquipment().size(), null);
				}
				System.out.println(
						"How many do you want to sell? Available = " + Player.getArmorEquipment().get(f).getAmount());
				x = false;
				int d = 0;
				while (!x) {
					x = checkAndleaveFuncitons.playerInputInteger(d = ConsoleReader.readInteger(""),
							Player.getArmorEquipment().get(f).getAmount() + 1, null);
				}
				Player.setMoney(Player.getArmorEquipment().get(f).getTotalCost() * d);
				Player.getArmorEquipment().get(f).setAmount(-d, false);
				if (Player.getArmorEquipment().get(f).getAmount() == 0) {
					Player.getArmorEquipment().remove(f);
				}
			}
		}
	}

	/**
	 * Generates a random amount from 0 to 49. This is for randoming the amount in
	 * stock in the shops.
	 * 
	 * @return the quantity in stock for an item.
	 */
	public int randomValueGenerator() {
		int randomAmount = new Random().nextInt(50);
		return randomAmount;
	}

	public ArrayList<Integer> equipmentValueWriter(Character a, MaterialType mat, ArrayList<Equipment> allEquipment) {
		ArrayList<Integer> indexOfRealList = new ArrayList<Integer>();
		int c = 1;
		System.out.println(getItemparameters());
		for (Equipment po : allEquipment) {
			if (po instanceof TheWeaponEquipment) {
				if (po.getMatType() == mat) {
					switch (a) {
					case 'a':
						if (po instanceof AxeWeapon) {
							System.out.println(po.getValues(po, c));
							indexOfRealList.add(allEquipment.indexOf(po));
							c++;
						}
						break;
					case 's':
						if (po instanceof SwordWeapon) {
							System.out.println(po.getValues(po, c));
							indexOfRealList.add(allEquipment.indexOf(po));
							c++;
						}
						break;
					case 'd':
						if (po instanceof Shield) {
							System.out.println(po.getValues(po, c));
							indexOfRealList.add(allEquipment.indexOf(po));
							c++;

						}
						break;
					case 'p':
						if (po instanceof SpearWeapon) {
							System.out.println(po.getValues(po, c));
							indexOfRealList.add(allEquipment.indexOf(po));
							c++;
						}
						break;
					case 'b':
						if (po instanceof BluntWeapon) {
							System.out.println(po.getValues(po, c));
							indexOfRealList.add(allEquipment.indexOf(po));
							c++;
						}
						break;
					}
				}
			} else {
				if (po.getMatType() == mat) {
					switch (a) {
					case 'b':
						if (po instanceof Boot) {
							System.out.println(po.getValues(po, c));
							indexOfRealList.add(allEquipment.indexOf(po));
							c++;
						}
						break;
					case 'c':
						if (po instanceof Chest) {
							System.out.println(po.getValues(po, c));
							indexOfRealList.add(allEquipment.indexOf(po));
							c++;
						}
						break;
					case 'h':
						if (po instanceof Helmet) {
							System.out.println(po.getValues(po, c));
							indexOfRealList.add(allEquipment.indexOf(po));
							c++;
						}
						break;
					case 'g':
						if (po instanceof Gauntlet) {
							System.out.println(po.getValues(po, c));
							indexOfRealList.add(allEquipment.indexOf(po));
							c++;
						}
						break;
					case 'p':
						if (po instanceof Pants) {
							System.out.println(po.getValues(po, c));
							indexOfRealList.add(allEquipment.indexOf(po));
							c++;
						}
						break;
					}
				}
			}
		}
		return indexOfRealList;
	}

	public ArrayList<Integer> consumValueWriter(Consumable mat, ArrayList<PouchForConsumable> allEquipment) {
		ArrayList<Integer> indexOfRealList = new ArrayList<Integer>();
		int c = 1;
		System.out.println(getItemparameters());
		for (PouchForConsumable po : allEquipment) {
			if (po.getConsumableType() == mat) {
				System.out.println(((PouchForConsumable) po).getValues((PouchForConsumable) po, c));
				indexOfRealList.add(allEquipment.indexOf(po));
				c++;
			}
		}
		return indexOfRealList;
	}

	private boolean getBuying() {
		return buying;
	}
}
