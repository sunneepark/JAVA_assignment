package week2;

//문제 1번 솔루션
public class Source1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int Original[][]= { //선언과 동시에 초기값 저장
				{1,2,3},
				{4,5,6}
		};
		int Transpose[][]=new int[Original[1].length][Original.length]; //선언과 동시에 배열 할당
		
		System.out.println("Original: ");
		for(int i=0;i<Original.length;i++) {
			for(int j=0;j<Original[i].length;j++) {
				Transpose[j][i]=Original[i][j];//행과 열을 바꾸어 저장
				System.out.print(Original[i][j]+" ");
			}
			System.out.println();
		}
		
		System.out.println("Transpose: ");
		
		for(int i=0;i<Transpose.length;i++) {
			for(int j=0;j<Transpose[i].length;j++) {
				System.out.print(Transpose[i][j]+" ");
			}
			System.out.println();
		}
	}
}

