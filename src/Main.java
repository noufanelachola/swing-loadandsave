import javax.swing.*;
import java.awt.*;

public class Main {
    public static void main(String[] args) {
        //Frame
        JFrame frame = new JFrame("LoadandSave");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(800, 600);
        frame.getContentPane().setBackground(new Color(0x121212));
        frame.setLayout(new FlowLayout(FlowLayout.CENTER));

        //TextField
        JTextField textField = new JTextField();
        textField.setPreferredSize(new Dimension(500, 50));
        frame.add(textField);


        frame.setVisible(true);
    }
}