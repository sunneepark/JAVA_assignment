package ex05;

public class Source3 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		//m1 �Է¹ޱ�
		Matrix m1=new Matrix();
		m1.initInput();
		
		//m2 �Է¹ޱ�
		Matrix m2=new Matrix();
		m2.initInput();
		
		//m1�� ��ġ���
		Matrix.Transpose(m1).printMat();
		
		//m1�� m2�� ��
		Matrix.Summation(m1,m2).printMat();
		
	}

}
