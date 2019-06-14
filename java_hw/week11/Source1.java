
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;


class BouncingBall extends JPanel {
	
	 private static final int FRAME_WIDTH = 600; // 전체 폭
	 private static final int FRAME_HEIGHT = 240; // 전체 높이
	 private static final int BALL_SIZE=20; //공의 반지름
	 private static final int SPEED=5; //공 속도
	 
	 private float ballX = BALL_SIZE + 120; // 공의 초기 X위치
	 private float ballY = BALL_SIZE + 80; // 공의 초기 Y위치
	 private float xstep=SPEED; //x의 이동방향
	 private float ystep=SPEED; //y의 이동방향
	 
	 public BouncingBall() {
	  this.setPreferredSize(new Dimension(FRAME_WIDTH, FRAME_HEIGHT)); // 사이즈 지정
	  
	  class MyThread extends Thread {
	   public void run() { // 수행하여야 하는 작업을 적어줌
	    while (true) {
	     ballX += xstep;
	     ballY += ystep;
	     // 1. 공이 왼쪽 프레임을 벗어나려하면
	  	 // x의 값을 바꾸고 x축 이동방향(xStep)을 반대로 한다.
	     if (ballX - BALL_SIZE < 0) {
	    	 xstep = -xstep;
	      //ballX = BALL_SIZE;
	     } 
	     // 2. 공이 왼쪽 프레임을 벗어나려하면
	  	 // x의 값을 BALL_SIZE로 바꾸고 x축 이동방향(xStep)을 반대로 한다.
	     else if (ballX + BALL_SIZE > FRAME_WIDTH) { 
	    	 xstep = -xstep;
	      ballX = FRAME_WIDTH - BALL_SIZE;
	     }
	      // 3. 공이 왼쪽 프레임을 벗어나려하면
	  	 // x의 값을 BALL_SIZE로 바꾸고 x축 이동방향(xStep)을 반대로 한다.
	     if (ballY - BALL_SIZE < 0) {
	    	 ystep = -ystep;
	      ballY = BALL_SIZE;
	     } 
	     // 4. 공이 왼쪽 프레임을 벗어나려하면
	  	 // x의 값을 BALL_SIZE로 바꾸고 x축 이동방향(xStep)을 반대로 한다.
	     else if (ballY + BALL_SIZE > FRAME_HEIGHT) {
	    	 ystep = -ystep;
	      ballY = FRAME_HEIGHT - BALL_SIZE;
	     }
	     repaint(); // 그린다.
	     try {
	      Thread.sleep(50); // 공의 속도 조절
	     } catch (InterruptedException ex) {
	     }
	    }
	   }
	  }
	  Thread t = new MyThread(); // 스레드 객체 생성
	  t.start(); // 스레드 시작
	 }

	 public void paintComponent(Graphics g) {
	  super.paintComponent(g);

	  g.setColor(Color.YELLOW); // 초록색으로 채움
	  g.fillRect(0, 0, FRAME_WIDTH, FRAME_HEIGHT); // 직사각형

	  g.setColor(Color.RED); // 빨간색으로 채움
	  g.fillOval((int) (ballX - BALL_SIZE), (int) (ballY - BALL_SIZE),
	    (int) (2 * BALL_SIZE), (int) (2 * BALL_SIZE)); // 원

	 }
}
public class Source1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//new BouncingBall("Bouncing Ball").start();
		JFrame frame = new JFrame("2016112105 박선희");
		frame.setSize(600, 240);
		frame.setResizable(false);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setContentPane(new BouncingBall());
		frame.pack();
		frame.setVisible(true);
	}

}
