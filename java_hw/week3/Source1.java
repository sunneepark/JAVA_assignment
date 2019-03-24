package week3;

//문제1번 솔루션
public class Source1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int a = 653;
		
		//10으로 나누어 일의자리를 버리고 다시 10 을 곱한 후 2를 더해줌.
		System.out.println(a/10*10 +2); 
		
		//큰 수중 가장 가까운 10의 배수에서 뺀 값은 10에서 일의자리를 빼면 됨.
		System.out.println(10-a%10);
	}

}
