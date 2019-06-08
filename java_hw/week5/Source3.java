package ex05;

public class Source3 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		//m1 입력받기
		Matrix m1=new Matrix();
		m1.initInput();
		
		//m2 입력받기
		Matrix m2=new Matrix();
		m2.initInput();
		
		//m1의 전치행렬
		Matrix.Transpose(m1).printMat();
		
		//m1과 m2의 합
		Matrix.Summation(m1,m2).printMat();
		
	}

}
