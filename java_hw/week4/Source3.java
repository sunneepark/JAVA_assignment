package ex04;

public class Source3 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// 1~100 answer . ������ ������ ���� �� �� �����Ѵ�
		int answer = (int)(Math.random()*100)+1;
		int input = 0; // ������Է��� ������ ����
		int count = 0; // �õ�Ƚ���� �������� ����
		// Scanner ȭ������ ���� ������Է��� �ޱ� ���ؼ� Ŭ���� ���
		java.util.Scanner s = new java.util.Scanner(System.in);
		System.out.println(answer);
		do {
			
			System.out.print("1�� 100 ������ ���� �Է��ϼ��� : ");
			input = s.nextInt(); // input . �Է¹��� ���� ���� �� �����Ѵ�
			count++;
			
			if(answer==input) {
				System.out.println("������ϴ�.");
				System.out.println("�õ�Ƚ���� "+count+"�� �Դϴ�.");
				break;
			}
			else if(answer<input) {
				System.out.println("�� ���� ���� �Է��Ͻÿ�.");
			}
			else if(answer>input) {
				System.out.println("�� ū ���� �Է��Ͻÿ�.");
			}
		} while(true); // ���ѹݺ���

	}

}
