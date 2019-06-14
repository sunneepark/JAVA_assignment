package ex13;

import java.util.*;
public class Source1
{
	ArrayList<String> words = new ArrayList<String>(); //게임 판에 보여져야할 단어들
	String[] data = {"자바","객체","자구","컴구","기초프로그래밍","이산구조","인컴","패턴"}; 
	wordGenerator wg = new wordGenerator();
	
	public static void main(String args[])
	{
		Source1 game = new Source1();
	    game.wg.start(); // 단어를 생성하는 쓰레드를 실행시킨다.
		
		ArrayList<String> gameBoard = game.words; 
		while(true) {
			System.out.println(gameBoard);
			String prompt = ">>";
			System.out.print(prompt);
			
			Scanner s = new Scanner(System.in);
			String input = s.nextLine().trim();
			int index = gameBoard.indexOf(input); // 입력받은 단어를 words에서 찾는다.
			if(index!=-1) { // 찾으면
				gameBoard.remove(index); // words에서 해당 단어를 제거한다.
			}
		}
	} // main
	class wordGenerator extends Thread {
		int interval = 2 * 1000; // 2초
		public void run() {
			while(true) {
				// 1. 배열 data의 값 중 하나를 임의로 선택해서
				int rand = (int)(Math.random()*data.length);
				
				// 2. words에 저장한다.
				words.add(data[rand]);
				
				// 3. 2초(interval) 동안 쉰다. 
				try {
				Thread.sleep(interval); // 2초(interval) 동안 쉰다.
				} catch(Exception e) {
				}
			}
		}
	}
}

