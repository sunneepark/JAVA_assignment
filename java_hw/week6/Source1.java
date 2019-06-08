package ex06;

public class Source1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Student s1 = new Student("ȫ�浿",1,2);
		s1.setScore(75,88,54);
		Student s2 = new Student("�迵��",1,20,90,100,94);
		Student s3 = new Student("��ö��",2,12,12,54,30);
		
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
	public static int cntCurrentStudent=0; //������� ������ �л� ��
	

	public Student(String name,int ban, int no) {
		// TODO Auto-generated constructor stub
		
		//�̸�, ��, ��ȣ �ʱ�ȭ
		this.name=name; 
		this.ban=ban;
		this.no=no;
		//�ʱ�ȭ���� ���� �ʵ� 0���� �ʱ�ȭ
		kor=eng=math=0;
		//���� �л� �� ����
		cntCurrentStudent++;

		System.out.println(name+" �л��� �����Ǿ����ϴ�.");
		System.out.println("������� ó������ �л����� "+cntCurrentStudent+"�Դϴ�.");
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
		System.out.println(name+" �л��� ������ ������ �����ϴ�.");
		System.out.println("���� : "+kor+" ,���� : "+eng+" ,���� : "+math);
		System.out.println("���� : "+getTotal()+",��� : "+getAverage());
		
	}
}
