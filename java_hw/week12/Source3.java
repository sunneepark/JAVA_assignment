package ex12;

import java.util.ArrayList;

class NewClass{
	int newField;
	int getNewField() {
		return newField;
	}

	@Deprecated
	@SuppressWarnings("deprecation")
	int oldField;
	int getOldField() {
		return oldField;
	}
}
public class Source3 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		NewClass nc=new NewClass();
		
		nc.oldField=10;
		System.out.println(nc.getOldField());
		
		@SuppressWarnings("rawtypes")
		ArrayList<NewClass> list =new ArrayList();
		list.add(nc);
	}

}

