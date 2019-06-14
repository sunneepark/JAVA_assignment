package ex05;

import java.util.Scanner;
import java.util.InputMismatchException;

class NegativeException extends Exception{
	public NegativeException() {
		super("占쏙옙占쏙옙占� 占쏙옙占� 占쏙옙占쏙옙 0占쏙옙 占쏙옙占쏙옙占쏙옙 占쌉력듸옙 占쏙옙 占쏙옙占쏙옙占싹댐옙.");
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
		
		System.out.println("占쏙옙占쏙옙占쏙옙占� 占쏙옙占쏙옙占쏙옙 占쏙옙占쏙옙占� 占쏙옙 占쏙옙占쏙옙占쏙옙 "+array_number+"占쏙옙 占쌉니댐옙.");
	}
	public void initInput(){ //占쌉력뱄옙占쏙옙占썽서 占십깍옙화 占싹댐옙 占쌨소듸옙
		boolean doInput=true; //占쌉뤄옙 占쌨아억옙 占실댐옙 占쏙옙占쏙옙
		Scanner sc=new Scanner(System.in);
		int Row=0; int Col=0;
		while(doInput) {
			try {
				System.out.println("占쏙옙占쏙옙占� 占쏙옙占쏙옙  占쌉뤄옙占싹쇽옙占쏙옙.");
				Row=inputNum(sc.nextInt());

				System.out.println("占쏙옙占쏙옙占� 占쏙옙占쏙옙  占쌉뤄옙占싹쇽옙占쏙옙.");
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
		System.out.println("占쏙옙占쏙옙占쏙옙占� 占쏙옙占쏙옙占쏙옙 占쏙옙占쏙옙占� 占쏙옙 占쏙옙占쏙옙占쏙옙 "+array_number+"占쏙옙 占쌉니댐옙.");
		
		System.out.println("占쏙옙占� 占쏙옙占쏙옙占쏙옙 占쏙옙占쏙옙 占쌉뤄옙占싹쇽옙占쏙옙.");
		int i,j,num = 0;
		for(i=0;i<this.getRow();i++) {
			for(j=0;j<this.getCol();j++) {
				try {
					System.out.println((i+1)+"占쏙옙"+(j+1)+"占쏙옙占쏙옙 占쏙옙占쏙옙 占쌉뤄옙占쏙옙占쌍쇽옙占쏙옙 : ");
					num=sc.nextInt();
					this.setArr(i, j, num);
				}catch (InputMismatchException e){
					System.out.println(e+": 占쏙옙占� 占쏙옙占쏙옙占쏙옙 占쏙옙占쏙옙 占쏙옙占쏙옙 占쏙옙占승몌옙 占쏙옙占쏙옙占쌌니댐옙.");
					sc.nextLine();
					--j;
				    //e.printStackTrace(); //占쏙옙占쏙옙 占쏙옙占�(占쏙옙占쏙옙占� 占쏙옙占쏙옙占쏙옙占쏙옙)
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
	
	/**占쏙옙치占쏙옙占�, 占쏙옙占� 占쏙옙 占쏙옙占싹댐옙 占쌨소듸옙**/
	public static Matrix Transpose(Matrix A) {
		if(A.getRow() * A.getCol() == 0) {
			System.out.println("占쏙옙치占쏙옙占쏙옙占� 占쏙옙占쏙옙 占쏙옙 占쏙옙占쏙옙占싹댐옙.");
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
				System.out.println("占쏙옙占쏙옙占쏙옙 占쏙옙占쏙옙占쏙옙 占쏙옙 占쏙옙占쏙옙占싹댐옙.");
				return new Matrix();
			}
		}catch(ArithmeticException e) {
			System.out.println("占쏙옙占쏙옙占쏙옙 占쏙옙占쏙옙占쏙옙 占쏙옙 占쏙옙占쏙옙占싹댐옙.");
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
	/**占쏙옙캅占� 占쏙옙占싹댐옙 占쌨소듸옙(占신곤옙占쏙옙占쏙옙占쏙옙 占쌨몌옙 占싹울옙 占쏙옙占쏙옙占싸듸옙)**/
	public static Matrix Multiply(Matrix A,int n) {
		if(A.getRow() * A.getCol() == 0) {
			System.out.println("占쏙옙占쏙옙占� 占쏙옙占쏙옙 占쏙옙 占쏙옙 占쏙옙占쏙옙占싹댐옙.");
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
			if(A.getCol()/B.getRow() != 1) {
				System.out.println("占쏙옙占쏙옙占쏙옙 占쏙옙占쏙옙占쏙옙 占쏙옙 占쏙옙占쏙옙占싹댐옙.");
				return new Matrix();
			}
		}catch(ArithmeticException e) {
			System.out.println("占쏙옙占쏙옙占쏙옙 占쏙옙占쏙옙占쏙옙 占쏙옙 占쏙옙占쏙옙占싹댐옙.");
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
	/**占쏙옙占� 占쏙옙占쏙옙 占쏙옙 占쏙옙占쏙옙求占� 占쌨소듸옙**/
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
