package week3;

import java.util.Scanner; //Scanner 클래스를 위한 패키지

//문제 2번 솔루션
public class Source2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
			long a = 0, b = 1, c=0;
			int i;
			
			Scanner scanner=new Scanner(System.in);
			System.out.println("몇 항까지 출력하겠습니까: ");
			int n=scanner.nextInt();
			
			if(n==0) System.out.println("0번째 항은 존재하지 않습니다");
			for(i=2;i<=n+1;i++) { //n이 1일 때에도 출력이 되게 끔 n+1 까지 출력한다.
				System.out.print(a+" ");
				c=a+b; //변수 a와 b를 더하여 변수 c에 대입
				a=b; //변수 b의 값을 변수 a로 옮긴다.
				b=c; //변수 c의 값을 변수 b로 옮긴다.		
			}
			
			scanner.close();
			
	}

}
