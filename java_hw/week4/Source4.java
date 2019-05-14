package ex04;

import java.util.Scanner;

public class Source4 {
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String str; //입력받을 문자열
		Scanner sc=new Scanner(System.in);
		str=sc.next();
		
		int i=0;
		for(i=0;i<str.length();i++) //operator 찾기
		{
			if(str.charAt(i)<'0'||str.charAt(i)>'9')
				break;
		}
		
		int operand1 = Integer.parseInt(str.substring(0, i));//첫번째 피연산자
		int operand2 = Integer.parseInt(str.substring(i+1));//두번째 피연산자
		
		switch(str.charAt(i)) { //operator 에 따라 계산
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
			if(result==(int)result) //나누었을 때 소수점이 없다면
				System.out.println((int)result);
			else
				System.out.println(result);
			break;
		default:
			System.out.println("맞지 않는 연산자입니다.");
				
		}
	}

}
