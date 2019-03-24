package week2;

import java.util.Scanner; //scanner 클래스를 위한 패키지 import

//문제 2번 솔루션
public class Source2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scanner = new Scanner(System.in); //스캐너 클래스 선언
		
		System.out.println("화씨온도를 입력하세요: ");
		int fahrenheit=scanner.nextInt(); //화씨온도 정수로 입력 받기
		
		System.out.println("Fahrenheit: "+fahrenheit);
		
		/*case 1*/
		float c=5/9f * (fahrenheit - 32); //'f'를 통해 float 형변환 함으로써 나눴을 때 0이 됨을 방지
		System.out.printf("Celsius: %.2f",c); //함수'printf' 를 통해 포맷팅
		
		/*case 2*/
		String celcius= String.format("%.2f", c); //string 클래스의 format 함수를 통해 포맷팅
		System.out.println("Celcius: "+celcius);
		
		/*case 3*/
		double c_d=5.0/9 *(fahrenheit-32); //.0을 통해 double 형변환 ...
		System.out.println("Celsius: "+(int)(c*100 + 0.5) / 100.0); //계산을 통한 반올림
		
		/*case 4*/
		System.out.println("Celcius: "+Math.round(c_d*100)/100.0); //math.round 함수를 통한 반올림
		
		scanner.close();
	}
}
