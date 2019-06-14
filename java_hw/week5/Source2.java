package ex05;

import java.util.ArrayList;
import java.util.Random;

public class Source2 {
	private static boolean gameOverCheck=true; //���� ���� ����
	private static ArrayList<Marine> marineList = new ArrayList<Marine>(); //���� ���� 
	
	private static int i=0;
	private static void whoMove() {
		if(marineList.size()-1 == i)
			i=0;
		else
			i++; 
	}
	private static void getMove() {
		Random r1 = new Random();
		
		Marine m = marineList.get(i);
		int direction = r1.nextInt() % 4;
		switch(direction) {
		case 0: //��
			m.move(0,1);
			break;
		case 1: //��
			m.move(0,-1);
			break;
		case 2: //��
			m.move(-1,0);
			break;
		case 3: //��
			m.move(1,0);
			break;
		}
		if(m.getX()%2 == 0)
			m.reduceHp();
		if(m.getY()%3 == 0)
			Marine.armorUp();
		
		gameOverCheck=getOver(m);
	}
	private static boolean getOver(Marine m) {
		if(m.getX()>5 || m.getY()>5 || m.getHp() <= 0)
			return false;
		
		return true;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stu
		Marine m1=new Marine();
		marineList.add(m1);
		
		Marine m2=new Marine();
		marineList.add(m2);
		
		while(gameOverCheck) {
			whoMove();
			getMove();
		}
		System.out.println("���� : "+ Marine.getArmor()+", ���ݷ� : "+Marine.getWeapon());
	}

}
