import javax.swing.*;
import java.awt.*;
import java.awt.event.*;


public class Swing implements ActionListener {
    static JButton button;

    public static void main(String[] args) {
        button = new JButton();
        button.setBounds(200, 200, 100, 50);

        JFrame frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(700, 700);
        frame.setLayout(null);
        frame.setVisible(true);
        frame.add(button);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == button) {
            System.out.println("Action performed!");
        }
    }
}