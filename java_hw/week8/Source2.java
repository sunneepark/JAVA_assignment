package ex08;

public class Source2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//2-1) String sql
		String sql = "Insert into DEPT ";
		System.out.println(sql);
		
		sql += "values";
		System.out.println(sql);
		
		sql += "(";
		System.out.println(sql);
		
		sql += "'2016', ";
		System.out.println(sql);
		
		sql += "'홍길동', ";
		System.out.println(sql);
		
		sql += "'20";
		System.out.println(sql);
		
		sql += ")";
		System.out.println(sql);
		
		//2-1)Stringbuffer sql
		StringBuffer sb = new StringBuffer("Insert into DEPT ");
		System.out.println(sb);

		sb.append("values");
		System.out.println(sb);

		sb.append("(");
		System.out.println(sb);

		sb.append("'2016', ");
		System.out.println(sb);

		sb.append("'홍길동', ");
		System.out.println(sb);

		sb.append("'20'");
		System.out.println(sb);

		sb.append(")");
		System.out.println(sb);

		//2-2) String buffer, String using replace method
		String str = new String("hello java");
		StringBuffer sb2 = new StringBuffer("hello java");

		sb2.replace(0,1,"H"); 				//sb2 객체를 다시 반환함.
		String str2=str.replace('h','H'); //이전 객체에서 새로운 객체를 만들면서 바꿈.

		System.out.println(sb2 );
		System.out.println(str2);

	}

}
