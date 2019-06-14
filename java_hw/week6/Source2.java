package ex06;

import ex05.Matrix;

public class Source2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//m1 입력받기
		Matrix m1=new Matrix();
		m1.initInput();
		m1.printMat();
		
		//m2 입력받기
		Matrix m2=new Matrix();
		m2.initInput();
				
		//m1의 상수배
		Matrix.Multiply(m1,3).printMat();
				
		//m1과 m2의 곱
		Matrix.Multiply(m1,m2).printMat();
				
	}

}