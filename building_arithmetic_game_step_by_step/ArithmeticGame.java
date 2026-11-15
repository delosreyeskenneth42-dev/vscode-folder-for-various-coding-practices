package building_arithmetic_game_step_by_step;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JRadioButton;
import javax.swing.ButtonGroup;
import javax.swing.JOptionPane;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionListener;

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

        headerPanel.setBackground(Color.BLUE);
        JTextField textField = new JTextField(15);
        textField.setPreferredSize(new Dimension(200, 30));

        String[] operations = {
            "Addition", "Subtraction", "Multiplication", "Division", "Modulo"
        };
        JComboBox <String> operataionBox = new JComboBox<>(operations);

        headerPanel.add(titleLabel);
        buttonPanel.add(submitButton);
        buttonPanel.add(operataionBox);
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
