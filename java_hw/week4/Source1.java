package ex04;

import java.io.*; //bufferedreader, inputstreamreader�� ����ϱ� ����

public class Source1 {

	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		
		//bufferedreader�� �̿��Ͽ� �Է¹ޱ�
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int input = Integer.parseInt(br.readLine());
		
		int result=0;
		int mul=1;
		for(int i=1;i<=input;i++) {
			mul=1;
			for(int j=1;j<=i;j++) {
				 mul*=j;
			}
			result+=mul;
		}
		System.out.println(result);
	}

}
