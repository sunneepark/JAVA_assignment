package ex11;

import java.awt.*;
import java.awt.event.*;
import java.awt.image.*;
import java.io.*;
import java.util.Random;
import javax.imageio.*;
import javax.swing.*;
 
class MyImageFrame1 extends JFrame{
 
    BufferedImage img;
 
    private int pieces = 4;
    private int totalPieces = pieces * pieces;
    private int[] pieceNumber;
 
    public MyImageFrame1() {
        setTitle("2016112105 박선희");
        try {
            img = ImageIO.read(new File("fish.jpg")); //이미지 불러오기
        } catch (IOException e) {
            System.out.println(e.getMessage());
            System.exit(0);
        }
        pieceNumber = new int[totalPieces]; //사진 순서를 저장할 배열
        
        
        for (int i = 0; i < totalPieces; i++) {
            pieceNumber[i] = i;
        }
        divide();
        add(new MyPanel());
        
        setSize(img.getWidth(null) , img.getHeight(null) );
        setVisible(true);
    }
 
    void divide() { //랜덤하게 뒤섞기
        Random rand = new Random();
        int ri;
        for (int i = 0; i < totalPieces; i++) {
            ri = rand.nextInt(totalPieces);
            //랜덤하게 값 바꾸기
            int tmp = pieceNumber[i];
            pieceNumber[i] = pieceNumber[ri];
            pieceNumber[ri] = tmp;
        }
    }
 
    class MyPanel extends JPanel {
        public void paintComponent(Graphics g) {
            super.paintComponent(g);
            
            //불러온 이미지의 가로와 세로 길이를 불러 한 조각의 가로와 세로 길이를 구함
            int pieceWidth = img.getWidth(null) / pieces;
            int pieceHeight = img.getHeight(null) / pieces;
            
            for (int x = 0; x < pieces; x++) {
                int sx = x * pieceWidth;
                for (int y = 0; y < pieces; y++) {
                    int sy = y * pieceHeight;
                    //그림을 컨버스에 그릴 위치를 정함
                    int number = pieceNumber[x * pieces + y];
                    //조각갯수로 나눈 몫과 나머지로 캔버스에 그릴 위치를 정함.
                    int dx = (number / pieces) * pieceWidth;
                    int dy = (number % pieces) * pieceHeight;
                    
                    g.drawImage(img, dx, dy, dx + pieceWidth, dy + pieceHeight,
                            sx, sy, sx + pieceWidth, sy + pieceHeight, null);
                }
            }
        }
    }

}
public class Source2{
	 public static void main(String[] args) {
	        new MyImageFrame1();
	    }
}
