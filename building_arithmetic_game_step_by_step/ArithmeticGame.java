package building_arithmetic_game_step_by_step;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JRadioButton;
import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.JOptionPane;
import javax.swing.SwingUtilities;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionListener;

import java.util.Random;

public class ArithmeticGame extends JFrame {

    public ArithmeticGame() {
        setTitle("Interactive Arithmetic Game");
        setSize(750, 700);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        JLabel titleLabel = new JLabel("Interactive Arithmetic Game", JLabel.CENTER);
        titleLabel.setFont(new Font("Arial", Font.BOLD, 28));
        titleLabel.setForeground(Color.BLUE);

        JButton submitButton = new JButton("Submit");

        JPanel headerPanel = new JPanel();
        JPanel buttonPanel = new JPanel();
        JPanel questionPanel = new JPanel();

        questionPanel.setBackground(Color.WHITE);
        JLabel questionLabel = new JLabel("Your Question Will Appear Here", JLabel.CENTER);
        questionLabel.setFont(new Font("Arial", Font.BOLD, 24));

        headerPanel.setBackground(Color.LIGHT_GRAY);
        headerPanel.setBorder(BorderFactory.createEmptyBorder(20, 10, 20, 10));

        headerPanel.add(titleLabel);
        buttonPanel.add(submitButton);
        questionPanel.add(questionLabel);
        questionPanel.add(buttonPanel);

        add(headerPanel, BorderLayout.NORTH);
        add(questionPanel, BorderLayout.CENTER);
        setVisible(true);

    }

    public static void main(String[] args) {
        new ArithmeticGame();
    }
}
