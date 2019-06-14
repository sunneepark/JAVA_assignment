package ex13;

import java.util.ArrayList;

public class Source3 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Table table=new Table(); //여러 쓰레드가 공유하는 객체 테이블
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
			table.remove(food);
			System.out.println(name+" ate a "+food);
			
		}
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
	String[] dishNames= {"donut","donut","burger"}; //음식 이름
	final int MAX_FOOD=6; //테이블에 세팅될 최대 음식 수
	private ArrayList<String> dishes=new ArrayList<String>(); //테이블에 세팅된 음식접시
	
	public synchronized void add(String dish) {
		if(dishes.size()>=MAX_FOOD) {
			String name=Thread.currentThread().getName();
			System.out.println(name+" is waiting");
			try {
				wait();
				Thread.sleep(500);
			}catch(InterruptedException e) {
				
			}
		}
		dishes.add(dish);
		notify();
		System.out.println("Dishes : "+dishes.toString());
	}
	public void remove(String dishName) {
		synchronized(this) {

			String name=Thread.currentThread().getName();
			
			while(dishes.size()==0) {
				System.out.println(name+" is waiting.");
				try {
					wait();
					Thread.sleep(500);
				}catch(InterruptedException e) {
					
				}
			}
			while(true) {
				for(int i=0;i<dishes.size();i++) {
					if(dishName.equals(dishes.get(i))) {
						dishes.remove(i);
						notify();
						return;
					}
				}
				try {
					System.out.println(name+" is waiting.");
					wait();
					Thread.sleep(500);
				}catch(InterruptedException e) {
				}
			}
		}
	}
	public int dishNum() {return dishNames.length;}
}