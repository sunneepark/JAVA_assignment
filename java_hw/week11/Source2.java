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
        setTitle("2016112105 ¹Ú¼±Èñ");
        try {
            img = ImageIO.read(new File("D:\\fish.jpg"));
        } catch (IOException e) {
            System.out.println(e.getMessage());
            System.exit(0);
        }
        pieceNumber = new int[totalPieces];
        
        
        for (int i = 0; i < totalPieces; i++) {
            pieceNumber[i] = i;
        }
        divide();
        add(new MyPanel());
        
        setSize(img.getWidth(null) , img.getHeight(null) );
        setVisible(true);
    }
 
    void divide() {
        Random rand = new Random();
        int ri;
        for (int i = 0; i < totalPieces; i++) {
            ri = rand.nextInt(totalPieces);
            int tmp = pieceNumber[i];
            pieceNumber[i] = pieceNumber[ri];
            pieceNumber[ri] = tmp;
        }
    }
 
    class MyPanel extends JPanel {
        public void paintComponent(Graphics g) {
            super.paintComponent(g);
            int pieceWidth = img.getWidth(null) / pieces;
            int pieceHeight = img.getHeight(null) / pieces;
            for (int x = 0; x < pieces; x++) {
                int sx = x * pieceWidth;
                for (int y = 0; y < pieces; y++) {
                    int sy = y * pieceHeight;
                    int number = pieceNumber[x * pieces + y];
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
