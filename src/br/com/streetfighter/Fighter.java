package br.com.streetfighter;

public abstract class Fighter {
	private String name;
	private double power;
	private double life;
	private Special special;

	public Fighter(String name, double life, double power, Special special) {
		this.name = name;
		this.life = life;
		this.power = power;
		this.special = special;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getLife() {
		return life;
	}

	public void setLife(double life) {
		this.life = life;
	}

	public double getPower() {
		return power;
	}

	public void setPower(double power) {
		this.power = power;
	}

	public Special getSpecial() {
		return special;
	}

	public void setSpecial(Special special) {
		this.special = special;
	}

	public abstract void takeLife(Fighter fighter);

	public abstract void attack(Fighter fighter);

	public abstract void useSpecialPower(Fighter fighter);
}
