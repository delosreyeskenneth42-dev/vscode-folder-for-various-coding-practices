
package building_arithmetic_game_step_by_step;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JRadioButton;
import javax.swing.ButtonGroup;
import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.FlowLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.awt.Dimension;
import java.awt.event.ActionListener;

import java.util.Random;

public class ArithmeticGame extends JFrame {
    private Random random = new Random();

    private JLabel firstNumberLabel;
    private JLabel operatorLabel;
    private JLabel secondNumberLabel;

    private JRadioButton additionButton;
    private JRadioButton subtractionButton;
    private JRadioButton multiplicationButton;
    private JRadioButton divisionButton;
    private JRadioButton moduloButton;

    private JRadioButton easyButton;
    private JRadioButton mediumButton;
    private JRadioButton hardButton;

    private int correctAnswer;
    private JTextField answerField;
    private JLabel correctScore;
    private JLabel incorrectScore;
    private int correctCount;
    private int incorrectCount;

    private void generateQuestion() {
        int min = 1;
        int max = 50;

        if (easyButton.isSelected()) {
            min = 1;
            max = 50;
        } else if (mediumButton.isSelected()) {
            min = 51;
            max = 100;
        } else if (hardButton.isSelected()) {
            min = 101;
            max = 200;
        }

        int firstNumber;
        int secondNumber;

        if (divisionButton.isSelected()) {
            firstNumber = random.nextInt(max - min + 1) + min;

            do {
                secondNumber = random.nextInt(firstNumber) + 1;
            } while (firstNumber % secondNumber != 0);
        } else {
            firstNumber = random.nextInt(max - min + 1) + min;
            secondNumber = random.nextInt(max - min + 1) + min;
        }

        firstNumberLabel.setText(String.valueOf(firstNumber));
        secondNumberLabel.setText(String.valueOf(secondNumber));

        if (additionButton.isSelected()) {
            operatorLabel.setText("+");
            correctAnswer = firstNumber + secondNumber;
        } else if (subtractionButton.isSelected()) {
            operatorLabel.setText("-");
            correctAnswer = firstNumber - secondNumber;
        } else if (multiplicationButton.isSelected()) {
            operatorLabel.setText("×");
            correctAnswer = firstNumber * secondNumber;
        } else if (divisionButton.isSelected()) {
            operatorLabel.setText("÷");
            correctAnswer = firstNumber / secondNumber;
        } else if (moduloButton.isSelected()) {
            operatorLabel.setText("%");
            correctAnswer = firstNumber % secondNumber;
        }
    }

