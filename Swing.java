import java.awt.Color;
import javax.swing.JFrame;


public class Swing {
    public static void main(String[] args) {
        JFrame frame = new JFrame();

        frame.setTitle("My First Swing"); 
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().setBackground(new Color(0xcf4b27));
        frame.setSize(800, 800);
        frame.setVisible(true);
        frame.setResizable(true);
    }
}