
import javax.swing.*;
import java.awt.*;
import java.util.Random;

// INTERFACE
interface Scoreable {
    void updateScore(boolean correct);
}

// ABSTRACT CLASS
abstract class ArithmeticOperation {
    abstract int calculate(int a, int b);
    abstract String getSymbol();
}

// INHERITANCE
class Addition extends ArithmeticOperation {
    int calculate(int a, int b) {
        return a + b;
    }

    String getSymbol() {
        return "+";
    }
}

class Subtraction extends ArithmeticOperation {
    int calculate(int a, int b) {
        return a - b;
    }

    String getSymbol() {
        return "-";
    }
}

class Multiplication extends ArithmeticOperation {
    int calculate(int a, int b) {
        return a * b;
    }

    String getSymbol() {
        return "x";
    }
}

class Division extends ArithmeticOperation {
    int calculate(int a, int b) {
        return a / b;
    }

    String getSymbol() {
        return "/";
    }
}

class Modulo extends ArithmeticOperation {
    int calculate(int a, int b) {
        return a % b;
    }

    String getSymbol() {
        return "%";
    }
}

// MAIN GUI CLASS
public class ArithmeticGame extends JFrame implements Scoreable {

    Random random = new Random();

    int num1, num2, answer;
    int correct = 0;
    int incorrect = 0;

    JLabel number1Label = new JLabel();
    JLabel number2Label = new JLabel();
    JLabel operatorLabel = new JLabel();

    JLabel correctLabel = new JLabel("Correct: 0");
    JLabel incorrectLabel = new JLabel("Incorrect: 0");

    JTextField answerField = new JTextField(8);

    JButton submitButton = new JButton("Submit");

    JRadioButton add = new JRadioButton("Addition");
    JRadioButton subtract = new JRadioButton("Subtraction");
    JRadioButton multiply = new JRadioButton("Multiplication");
    JRadioButton divide = new JRadioButton("Division");
    JRadioButton modulo = new JRadioButton("Modulo");

    JRadioButton level1 = new JRadioButton("Level 1 (1-50)");
    JRadioButton level2 = new JRadioButton("Level 2 (51-100)");
    JRadioButton level3 = new JRadioButton("Level 3 (101-200)");

