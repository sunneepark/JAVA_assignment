package ex05;

import java.util.Scanner;
import java.util.InputMismatchException;

class NegativeException extends Exception{
	public NegativeException() {
		super("행렬의 행과 열은 0과 음수는 입력될 수 없습니다.");
	}
}  
public class Matrix {
	private int row;  
	private int col;
	private int[][] array;
	private static int array_number=0;
	
	public Matrix() {
		this.row=0;
		this.col=0;
		this.array=null;
	}
	public Matrix(int row, int col) {
		this.row=row;
		this.col=col;
		this.array=new int [row][col];
		
		array_number++;
		
		System.out.println("현재까지 생성된 행렬의 총 개수는 "+array_number+"개 입니다.");
	}
	public void initInput(){ //행렬 요소 입력받는 함수
		boolean doInput=true; //행과 열 입력 가능 여부 플래그
		Scanner sc=new Scanner(System.in);
		int Row=0; int Col=0;
		while(doInput) {
			try {
				System.out.println("행렬의 행을 입력하세요.");
				Row=inputNum(sc.nextInt());

				System.out.println("행렬의 열을 입력하세요.");
				Col=inputNum(sc.nextInt());
			}catch(NegativeException e) {
				System.out.println(e);
				continue;
			}
			doInput=false;
		}
		
		this.setRow(Row);
		this.setCol(Col);
		this.array=new int[Row][Col];
		array_number++;
		System.out.println("현재까지 생성된 행렬의 총 개수는 "+array_number+"개 입니다.");
		
		System.out.println("행렬 내부의 값을 입력해주세요.");
		int i,j,num = 0;
		for(i=0;i<this.getRow();i++) {
			for(j=0;j<this.getCol();j++) {
				try {
					System.out.println((i+1)+"행"+(j+1)+"열의 값을 입력해주세요 : ");
					num=sc.nextInt();
					this.setArr(i, j, num);
				}catch (InputMismatchException e){
					System.out.println(e+": 행렬 내부의 값은 정수 형태만 가능합니다.");
					sc.nextLine();
					--j;
				}
			}
		}
				
	}
	
	private static int inputNum(int num) throws NegativeException {
		// TODO Auto-generated method stub
		if(num <=0) {
			NegativeException ext = new NegativeException();
			throw ext;
		}
		return num;
	}
	
	/**getter,setter**/
	public int getRow() {
		return row;
	}
	public void setRow(int row) {
		this.row=row;
	}
	public int getCol() {
		return col;
	}
	public void setCol(int col) {
		this.col=col;
	}
	public int getArr(int x, int y) {
		return array[x][y];
	}
	public void setArr(int x, int y,int result) {
		this.array[x][y]=result;
	}
	
	/**matrix transpose & summation**/
	public static Matrix Transpose(Matrix A) {
		if(A.getRow() * A.getCol() == 0) {
			System.out.println("전치행렬을 구할  수 없습니다.");
			return new Matrix();
		}
		
		int x=A.getRow();
		int y=A.getCol();
		Matrix m = new Matrix(y,x);
		for(int i=0;i<y;i++)
			for(int j=0;j<x;j++)
				m.setArr(i,j,A.getArr(j,i));
		
		return m;
	}
	public static Matrix Summation(Matrix A,Matrix B) {
		try {
			if(A.getRow()/B.getRow() != 1 && A.getCol()/B.getCol() != 1) {
				System.out.println("행렬의 합을 구할 수 없습니다.");
				return new Matrix();
			}
		}catch(ArithmeticException e) {
			System.out.println("산술 연산 오류입니다.");
			return new Matrix();
		}
		
		
		int x=A.getRow();
		int y=A.getCol();
		
		Matrix m = new Matrix(x,y);
		for(int i=0;i<x;i++)
			for(int j=0;j<y;j++)
				m.setArr(i,j,A.getArr(i,j)+B.getArr(i, j));
		
		return m;
		
	}
	/**matrix multiply (multiply constant & multiply matrix using overriding)**/
	public static Matrix Multiply(Matrix A,int n) {
		if(A.getRow() * A.getCol() == 0) {
			System.out.println("행렬의 곱을 구할 수 없습니다.");
			return new Matrix();
		}
		
		int x=A.getRow();
		int y=A.getCol();
		Matrix m = new Matrix(x,y);
		for(int i=0;i<x;i++)
			for(int j=0;j<y;j++)
				m.setArr(i,j,n*A.getArr(i,j));
		
		return m;
	}
	public static Matrix Multiply(Matrix A,Matrix B) {
		try {
			if(A.getCol()/B.getRow() != 1) { //mathching one's col and another's row
				System.out.println("행렬의 곱을 구할 수 없습니다.");
				return new Matrix();
			}
		}catch(ArithmeticException e) {
			System.out.println("산술 연산이 불가능합니다.");
			return new Matrix();
		}
		
		int x=A.getRow();
		int y=B.getCol();
		int z=A.getCol();
		Matrix m = new Matrix(x,y);
		
		for(int i=0;i<x;i++) {
			for(int j=0;j<y;j++) {
				int sum=0;
				for(int k=0;k<z;k++) {
					sum += A.getArr(i,k)*B.getArr(k, j);
				}
				m.setArr(i, j, sum);
			}
		}
		return m;
	}
	/** To print all element's of matrix**/
	public boolean printMat() {
		if(this.getRow() * this.getCol()==0)
			return false;
		
		for(int i=0;i<this.getRow();i++) {
			for(int j=0;j<this.getCol();j++) {
				System.out.print(this.getArr(i, j)+" ");
			}
			System.out.println("");
		}
		return true;
	}
	
}
