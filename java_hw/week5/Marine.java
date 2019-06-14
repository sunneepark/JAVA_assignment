package ex05;

public class Marine {
	private int x;
	private int y;
	private int hp;
	private static int weapon=6; //공격력
	private static int armor=1; //방어력
	
	public Marine() { 
		this.x=0;
		this.y=0; 
		this.hp=50;
	}
	public int getX() {
		return x;
	}
	public int getY() {
		return y; 
	}
	public int getHp() { 
		return hp;
	}
	public void move(int x, int y) {
		this.x += x;
		this.y += y;
	}
	public void reduceHp() {
		this.hp -= 2;
	}
	static void weaponUp() {
		weapon++;
	}
	static void armorUp() {
		armor++;
	}
	static int getArmor() {
		return armor;
	}
	static int getWeapon() {
		return weapon;
	}
}
