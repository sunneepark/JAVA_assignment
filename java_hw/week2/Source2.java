package week2;

import java.util.Scanner; //scanner Ŭ������ ���� ��Ű�� import

//���� 2�� �ַ��
public class Source2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scanner = new Scanner(System.in); //��ĳ�� Ŭ���� ����
		
		System.out.println("ȭ���µ��� �Է��ϼ���: ");
		int fahrenheit=scanner.nextInt(); //ȭ���µ� ������ �Է� �ޱ�
		
		System.out.println("Fahrenheit: "+fahrenheit);
		
		/*case 1*/
		float c=5/9f * (fahrenheit - 32); //'f'�� ���� float ����ȯ �����ν� ������ �� 0�� ���� ����
		System.out.printf("Celsius: %.2f",c); //�Լ�'printf' �� ���� ������
		
		/*case 2*/
		String celcius= String.format("%.2f", c); //string Ŭ������ format �Լ��� ���� ������
		System.out.println("Celcius: "+celcius);
		
		/*case 3*/
		double c_d=5.0/9 *(fahrenheit-32); //.0�� ���� double ����ȯ ...
		System.out.println("Celsius: "+(int)(c*100 + 0.5) / 100.0); //����� ���� �ݿø�
		
		/*case 4*/
		System.out.println("Celcius: "+Math.round(c_d*100)/100.0); //math.round �Լ��� ���� �ݿø�
		
		scanner.close();
	}
}
