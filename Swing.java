import javax.swing.JFrame;


public class Swing {
    public static void main(String[] args) {
        JFrame frame = new JFrame();

        frame.setTitle("My First Swing"); 
        frame.setSize(1000, 600);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}