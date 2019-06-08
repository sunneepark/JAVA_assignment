package ex07;

public class Source1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Buyer b = new Buyer();
		b.buy(new Tv());
		b.buy(new Computer());
		b.buy(new Tv());
		b.buy(new Computer());
		
		b.summary();
	}

}

class Buyer{
	int money=500;
	Product[] cart = new Product[2];
	int i=0;
	
	void buy(Product p) {
		if(money<p.price) { 
			System.out.println("�ܾ��� �����Ͽ� "+p+"�� �� �� �����ϴ�.");
			return;
		}
		else add(p);
	}
	void add(Product p) {
		if(i==cart.length) { //��ٱ��� ũ��
			Product[] temp=new Product[i];
			temp=cart;
			cart=new Product[i+2];
			System.arraycopy(temp, 0, cart, 0, temp.length);
		}
		
		cart[i++]=p;
		money -= p.price;
	}
	void summary() {
		int sum=0;
		
		System.out.print("������ ���� :");
		for(Product j:cart) {
			if(j!=null) {
				System.out.print(j+", ");
				sum+=j.price;
			}
			else
				break;
		}
			
		System.out.println("\n����� �ݾ� : "+sum);
		System.out.println("���� �ݾ� : "+money);
	}	
}
class Product{
	int price;
	Product(int price){
		this.price=price;
	}
}
class Tv extends Product{
	Tv(){
		super(100);
	}
	public String toString() {
		return "Tv";
	}
}
class Computer extends Product{
	Computer(){
		super(200);
	}
	public String toString() {
		return "Computer";
	}
}