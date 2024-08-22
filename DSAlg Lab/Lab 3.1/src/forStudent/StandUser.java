package forStudent;

import logic.main;

public class StandUser extends Character {
	private int maxHp;
	private int currentHp;
	private boolean isGuard = false;
	private Stand stand = null;

	public StandUser(String name, int hp, String quote, int strength, int defense) {
		super(name, quote, strength, defense);
		this.maxHp = Math.max(hp, 1);
		this.currentHp = Math.max(hp, 1);
	}

	public int takeDamage(int damage) {
		int TotalDefense;
		if (stand == null) {
			TotalDefense = this.getDefense();
		} else {
			TotalDefense = this.getDefense() + (stand.IsActive() ? stand.getDefense() : 0);
		}

		if (isGuard) {
			damage -= TotalDefense * 2;
		} else {
			damage -= TotalDefense;
		}

		damage = Math.max(damage, 0);
		currentHp = Math.max(currentHp - damage, 0);

		return damage;
	}

	public int doDamage(StandUser target) {
		return target.takeDamage(this.getStrength() + (stand.IsActive() ? stand.getStrength() : 0));
	}

	public int getMaxHp() {
		return maxHp;
	}

	public int getCurrentHp() {
		return currentHp;
	}

	public void setCurrentHp(int hp) {
		if (hp < 0) {
			this.currentHp = 0;
		} else
			this.currentHp = hp;
	}

	public boolean isGuard() {
		return isGuard;
	}

	public void setGuard(boolean isGuard) {
		this.isGuard = isGuard;
	}

	public void setStand(Stand stand) {
		this.stand = stand;
	}

	public void printShowStat() {
		System.out.println("***************************");
		System.out.println(this.getName());
		System.out.println("\"" + this.getQuote() + "\"");
		System.out.println("HP = " + this.getMaxHp());
		System.out.println("Strength = " + this.getStrength());
		System.out.println("Defense  = " + this.getDefense());
		System.out.println("***************************");
	}

	public StandUser selectStandUser() {
		printShowStat();
		main.kb.nextLine();
		System.out.println("Are you sure ? (Y/N) :");
		String special = main.kb.nextLine().trim().toLowerCase();
		boolean isSelected = special.equals("y") ? true : false;
		if (isSelected)
			return this;
		else
			return null;
	}
}
