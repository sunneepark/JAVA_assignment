package week2;

//���� 1�� �ַ��
public class Source1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int Original[][]= { //����� ���ÿ� �ʱⰪ ����
				{1,2,3},
				{4,5,6}
		};
		int Transpose[][]=new int[Original[1].length][Original.length]; //����� ���ÿ� �迭 �Ҵ�
		
		System.out.println("Original: ");
		for(int i=0;i<Original.length;i++) {
			for(int j=0;j<Original[i].length;j++) {
				Transpose[j][i]=Original[i][j];//��� ���� �ٲپ� ����
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

