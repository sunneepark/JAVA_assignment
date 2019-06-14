package ex13;

import java.util.ArrayList;

public class Source2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Table table=new Table(); //여러 쓰레드가 공유하는 테이블 객체
		new Thread(new Cook(table),"Cooker").start();
		new Thread(new Customer(table,"donut"),"client1").start();
		new Thread(new Customer(table,"burger"),"client2").start();
		
		try{
			Thread.sleep(5000);
		}catch(InterruptedException e) {
			System.exit(0);
		}
	}

}

class Customer implements Runnable{
	private Table table;
	private String food;
	
	Customer(Table table, String food){
		this.table=table;
		this.food=food;
	}
	public void run() {
		while(true) {
			try {
				Thread.sleep(20);
			}catch(InterruptedException e) {
				
			}
			String name=Thread.currentThread().getName();
			if(eatFood())
				System.out.println(name+" ate a "+food);
			else
				System.out.println(name + " failed to eat.:(");
		}
	}
	boolean eatFood() {
		return table.remove(food);
	}
}
class Cook implements Runnable{
	private Table table;
	
	Cook(Table table){
		this.table=table;
	}
	public void run() {
		while(true) {
			int idx=(int)(Math.random()*table.dishNum());
			table.add(table.dishNames[idx]);
			try {
				Thread.sleep(100);
			}catch(InterruptedException e) {
				
			}
		}
	}
}
class Table{
	String[] dishNames= {"donut","donut","burger"}; //음식이름
	final int MAX_FOOD=6; //테이블에 세팅될 최대 음식 개수
	private ArrayList<String> dishes=new ArrayList<String>(); //테이블에 세팅될 음식 접시
	
	public synchronized void add(String dish) {
		if(dishes.size()>=MAX_FOOD)
			return;
		dishes.add(dish);
		System.out.println("Dishes : "+dishes.toString());
	}
	public boolean remove(String dishName) {
		synchronized(this) {
			while(dishes.size()==0) {
				String name=Thread.currentThread().getName();
				System.out.println(name+" is waiting.");
				try {
					Thread.sleep(500);
				}catch(InterruptedException e) {
					
				}
			}
			for(int i=0;i<dishes.size();i++) {
				if(dishName.equals(dishes.get(i))) {
					dishes.remove(i);
					return true;
				}
			}
		}
		return false;
	}
	public int dishNum() {return dishNames.length;}
}