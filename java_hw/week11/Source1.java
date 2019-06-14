
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;


class BouncingBall extends JPanel {
	
	 private static final int FRAME_WIDTH = 600; // ��ü ��
	 private static final int FRAME_HEIGHT = 240; // ��ü ����
	 private static final int BALL_SIZE=20; //���� ������
	 private static final int SPEED=5; //�� �ӵ�
	 
	 private float ballX = BALL_SIZE + 120; // ���� �ʱ� X��ġ
	 private float ballY = BALL_SIZE + 80; // ���� �ʱ� Y��ġ
	 private float xstep=SPEED; //x�� �̵�����
	 private float ystep=SPEED; //y�� �̵�����
	 
	 public BouncingBall() {
	  this.setPreferredSize(new Dimension(FRAME_WIDTH, FRAME_HEIGHT)); // ������ ����
	  
	  class MyThread extends Thread {
	   public void run() { // �����Ͽ��� �ϴ� �۾��� ������
	    while (true) {
	     ballX += xstep;
	     ballY += ystep;
	     // 1. ���� ���� �������� ������ϸ�
	  	 // x�� ���� �ٲٰ� x�� �̵�����(xStep)�� �ݴ�� �Ѵ�.
	     if (ballX - BALL_SIZE < 0) {
	    	 xstep = -xstep;
	      //ballX = BALL_SIZE;
	     } 
	     // 2. ���� ���� �������� ������ϸ�
	  	 // x�� ���� BALL_SIZE�� �ٲٰ� x�� �̵�����(xStep)�� �ݴ�� �Ѵ�.
	     else if (ballX + BALL_SIZE > FRAME_WIDTH) { 
	    	 xstep = -xstep;
	      ballX = FRAME_WIDTH - BALL_SIZE;
	     }
	      // 3. ���� ���� �������� ������ϸ�
	  	 // x�� ���� BALL_SIZE�� �ٲٰ� x�� �̵�����(xStep)�� �ݴ�� �Ѵ�.
	     if (ballY - BALL_SIZE < 0) {
	    	 ystep = -ystep;
	      ballY = BALL_SIZE;
	     } 
	     // 4. ���� ���� �������� ������ϸ�
	  	 // x�� ���� BALL_SIZE�� �ٲٰ� x�� �̵�����(xStep)�� �ݴ�� �Ѵ�.
	     else if (ballY + BALL_SIZE > FRAME_HEIGHT) {
	    	 ystep = -ystep;
	      ballY = FRAME_HEIGHT - BALL_SIZE;
	     }
	     repaint(); // �׸���.
	     try {
	      Thread.sleep(50); // ���� �ӵ� ����
	     } catch (InterruptedException ex) {
	     }
	    }
	   }
	  }
	  Thread t = new MyThread(); // ������ ��ü ����
	  t.start(); // ������ ����
	 }

	 public void paintComponent(Graphics g) {
	  super.paintComponent(g);

	  g.setColor(Color.YELLOW); // �ʷϻ����� ä��
	  g.fillRect(0, 0, FRAME_WIDTH, FRAME_HEIGHT); // ���簢��

	  g.setColor(Color.RED); // ���������� ä��
	  g.fillOval((int) (ballX - BALL_SIZE), (int) (ballY - BALL_SIZE),
	    (int) (2 * BALL_SIZE), (int) (2 * BALL_SIZE)); // ��

	 }
}
public class Source1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//new BouncingBall("Bouncing Ball").start();
		JFrame frame = new JFrame("2016112105 �ڼ���");
		frame.setSize(600, 240);
		frame.setResizable(false);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setContentPane(new BouncingBall());
		frame.pack();
		frame.setVisible(true);
	}

}
