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
		
		sql += "'ȫ�浿', ";
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

		sb.append("'ȫ�浿', ");
		System.out.println(sb);

		sb.append("'20'");
		System.out.println(sb);

		sb.append(")");
		System.out.println(sb);

		//2-2) String buffer, String using replace method
		String str = new String("hello java");
		StringBuffer sb2 = new StringBuffer("hello java");

		sb2.replace(0,1,"H"); 				//sb2 ��ü�� �ٽ� ��ȯ��.
		String str2=str.replace('h','H'); //���� ��ü���� ���ο� ��ü�� ����鼭 �ٲ�.

		System.out.println(sb2 );
		System.out.println(str2);

	}

}
