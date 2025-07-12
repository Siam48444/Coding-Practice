import java.awt.*;
import javax.swing.*;


public class Swing {
    public static void main(String[] args) {
        JLabel label = new JLabel();
        label.setText("Sabah Al Siam");
        label.setFont(new Font("JetBrainsMono NF", Font.PLAIN, 40));
        label.setForeground(new Color(0x000000));

        JFrame frame = new JFrame();
        frame.setTitle("My First Swing");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().setBackground(new Color(0xeeeeee));
        frame.setSize(800, 800);
        frame.setVisible(true);
        frame.add(label);
    }
}