    ArithmeticGame() {

        setTitle("Interactive Arithmetic Game");
        setSize(750, 500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        // MAIN PANEL
        JPanel mainPanel = new JPanel(new BorderLayout(15, 15));
        mainPanel.setBorder(
            BorderFactory.createEmptyBorder(20, 20, 20, 20)
        );

        // TITLE
        JLabel title = new JLabel(
            "Interactive Arithmetic Game",
            JLabel.CENTER
        );

        title.setFont(new Font("Arial", Font.BOLD, 25));

        mainPanel.add(title, BorderLayout.NORTH);

        // QUESTION PANEL
        JPanel questionPanel = new JPanel();

        number1Label.setFont(new Font("Arial", Font.BOLD, 35));
        number2Label.setFont(new Font("Arial", Font.BOLD, 35));
        operatorLabel.setFont(new Font("Arial", Font.BOLD, 35));

        questionPanel.add(number1Label);
        questionPanel.add(operatorLabel);
        questionPanel.add(number2Label);
        questionPanel.add(new JLabel("="));
        questionPanel.add(answerField);
        questionPanel.add(submitButton);

        mainPanel.add(questionPanel, BorderLayout.CENTER);

        // OPERATION PANEL
        JPanel operationPanel = new JPanel();
        operationPanel.setLayout(
            new BoxLayout(operationPanel, BoxLayout.Y_AXIS)
        );

        operationPanel.setBorder(
            BorderFactory.createTitledBorder("Operation")
        );

        ButtonGroup operationGroup = new ButtonGroup();

        operationGroup.add(add);
        operationGroup.add(subtract);
        operationGroup.add(multiply);
        operationGroup.add(divide);
        operationGroup.add(modulo);

        operationPanel.add(add);
        operationPanel.add(subtract);
        operationPanel.add(multiply);
        operationPanel.add(divide);
        operationPanel.add(modulo);

        // LEVEL PANEL
        JPanel levelPanel = new JPanel();

        levelPanel.setLayout(
            new BoxLayout(levelPanel, BoxLayout.Y_AXIS)
        );

        levelPanel.setBorder(
            BorderFactory.createTitledBorder("Level")
        );

        ButtonGroup levelGroup = new ButtonGroup();

        levelGroup.add(level1);
        levelGroup.add(level2);
        levelGroup.add(level3);

        levelPanel.add(level1);
        levelPanel.add(level2);
        levelPanel.add(level3);

        // SCORE PANEL
        JPanel scorePanel = new JPanel();

        scorePanel.setLayout(
            new BoxLayout(scorePanel, BoxLayout.Y_AXIS)
        );

        scorePanel.setBorder(
            BorderFactory.createTitledBorder("Score")
        );

        scorePanel.add(correctLabel);
        scorePanel.add(incorrectLabel);

        // BOTTOM PANEL
        JPanel bottomPanel = new JPanel(new GridLayout(1, 3, 10, 10));

        bottomPanel.add(operationPanel);
        bottomPanel.add(levelPanel);
        bottomPanel.add(scorePanel);

        mainPanel.add(bottomPanel, BorderLayout.SOUTH);

        add(mainPanel);

        // DEFAULT SELECTIONS
        multiply.setSelected(true);
        level1.setSelected(true);

        // BUTTON ACTIONS
        submitButton.addActionListener(e -> checkAnswer());

        answerField.addActionListener(e -> checkAnswer());

        add.addActionListener(e -> generateQuestion());
        subtract.addActionListener(e -> generateQuestion());
        multiply.addActionListener(e -> generateQuestion());
        divide.addActionListener(e -> generateQuestion());
        modulo.addActionListener(e -> generateQuestion());

        level1.addActionListener(e -> generateQuestion());
        level2.addActionListener(e -> generateQuestion());
        level3.addActionListener(e -> generateQuestion());

        generateQuestion();

        setVisible(true);
    }

    // GET SELECTED OPERATION
    ArithmeticOperation getOperation() {

        if (add.isSelected()) {
            return new Addition();
        }

        if (subtract.isSelected()) {
            return new Subtraction();
        }

        if (multiply.isSelected()) {
            return new Multiplication();
        }

        if (divide.isSelected()) {
            return new Division();
        }

        return new Modulo();
    }

    // GET SELECTED LEVEL
    int getMaxNumber() {

        if (level1.isSelected()) {
            return 50;
        }

        if (level2.isSelected()) {
            return 100;
        }

        return 200;
    }

    // GENERATE RANDOM QUESTION
    void generateQuestion() {

        int max = getMaxNumber();

        num1 = random.nextInt(max) + 1;
        num2 = random.nextInt(max) + 1;

        ArithmeticOperation operation = getOperation();

        // Avoid negative subtraction
        if (subtract.isSelected() && num1 < num2) {
            int temp = num1;
            num1 = num2;
            num2 = temp;
        }

        // Make division answers whole numbers
        if (divide.isSelected()) {
            int quotient = random.nextInt(max / num2) + 1;
            num1 = num2 * quotient;
        }

        answer = operation.calculate(num1, num2);

        number1Label.setText("" + num1);
        number2Label.setText("" + num2);
        operatorLabel.setText(operation.getSymbol());

        answerField.setText("");
    }

    // CHECK PLAYER ANSWER
    void checkAnswer() {

        try {

            int playerAnswer = Integer.parseInt(
                answerField.getText()
            );

            if (playerAnswer == answer) {

                updateScore(true);

                JOptionPane.showMessageDialog(
                    this,
                    "Correct Answer!"
                );

            } else {

                updateScore(false);

                JOptionPane.showMessageDialog(
                    this,
                    "Incorrect! Correct answer: " + answer
                );
            }

            generateQuestion();

        } catch (NumberFormatException e) {

            JOptionPane.showMessageDialog(
                this,
                "Please enter a valid number!"
            );
        }
    }

    // INTERFACE METHOD
    public void updateScore(boolean isCorrect) {

        if (isCorrect) {
            correct++;
        } else {
            incorrect++;
        }

        correctLabel.setText("Correct: " + correct);
        incorrectLabel.setText("Incorrect: " + incorrect);
    }

    // MAIN METHOD
    public static void main(String[] args) {

        new ArithmeticGame();
    }
}
