package week3;

//3번 솔루션
public class Source3 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		String str="abcdef"; //abcdef 문자열 선언
		
		/*1번 -length 메소드 이용하여 문자열 길이 출력 */
		System.out.println("1번: "+str.length()); 
		
		String str_upper="ABCDEF";
		
		/*2번 -boolean 형으로 반환하는 equals 메소드를 통해 문자열 같은지 판단*/
		boolean res=str.equals(str_upper);
		
		System.out.println("2번 : "+res);
		
		/*3번 -boolean 형으로 반환하는 equalsIgnoreCase 메소드를 통해 대소문자 상관없이 문자열 같은지 판단*/
		boolean res_ignore=str.equalsIgnoreCase(str_upper);
		
		System.out.println("3번: "+res_ignore);
		
		String str_token="abc,def";
		
		/*4번 -split 이라는 분리하는 메소드를 통해 ','기준으로 나누고 arr 라는 string 배열에 저장*/
		String[] arr=new String(str_token).split(",");
		
		System.out.println("4번:");
		for(String e:arr)System.out.println(e); 
		
		/*5번 -startsWith 메소드 이용하여 받은 문자열로 처음 시작하는지 검사 */
		boolean res_start=str.startsWith("adf");
		
		System.out.println("5번: "+res_start);
	}

}
