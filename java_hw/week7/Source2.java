package ex07;

interface OpenCloseIf{
	void open();
	void close();
}
class Door implements OpenCloseIf{
	public void open() {
		System.out.println("Door open");
	}
	public void close() {
		System.out.println("Door close");
	}
}
class Bottle implements OpenCloseIf{
	public void open() {
		System.out.println("Bottle open");
	}
	public void close() {
		System.out.println("Bottle close");
	}
}
public class Source2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Door d = new Door();
		d.open();
		d.close();
		Bottle b=new Bottle();
		b.open();
		b.close();
	}

}
