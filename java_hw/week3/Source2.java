package week3;

import java.util.Scanner; //Scanner Ŭ������ ���� ��Ű��

//���� 2�� �ַ��
public class Source2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
			long a = 0, b = 1, c=0;
			int i;
			
			Scanner scanner=new Scanner(System.in);
			System.out.println("�� �ױ��� ����ϰڽ��ϱ�: ");
			int n=scanner.nextInt();
			
			if(n==0) System.out.println("0��° ���� �������� �ʽ��ϴ�");
			for(i=2;i<=n+1;i++) { //n�� 1�� ������ ����� �ǰ� �� n+1 ���� ����Ѵ�.
				System.out.print(a+" ");
				c=a+b; //���� a�� b�� ���Ͽ� ���� c�� ����
				a=b; //���� b�� ���� ���� a�� �ű��.
				b=c; //���� c�� ���� ���� b�� �ű��.		
			}
			
			scanner.close();
			
	}

}
