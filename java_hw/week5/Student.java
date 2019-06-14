package ex05;

import java.math.*;

public class Student {
	private String name;
	private int ban;
	private int no;
	private int kor;
	private int eng;
	private int math;
	 
	public Student(String name, int ban, int no) {
		this.name=name;
		this.ban=ban;
		this.no=no;
		kor=0; eng=0; math=0;
	}
	public Student(String name, int ban, int no, int kor, int eng, int math) {
		this(name,ban,no);
		this.kor=kor;
		this.eng=eng;
		this.math=math;
	}
	public int getTotal() {
		return kor+eng+math;
	}
	public float getAverage() {
		return Math.round(getTotal()/3f*10)/10f;
	}
}
