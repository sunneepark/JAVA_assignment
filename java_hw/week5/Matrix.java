package ex05;

import java.util.Scanner;
import java.util.InputMismatchException;

class NegativeException extends Exception{
	public NegativeException() {
		super("����� ��� ���� 0�� ������ �Էµ� �� �����ϴ�.");
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
		
		System.out.println("������� ������ ����� �� ������ "+array_number+"�� �Դϴ�.");
	}
	public void initInput(){ //�Է¹����鼭 �ʱ�ȭ �ϴ� �޼ҵ�
		boolean doInput=true; //�Է� �޾ƾ� �Ǵ� ����
		Scanner sc=new Scanner(System.in);
		int Row=0; int Col=0;
		while(doInput) {
			try {
				System.out.println("����� ����  �Է��ϼ���.");
				Row=inputNum(sc.nextInt());

				System.out.println("����� ����  �Է��ϼ���.");
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
		System.out.println("������� ������ ����� �� ������ "+array_number+"�� �Դϴ�.");
		
		System.out.println("��� ������ ���� �Է��ϼ���.");
		int i,j,num = 0;
		for(i=0;i<this.getRow();i++) {
			for(j=0;j<this.getCol();j++) {
				try {
					System.out.println((i+1)+"��"+(j+1)+"���� ���� �Է����ּ��� : ");
					num=sc.nextInt();
					this.setArr(i, j, num);
				}catch (InputMismatchException e){
					System.out.println(e+": ��� ������ ���� ���� ���¸� �����մϴ�.");
					sc.nextLine();
					--j;
				    //e.printStackTrace(); //���� ���(����� ��������)
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
	
	/**��ġ���, ��� �� ���ϴ� �޼ҵ�**/
	public static Matrix Transpose(Matrix A) {
		if(A.getRow() * A.getCol() == 0) {
			System.out.println("��ġ����� ���� �� �����ϴ�.");
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
				System.out.println("������ ������ �� �����ϴ�.");
				return new Matrix();
			}
		}catch(ArithmeticException e) {
			System.out.println("������ ������ �� �����ϴ�.");
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
	/**��İ� ���ϴ� �޼ҵ�(�Ű������� �޸� �Ͽ� �����ε�)**/
	public static Matrix Multiply(Matrix A,int n) {
		if(A.getRow() * A.getCol() == 0) {
			System.out.println("����� ���� �� �� �����ϴ�.");
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
				System.out.println("������ ������ �� �����ϴ�.");
				return new Matrix();
			}
		}catch(ArithmeticException e) {
			System.out.println("������ ������ �� �����ϴ�.");
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
	/**��� ���� �� ����ϴ� �޼ҵ�**/
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
