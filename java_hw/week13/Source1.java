package ex13;

import java.util.*;
public class Source1
{
	ArrayList<String> words = new ArrayList<String>(); //���� �ǿ� ���������� �ܾ��
	String[] data = {"�ڹ�","��ü","�ڱ�","�ı�","�������α׷���","�̻걸��","����","����"}; 
	wordGenerator wg = new wordGenerator();
	
	public static void main(String args[])
	{
		Source1 game = new Source1();
	    game.wg.start(); // �ܾ �����ϴ� �����带 �����Ų��.
		
		ArrayList<String> gameBoard = game.words; 
		while(true) {
			System.out.println(gameBoard);
			String prompt = ">>";
			System.out.print(prompt);
			
			Scanner s = new Scanner(System.in);
			String input = s.nextLine().trim();
			int index = gameBoard.indexOf(input); // �Է¹��� �ܾ words���� ã�´�.
			if(index!=-1) { // ã����
				gameBoard.remove(index); // words���� �ش� �ܾ �����Ѵ�.
			}
		}
	} // main
	class wordGenerator extends Thread {
		int interval = 2 * 1000; // 2��
		public void run() {
			while(true) {
				// 1. �迭 data�� �� �� �ϳ��� ���Ƿ� �����ؼ�
				int rand = (int)(Math.random()*data.length);
				
				// 2. words�� �����Ѵ�.
				words.add(data[rand]);
				
				// 3. 2��(interval) ���� ����. 
				try {
				Thread.sleep(interval); // 2��(interval) ���� ����.
				} catch(Exception e) {
				}
			}
		}
	}
}

