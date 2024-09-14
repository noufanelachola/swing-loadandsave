import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileReader;
import java.io.FileWriter;

public class Main {
    public static void main(String[] args) {
        //Frame
        JFrame frame = new JFrame("LoadandSave");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(650, 600);
        frame.getContentPane().setBackground(new Color(0x121212));
        frame.setLayout(new FlowLayout(FlowLayout.CENTER));

        //TextField
        JTextField textField = new JTextField();
        textField.setPreferredSize(new Dimension(500, 50));
        frame.add(textField);

        //Panel
        JPanel panel = new JPanel();
        panel.setBackground(new Color(0x1E1E1E));
        frame.add(panel);

        //Buttons
        JButton btnAdd = new JButton("Add");
        JButton btnSave = new JButton("Save");
        JButton btnLoad = new JButton("Load");

        btnAdd.setBackground(new Color(0x2A2A2A));
        btnAdd.setForeground(new Color(0xFFFFFF));
        btnSave.setBackground(new Color(0x2A2A2A));
        btnSave.setForeground(new Color(0xFFFFFF));
        btnLoad.setBackground(new Color(0x2A2A2A));
        btnLoad.setForeground(new Color(0xFFFFFF));

        panel.add(btnAdd);
        panel.add(btnSave);
        panel.add(btnLoad);

        ActionListener actionListener = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent event) {
                String command = event.getActionCommand();
                String inputText = textField.getText();

                switch(command){
                    case "Add":
                        String[] inputArray = inputText.split(",");
                        int length = inputArray.length;
                        int sum = 0;

                        try {
                            for(int i = 0; i < length; i++){
                                sum += Integer.parseInt(inputArray[i]);
                            }
                            textField.setText(Integer.toString(sum));
                        } catch (Exception error){
                            System.out.println("Error");
                        }
                        break;

                    case "Save":
                        try{
                            FileWriter fileWriter = new FileWriter("D:\\Codes\\Java\\Swing\\Projects\\03-LoadandSave\\data.txt");
                            fileWriter.write(inputText);
                            fileWriter.close();
                        }catch (Exception error){
                            System.out.println("Error");
                        }
                        break;

                    case "Load":
                        StringBuilder outputText = new StringBuilder();
                        try{
                            FileReader fileReader = new FileReader("D:\\Codes\\Java\\Swing\\Projects\\03-LoadandSave\\data.txt");
                            int i;
                            while ((i = fileReader.read()) != -1) {
                                outputText.append((char) i);
                            }
                            textField.setText(outputText.toString());
                            fileReader.close();
                        }catch (Exception error){
                            System.out.println("Error");
                        }
                }
            }
        };

        btnAdd.addActionListener(actionListener);
        btnSave.addActionListener(actionListener);
        btnLoad.addActionListener(actionListener);

        frame.setVisible(true);
    }
}