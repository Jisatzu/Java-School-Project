package skills;

import java.util.ArrayList;

import consolereader.ConsoleReader;
import repetitiveStuff.Error_Systemouts;
import repetitiveStuff.checkAndleaveFuncitons;

public abstract class SkillTree {

	public static ArrayList<Skill> createEnemieSkills(String name, int cd, int manacost, int value, ArrayList<Skill> list, boolean DEF) {
		if (DEF) {
			list.add(new DEFSkills(name, cd, manacost, 0, value, true, null));
		} else if (!DEF) {
			list.add(new DMGSkills(name, cd, manacost, 0, value, true, null));
		}
		return list;
	}

	public static ArrayList<Skill> createEnemieHYBRIDSkills(String name, int cd, int manacost, int dmg, int def, ArrayList<Skill> list) {
		list.add(new HYBRIDSkills(name, cd, manacost, 0, def, dmg, true, null));
		return list;
	}

	public static ArrayList<Skill> createPlayerSkills(String name, int cd, int manacost, int tierLVL, int value, boolean learned, Positions position, ArrayList<Skill> list, boolean DEF) {
		if (DEF) {
			list.add(new DEFSkills(name, cd, manacost, tierLVL, value, learned, position));
		} else if (!DEF) {
			list.add(new DMGSkills(name, cd, manacost, tierLVL, value, learned, position));
		}
		return list;
	}

	public static ArrayList<Skill> createPlayerHYBRIDSkills(String name, int cd, int manacost, int tierLVL, int dmg, boolean learned, Positions position, int def, ArrayList<Skill> list) {
		list.add(new HYBRIDSkills(name, cd, manacost, tierLVL, def, dmg, learned, position));
		return list;
	}

	/**
	 * 
	 * @param hybridSkill
	 * @param defSkill
	 */
	public static void createSkillTree(boolean hybridSkill, boolean defSkill, ArrayList<Skill> list) {
		ArrayList<Integer> skillindex = new ArrayList<Integer>();
		if (hybridSkill && !defSkill) {
			for (Skill skill : list) {
				if (skill instanceof HYBRIDSkills) {
					skillindex = skillOutput(skill, skillindex, list);
				}
			}
		} else if (defSkill && !hybridSkill) {
			for (Skill skill : list) {
				if (skill instanceof DEFSkills) {
					skillindex = skillOutput(skill, skillindex, list);
				}
			}
		} else {
			for (Skill skill : list) {
				if (skill instanceof DMGSkills) {
					skillindex = skillOutput(skill, skillindex, list);
				}
			}
		}
		skilllearning(skillindex, list);
	}

	/**
	 * Lets the Play choose the skill that he want's to learn.
	 * 
	 * @param skillindex
	 */
	private static void skilllearning(ArrayList<Integer> skillindex, ArrayList<Skill> list) {
		boolean m;
		do {
			System.out.println("What Skill do you want to learn?");
			int c = 0;
			for (Integer a : skillindex) {
				c = skillindex.indexOf(a) + 1;
				System.out.println(c + " " + list.get(skillindex.get(c - 1)).getName());
			}
			m = checkAndleaveFuncitons.playerInputInteger(ConsoleReader.readInteger(""), skillindex.size() + 1, null);
			if (m) {
				list.get(skillindex.get(c - 1)).setLearned(true);
				System.out.println("You have succesfully learned the Skill " + list.get(skillindex.get(c - 1)).getName());
			}
		} while (!m);
	}

	/**
	 * This Method is for checking if the skill is from the lowest tier.
	 * 
	 * @param skill      The skill that is getting checked
	 * @param skillindex The list with all real indexes of all skills.
	 * @return
	 */
	private static ArrayList<Integer> skillOutput(Skill skill, ArrayList<Integer> skillindex, ArrayList<Skill> list) {
		if (skill.getTierlvl() == 1 && !skill.getLearned()) {
			skillindex.add(list.indexOf(skill));
		} else if (skill.getTierlvl() == 2 && !skill.getLearned()) {
			higherSkillOutput(skill, skillindex, list);
		} else if (skill.getTierlvl() == 3 && !skill.getLearned()) {
			higherSkillOutput(skill, skillindex, list);
		}
		return skillindex;
	}

	/**
	 * This Method is for making sure that the skills are not learned and a skill from before is learned to be learned.
	 * 
	 * @param skill      The Skill that is in checking
	 * @param skillindex The list where all the indexes of the real list are saved.
	 * @return Returns the list with all the real indexes of all skills.
	 */
	private static ArrayList<Integer> higherSkillOutput(Skill skill, ArrayList<Integer> skillindex, ArrayList<Skill> list) {
		if (skill.getPos() == Positions.POSITIONSL2 || skill.getPos() == Positions.POSITIONSL3) {
			if (list.get(list.indexOf(skill) - 3).getLearned() || list.get(list.indexOf(skill) - 2).getLearned() || list.get(list.indexOf(skill) + 1).getLearned()) {
				skillindex.add(list.indexOf(skill));
			}
		} else if (skill.getPos() == Positions.POSITIONSM2 || skill.getPos() == Positions.POSITIONSM3) {
			if (list.get(list.indexOf(skill) - 2).getLearned() || list.get(list.indexOf(skill) - 3).getLearned() || list.get(list.indexOf(skill) - 4).getLearned() || list.get(list.indexOf(skill) - 1).getLearned() || list.get(list.indexOf(skill) + 1).getLearned()) {
				skillindex.add(list.indexOf(skill));
			}
		} else if (skill.getPos() == Positions.POSITIONSR2 || skill.getPos() == Positions.POSITIONSR3) {
			if (list.get(list.indexOf(skill) - 3).getLearned() || list.get(list.indexOf(skill) - 4).getLearned() || list.get(list.indexOf(skill) - 1).getLearned()) {
				skillindex.add(list.indexOf(skill));
			}
		} else {
			Error_Systemouts.Error();
		}
		return skillindex;
	}
}