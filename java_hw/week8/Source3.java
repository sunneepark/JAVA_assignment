package ex08;

import java.util.ArrayList;

public class Source3 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ArrayList list1=new ArrayList(); //���� 1,2,3,4
		ArrayList list2=new ArrayList(); //����  3,4,5,6
		ArrayList kyo=new ArrayList(); //������
		ArrayList cha=new ArrayList(); //������
		ArrayList hap=new ArrayList(); //������
		
		list1.add(1);	
		list1.add(2);	
		list1.add(3);	
		list1.add(4);

		list2.add(3);	
		list2.add(4);	
		list2.add(5);	
		list2.add(6);
		
		kyo.addAll(list1);
		kyo.retainAll(list2);
		
		cha.addAll(list1);
		cha.removeAll(kyo);
		
		hap.addAll(cha);
		hap.addAll(list2);
		
		System.out.println("list1="+list1);
		System.out.println("list2="+list2);
		System.out.println("���� {1,2,3,4} �� ���� {3,4,5,6} �� ������="+kyo);
		System.out.println("���� {1,2,3,4} �� ���� {3,4,5,6} �� ������="+cha);
		System.out.println("���� {1,2,3,4} �� ���� {3,4,5,6} �� ������="+hap);
		
	}

}
