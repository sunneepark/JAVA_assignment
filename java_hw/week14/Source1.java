package ex14;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class Source1 extends JPanel implements Runnable, ActionListener{
	JButton b;
	String str="Hello World!";
	Thread thr=null;
	
	public Source1() {
		b = new JButton();
		b.addActionListener(this);
		b.setText("Press to start the animation.");
		this.add(b);
	
		//this.setVisible(true);
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		JFrame f=new JFrame();
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		f.setSize(600,300);
		f.setTitle("20111111 박선희");
		f.add(new Source1());
		f.setVisible(true);
		
	}
	public void paintComponent(Graphics g) {

		super.paintComponent(g);
		g.setFont(new Font("Dialog",Font.BOLD,50));
		Random r=new Random();
		for(int i=0;i<str.length();i++) {
			
			int rVal,gVal, bVal;
			rVal=r.nextInt(256);
			gVal=r.nextInt(256);
			bVal=r.nextInt(256);
			
			g.setColor(new Color(rVal,gVal,bVal));
			g.drawString(str.substring(i,i+1),25+i*50,85);
		}
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(thr==null) { //쓰레드가 없을 때 
			thr=new Thread(this);
			thr.start();
			
			b.setText("Press to stop the animation.");
		}
		else {
			thr=null;
			
			b.setText("Press to start the animation.");
		}
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		while(thr!=null) {
			try {
				repaint();
				Thread.sleep(1000);
			}catch(InterruptedException e) {
			}
		}
	}

}
