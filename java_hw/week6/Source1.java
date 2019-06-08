package ex06;

public class Source1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Student s1 = new Student("홍길동",1,2);
		s1.setScore(75,88,54);
		Student s2 = new Student("김영희",1,20,90,100,94);
		Student s3 = new Student("김철수",2,12,12,54,30);
		
		s1.printInfo();
		s2.printInfo();
		s3.printInfo();
	}

}
class Student {
	private String name;
	private int ban;
	private int no;
	private int kor;
	private int eng;
	private int math;
	public static int cntCurrentStudent=0; //현재까지 생성된 학생 수
	

	public Student(String name,int ban, int no) {
		// TODO Auto-generated constructor stub
		
		//이름, 반, 번호 초기화
		this.name=name; 
		this.ban=ban;
		this.no=no;
		//초기화되지 않은 필드 0으로 초기화
		kor=eng=math=0;
		//현재 학생 수 증가
		cntCurrentStudent++;

		System.out.println(name+" 학생이 생성되었습니다.");
		System.out.println("현재까지 처리중인 학생수는 "+cntCurrentStudent+"입니다.");
	}
	
	public Student(String name, int ban, int no, int kor, int eng, int math) {
		this(name,ban,no);
		setScore(kor,eng,math);
	}
	
	public void setScore(int kor, int eng, int math) {
		// TODO Auto-generated method stub
		this.kor=kor;
		this.eng=eng;
		this.math=math;
	}
	
	int getTotal() {
		return kor+eng+math;
	}
	float getAverage() {
		float sum=getTotal()/3;
		float a=Math.round(sum)/100f;
		return (int)(getTotal() / 3f * 10 + 0.5f) / 10f;
	}
	char grade() {
		if(getAverage()>90) return 'A';
		else if(getAverage()>80) return 'B';
		else if(getAverage()>70) return 'C';
		else if(getAverage()>60) return 'D';
		else return 'F';
	}
	void printInfo() {
		System.out.println(name+" 학생의 정보는 다음과 같습니다.");
		System.out.println("국어 : "+kor+" ,영어 : "+eng+" ,수학 : "+math);
		System.out.println("총점 : "+getTotal()+",평균 : "+getAverage());
		
	}
}
