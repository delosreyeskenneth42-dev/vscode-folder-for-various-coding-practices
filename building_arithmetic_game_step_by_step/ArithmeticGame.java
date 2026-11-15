package building_arithmetic_game_step_by_step;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.JTextField;

import java.awt.BorderLayout;
import java.awt.Dimension;

public class ArithmeticGame extends JFrame{
    
    public ArithmeticGame(){
        setTitle("Interactive Arithmetic Game");
        setSize(750,700);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        JLabel titleLabel = new JLabel("Arithmetic Game");

        JButton submitButton = new JButton("Submit");

        JPanel headerPanel = new JPanel();
        JPanel buttonPanel = new JPanel();
        JPanel inputPanel = new JPanel();

        JTextField textField = new JTextField(15);
        textField.setPreferredSize(new Dimension(200, 30));

        headerPanel.add(titleLabel);
        buttonPanel.add(submitButton);
        inputPanel.add(textField);

        add(headerPanel, BorderLayout.NORTH);
        add(buttonPanel, BorderLayout.CENTER);
        add(inputPanel, BorderLayout.SOUTH);
        setVisible(true);

    }
    public static void main(String[] args){
        new ArithmeticGame();
    }
}
