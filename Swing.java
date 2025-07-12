import java.awt.Color;
import javax.swing.JFrame;
import javax.swing.JLabel;


public class Swing {
    public static void main(String[] args) {
        JLabel label = new JLabel();
        label.setText("Sabah Al Siam");

        JFrame frame = new JFrame();
        frame.setTitle("My First Swing");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().setBackground(new Color(0xeeeeee));
        frame.setSize(800, 800);
        frame.setVisible(true);
        frame.add(label);
    }
}