package ex04;

import java.util.Scanner;

public class Source4 {
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String str; //�Է¹��� ���ڿ�
		Scanner sc=new Scanner(System.in);
		str=sc.next();
		
		int i=0;
		for(i=0;i<str.length();i++) //operator ã��
		{
			if(str.charAt(i)<'0'||str.charAt(i)>'9')
				break;
		}
		
		int operand1 = Integer.parseInt(str.substring(0, i));//ù��° �ǿ�����
		int operand2 = Integer.parseInt(str.substring(i+1));//�ι�° �ǿ�����
		
		switch(str.charAt(i)) { //operator �� ���� ���
		case '+':
			System.out.println(operand1+operand2);
			break;
		case '-':
			System.out.println(operand1-operand2);
			break;
		case '*':
			System.out.println(operand1*operand2);
			break;
		case '/':
			float result=(float)operand1/operand2;
			if(result==(int)result) //�������� �� �Ҽ����� ���ٸ�
				System.out.println((int)result);
			else
				System.out.println(result);
			break;
		default:
			System.out.println("���� �ʴ� �������Դϴ�.");
				
		}
	}

}
