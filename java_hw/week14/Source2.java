package ex14;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.util.Random;

import javax.swing.Timer;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class Source2 extends JPanel implements ActionListener{
	JButton b;
	Thread thr=null;
	Image[] icons;
	Timer t;
	int currentIdx=1;
	
	public Source2() {
		b = new JButton();
		b.addActionListener(this);
		b.setText("Press to start the animation.");
		this.add(b);
		
		t=new Timer(200, new ActionListener(){
            public void actionPerformed(ActionEvent e) {
            	currentIdx++;
            	if((currentIdx %= icons.length) == 0) //인덱스의 값을 1~6까지 
            		currentIdx++;
            	repaint();
            }
        });
		
		icons=new Image[7];
		try { //이미지 배열
			for (int i = 1; i <= 6; i++) {
				String name = "icon"+ i + ".jpg";
				icons[i] = ImageIO.read(new File(name));
			}
		}catch(IOException e) {
		}
		
		this.setVisible(true);
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		JFrame f=new JFrame();
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		f.setSize(600,300);
		f.setTitle("20111111 박선희");
		f.add(new Source2());
		f.setVisible(true);
	}
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		g.drawImage(icons[currentIdx], 50,50,150,150,null);
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(t.isRunning()) { //timer 작동하고 있을 경우에
			t.stop();
			b.setText("Press to start the animation.");
		}
		else {
			t.start();
			b.setText("Press to stop the animation.");
		}
	}


}
