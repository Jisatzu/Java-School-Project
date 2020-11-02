package skills;

import java.util.ArrayList;

public class Skill {

	private int cd;
	private int manacosten;
	private String name;
	private int tierlvl;
	private boolean learned;
	private Positions pos;
	private int value;
	private int DEF;
	private int DMG;
	private int ActiveCD = 0;

	public Skill(String name, int cd, int manacosten, int tierlvl, int value, boolean learned, Positions pos) {
		this.cd = cd;
		this.name = name;
		this.manacosten = manacosten;
		this.tierlvl = tierlvl;
		this.learned = learned;
		this.pos = pos;
		this.value = value;
	}

	public Skill(String name, int cd, int manacosten, int tierlvl, int DEF, int DMG, boolean learned, Positions pos) {
		this.cd = cd;
		this.name = name;
		this.manacosten = manacosten;
		this.tierlvl = tierlvl;
		this.learned = learned;
		this.pos = pos;
		this.DEF = DEF;
		this.DMG = DMG;
	}

	public void CDactivate(int cd) {
		if (ActiveCD == 0) {
			ActiveCD = cd;
		}
	}

	public void setActiveCD(boolean FightEnd) {
		if (FightEnd) {
			ActiveCD = 0;
		} else {
			ActiveCD--;
		}
	}

	public static void CDManagement(ArrayList<Skill> skilllist, boolean FightEnd) {
		for (Skill s : skilllist) {
			if (FightEnd) {
				s.setActiveCD(FightEnd);
			} else if (s.getActiveCD() != 0) {
				s.setActiveCD(FightEnd);
			}
		}
	}

	public int getActiveCD() {
		return ActiveCD;
	}

	public int getCd() {
		return cd;
	}

	public int getManacosten() {
		return manacosten;
	}

	public String getName() {
		return name;
	}

	public int getTierlvl() {
		return tierlvl;
	}

	public boolean getLearned() {
		return learned;
	}

	public void setLearned(boolean learned) {
		this.learned = learned;
	}

	public Positions getPos() {
		return pos;
	}

	public int getValue() {
		return value;
	}

	public int getDEF() {
		return DEF;
	}

	public int getDMG() {
		return DMG;
	}
}
