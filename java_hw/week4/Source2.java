package ex04;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Source2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String str = null;
		Scanner sc=new Scanner(System.in);
		str=sc.next();
		
		int sum = 0;
		for(int i=0; i < str.length(); i++) {
			sum += str.charAt(i)-'0';
		}
		System.out.println("sum="+sum);

	}

}