    private void checkAnswer() {
        String userInput = answerField.getText();

        try {
            int playerAnswer = Integer.parseInt(userInput);

            if (playerAnswer == correctAnswer) {
                correctCount++;
                correctScore.setText(String.valueOf(correctCount));
            } else {
                incorrectCount++;
                incorrectScore.setText(String.valueOf(incorrectCount));
            }
            answerField.setText("");
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "Please enter a valid number!");
        }
        generateQuestion();
    }

    public ArithmeticGame() {

        setTitle("Interactive Arithmetic Game");
        setSize(750, 700);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        // Header Panel
        JLabel titleLabel = new JLabel("Interactive Arithmetic Game", JLabel.CENTER);
        titleLabel.setFont(new Font("Arial", Font.BOLD, 28));
        titleLabel.setForeground(Color.BLUE);

        JPanel headerPanel = new JPanel();
        headerPanel.setBackground(Color.LIGHT_GRAY);
        headerPanel.setBorder(BorderFactory.createEmptyBorder(20, 10, 20, 10));
        headerPanel.add(titleLabel);

        // Question Panel
        JPanel questionPanel = new JPanel(new BorderLayout());

        // Equation Panel
        JPanel equationPanel = new JPanel(new GridLayout(1, 5, 15, 0));

        firstNumberLabel = new JLabel("10", JLabel.CENTER);
        firstNumberLabel.setFont(new Font("Arial", Font.BOLD, 28));
        firstNumberLabel.setBorder(BorderFactory.createLineBorder(Color.BLACK, 2));

        operatorLabel = new JLabel("×", JLabel.CENTER);
        operatorLabel.setFont(new Font("Arial", Font.BOLD, 28));

        secondNumberLabel = new JLabel("3", JLabel.CENTER);
        secondNumberLabel.setFont(new Font("Arial", Font.BOLD, 28));
        secondNumberLabel.setBorder(BorderFactory.createLineBorder(Color.BLACK, 2));

        firstNumberLabel.setPreferredSize(new Dimension(80, 60));
        secondNumberLabel.setPreferredSize(new Dimension(80, 60));

        JLabel equalLabel = new JLabel("=", JLabel.CENTER);
        equalLabel.setFont(new Font("Arial", Font.BOLD, 28));

        answerField = new JTextField(5);
        answerField.setFont(new Font("Arial", Font.BOLD, 24));
        answerField.setPreferredSize(new Dimension(80, 60));
        answerField.setBorder(BorderFactory.createLineBorder(Color.BLACK, 2));

        answerField.addActionListener(e -> checkAnswer());

        JPanel answerPanel = new JPanel();
        answerPanel.setLayout(new BoxLayout(answerPanel, BoxLayout.Y_AXIS));

        equationPanel.add(firstNumberLabel);
        equationPanel.add(operatorLabel);
        equationPanel.add(secondNumberLabel);
        equationPanel.add(equalLabel);

        // Submit Button Panel
        JButton submitButton = new JButton("Submit");

        submitButton.addActionListener(e -> checkAnswer());

        answerPanel.add(Box.createVerticalStrut(40));
        answerPanel.add(answerField);
        answerPanel.add(Box.createVerticalStrut(10));
        answerPanel.add(submitButton);

        equationPanel.add(answerPanel);

        questionPanel.add(equationPanel, BorderLayout.CENTER);

        // Options Panel
        JPanel optionsPanel = new JPanel(new GridLayout(1, 3, 15, 0));

        // Operation Panel
        JLabel operationLabel = new JLabel("Operation:");
        operationLabel.setFont(new Font("Arial", Font.BOLD, 18));

        additionButton = new JRadioButton("Addition");
        subtractionButton = new JRadioButton("Subtraction");
        multiplicationButton = new JRadioButton("Multiplication");
        divisionButton = new JRadioButton("Division");
        moduloButton = new JRadioButton("Modulo");

        additionButton.addActionListener(e -> generateQuestion());
        subtractionButton.addActionListener(e -> generateQuestion());
        multiplicationButton.addActionListener(e -> generateQuestion());
        divisionButton.addActionListener(e -> generateQuestion());
        moduloButton.addActionListener(e -> generateQuestion());

        ButtonGroup operationGroup = new ButtonGroup();

        operationGroup.add(additionButton);
        operationGroup.add(subtractionButton);
        operationGroup.add(multiplicationButton);
        operationGroup.add(divisionButton);
        operationGroup.add(moduloButton);

        multiplicationButton.setSelected(true);

        JPanel operationPanel = new JPanel();
        operationPanel.setLayout(new BoxLayout(operationPanel, BoxLayout.Y_AXIS));
        operationPanel.setBackground(Color.RED);

        operationPanel.add(Box.createVerticalStrut(100));
        operationPanel.add(operationLabel);
        operationPanel.add(Box.createVerticalStrut(10));
        operationPanel.add(additionButton);
        operationPanel.add(Box.createVerticalStrut(10));
        operationPanel.add(subtractionButton);
        operationPanel.add(Box.createVerticalStrut(10));
        operationPanel.add(multiplicationButton);
        operationPanel.add(Box.createVerticalStrut(10));
        operationPanel.add(divisionButton);
        operationPanel.add(Box.createVerticalStrut(10));
        operationPanel.add(moduloButton);

        // Difficulty Panel
        JLabel difficultyLabel = new JLabel("Level:");
        difficultyLabel.setFont(new Font("Arial", Font.BOLD, 18));

        easyButton = new JRadioButton("Level 1 (1-50)");
        mediumButton = new JRadioButton("Level 2 (51-100)");
        hardButton = new JRadioButton("Level 3 (101-200)");

        easyButton.addActionListener(e -> generateQuestion());
        mediumButton.addActionListener(e -> generateQuestion());
        hardButton.addActionListener(e -> generateQuestion());

        ButtonGroup difficultyGroup = new ButtonGroup();

        difficultyGroup.add(easyButton);
        difficultyGroup.add(mediumButton);
        difficultyGroup.add(hardButton);

        easyButton.setSelected(true);

        generateQuestion();

        JPanel difficultyPanel = new JPanel();
        difficultyPanel.setLayout(new BoxLayout(difficultyPanel, BoxLayout.Y_AXIS));

        difficultyPanel.add(Box.createVerticalStrut(100));
        difficultyPanel.add(difficultyLabel);
        difficultyPanel.add(Box.createVerticalStrut(10));
        difficultyPanel.add(easyButton);
        difficultyPanel.add(Box.createVerticalStrut(10));
        difficultyPanel.add(mediumButton);
        difficultyPanel.add(Box.createVerticalStrut(10));
        difficultyPanel.add(hardButton);

        // Score Panel
        JLabel scoreLabel = new JLabel("Score:");
        scoreLabel.setFont(new Font("Arial", Font.BOLD, 18));
        scoreLabel.setAlignmentX(Component.LEFT_ALIGNMENT);

        JLabel correctLabel = new JLabel("Correct", JLabel.CENTER);
        correctLabel.setFont(new Font("Arial", Font.BOLD, 16));

        JLabel incorrectLabel = new JLabel("Incorrect", JLabel.CENTER);
        incorrectLabel.setFont(new Font("Arial", Font.BOLD, 16));

        correctScore = new JLabel("0", JLabel.CENTER);
        correctScore.setFont(new Font("Arial", Font.BOLD, 24));

        incorrectScore = new JLabel("0", JLabel.CENTER);
        incorrectScore.setFont(new Font("Arial", Font.BOLD, 24));

        // Correct Score Box
        JPanel correctBox = new JPanel(new BorderLayout());
        correctBox.setBorder(BorderFactory.createLineBorder(Color.BLACK, 2));
        correctBox.setPreferredSize(new Dimension(80, 70));
        correctBox.setMinimumSize(new Dimension(80, 70));
        correctBox.setMaximumSize(new Dimension(80, 70));

        correctBox.add(correctScore, BorderLayout.CENTER);

        JPanel correctPanel = new JPanel();
        correctPanel.setLayout(new BoxLayout(correctPanel, BoxLayout.Y_AXIS));

        correctLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        correctBox.setAlignmentX(Component.CENTER_ALIGNMENT);

        correctPanel.add(correctLabel);
        correctPanel.add(Box.createVerticalStrut(10));
        correctPanel.add(correctBox);

        // Incorrect Score Box
        JPanel incorrectBox = new JPanel(new BorderLayout());
        incorrectBox.setBorder(BorderFactory.createLineBorder(Color.BLACK, 2));
        incorrectBox.setPreferredSize(new Dimension(80, 70));
        incorrectBox.setMinimumSize(new Dimension(80, 70));
        incorrectBox.setMaximumSize(new Dimension(80, 70));

        incorrectBox.add(incorrectScore, BorderLayout.CENTER);

        JPanel incorrectPanel = new JPanel();
        incorrectPanel.setLayout(new BoxLayout(incorrectPanel, BoxLayout.Y_AXIS));

        incorrectLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        incorrectBox.setAlignmentX(Component.CENTER_ALIGNMENT);

        incorrectPanel.add(incorrectLabel);
        incorrectPanel.add(Box.createVerticalStrut(10));
        incorrectPanel.add(incorrectBox);

        // Score Values Panel
        JPanel scoreValuesPanel = new JPanel(new GridLayout(1, 2, 5, 0));
        scoreValuesPanel.setBackground(Color.CYAN);
        scoreValuesPanel.setAlignmentX(Component.LEFT_ALIGNMENT);

        scoreValuesPanel.add(correctPanel);
        scoreValuesPanel.add(incorrectPanel);

        JPanel scorePanel = new JPanel();
        scorePanel.setLayout(new BoxLayout(scorePanel, BoxLayout.Y_AXIS));

        scorePanel.add(Box.createVerticalStrut(100));
        scorePanel.add(scoreLabel);
        scorePanel.add(Box.createVerticalStrut(10));
        scorePanel.add(scoreValuesPanel);

        // Add Bottom Sections
        optionsPanel.add(operationPanel);
        optionsPanel.add(difficultyPanel);
        optionsPanel.add(scorePanel);

        // Main Layout
        JPanel mainPanel = new JPanel(new BorderLayout(15, 20));

        mainPanel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));

        mainPanel.add(questionPanel, BorderLayout.NORTH);
        mainPanel.add(optionsPanel, BorderLayout.CENTER);

        add(headerPanel, BorderLayout.NORTH);
        add(mainPanel, BorderLayout.CENTER);

        setVisible(true);
    }

    public static void main(String[] args) {
        new ArithmeticGame();
    }
}
