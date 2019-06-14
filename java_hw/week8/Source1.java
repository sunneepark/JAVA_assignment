package ex08;

interface Collection{
	void add(Object obj); //큐에서 obj 데이터 추가
	
	void delete(); //큐에서 데이터 삭제
	
	void find(Object obj); //큐에서 obj 데이터가 있는지 찾기
	
	int currentCount(); //큐에서 현재 몇개의 데이터가 있는지 찾기
}
class Link{
	Object data; //실제 데이터
	Link next; //다음 데이터를 읽기 위한 연결고리
	
	Link(Object d, Link n){
		data=d; //실제 데이터 값 설정
		next=n; //연결 고리 설정
	}
}
class queue implements Collection{
	 
	private Link head=null;
	private Link tail=null;
	private Link ptr=null;
	private int count=0;
	
	@Override
	public void add(Object obj) {
		// TODO Auto-generated method stub
		Link temp = new Link(obj,null);
		if(tail == null) {
			head = temp;
			tail = temp;
		}else {
			tail.next = temp;
			tail = temp;
		}
		count++;
		System.out.println(obj + " is added.");
	}

	@Override
	public void delete() {
		// TODO Auto-generated method stub
		if(head == null){ 
			 System.out.println("Queue is empty.");
		}
		else {
			System.out.println(head.data + " is deleted.");
			head = head.next;
			count--;
		}
	}

	@Override
	public void find(Object obj) {
		// TODO Auto-generated method stub
		int i=0;
		ptr = head;
		while(ptr != null) {
			i++;
			if(ptr.data == obj) {
				System.out.println(obj + " is "+i+"th queue's data.");
				return;					
			}
			else {
				ptr =ptr.next;
			}
		}
		System.out.println("There is no " + obj +" in queue.");
	}

	@Override
	public int currentCount() {
		// TODO Auto-generated method stub
		if(count == 0) System.out.println("Queue is empty.");
		else System.out.println(count + " Objects are found.");
		return count;
	}
	
}
public class Source1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("Queue simulator start.");
		
		queue q = new queue();
		
		Integer a = new Integer(1);

		q.add(new Integer(1));
		q.add(a);
		q.add(new Integer(5));
		
		q.currentCount();
		q.find(new Integer(5));
		q.find(a);

		q.delete();
		q.delete();
		q.delete();
		
		q.currentCount();
		
		System.out.println("Queue simulator end.");
	}

}
