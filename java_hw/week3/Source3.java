package week3;

//3�� �ַ��
public class Source3 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		String str="abcdef"; //abcdef ���ڿ� ����
		
		/*1�� -length �޼ҵ� �̿��Ͽ� ���ڿ� ���� ��� */
		System.out.println("1��: "+str.length()); 
		
		String str_upper="ABCDEF";
		
		/*2�� -boolean ������ ��ȯ�ϴ� equals �޼ҵ带 ���� ���ڿ� ������ �Ǵ�*/
		boolean res=str.equals(str_upper);
		
		System.out.println("2�� : "+res);
		
		/*3�� -boolean ������ ��ȯ�ϴ� equalsIgnoreCase �޼ҵ带 ���� ��ҹ��� ������� ���ڿ� ������ �Ǵ�*/
		boolean res_ignore=str.equalsIgnoreCase(str_upper);
		
		System.out.println("3��: "+res_ignore);
		
		String str_token="abc,def";
		
		/*4�� -split �̶�� �и��ϴ� �޼ҵ带 ���� ','�������� ������ arr ��� string �迭�� ����*/
		String[] arr=new String(str_token).split(",");
		
		System.out.println("4��:");
		for(String e:arr)System.out.println(e); 
		
		/*5�� -startsWith �޼ҵ� �̿��Ͽ� ���� ���ڿ��� ó�� �����ϴ��� �˻� */
		boolean res_start=str.startsWith("adf");
		
		System.out.println("5��: "+res_start);
	}

}
