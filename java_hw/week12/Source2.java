package ex12;

import java.util.ArrayList;

class Fruit {public String toString() {return "Fruit";}}
class Apple extends Fruit {public String toString() {return "Apple";}}
class Grape extends Fruit {public String toString() {return "Grape";}}

class Juice{
	String name;
	Juice(String name) {this.name=name+"Juice";}
	public String toString() {return name;}
}
class Juicer{
	static Juice makeJuice(FruitBox <? extends Fruit> box) { //와일드 카드 사용하여 과일클래스를 상속클래스로 갖은 클래스만
		String tmp="";
		for(Fruit f:box.getList())
			tmp+=f+" ";
		return new Juice(tmp);
	}
}
class FruitBox<T extends Fruit> extends Box<T>{} //제한된 제레닉 클래스
class Box<T>{
	ArrayList <T> list= new ArrayList<T>();
	
	void add(T item) {list.add(item);} //박스에 저장
	T get(int i) {return list.get(i);} //i번째 요소 반환
	ArrayList <T> getList() {return list;} //list 반환
	int size() {return list.size();} //list 크기 반환
	
	public String toString() {return list.toString();}
}
public class Source2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		FruitBox<Fruit> fruitBox = new FruitBox<Fruit>();
		FruitBox<Apple> appleBox = new FruitBox<Apple>();
		
		
		fruitBox.add(new Apple());
		fruitBox.add(new Grape());
		appleBox.add(new Apple());
		appleBox.add(new Apple());
		
		System.out.println(Juicer.makeJuice(fruitBox));
		System.out.println(Juicer.makeJuice(appleBox));
	}

}
