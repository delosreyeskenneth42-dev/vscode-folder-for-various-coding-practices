package build_calculator_with_java_swing_practice;

import javax.swing.*;
import java.awt.*;

public class Simple_Calculator_Practice extends JFrame {
    public Simple_Calculator_Practice(){
        setTitle("Simple Calculator");
        setSize(400, 500);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        JPanel mainPanel = new JPanel(new BorderLayout(10, 10));

        JPanel optionsPanel = new JPanel();
        optionsPanel.setLayout(new BoxLayout(optionsPanel, BoxLayout.Y_AXIS));

        JPanel textPanel = new JPanel();
        JPanel equationsPanel = new JPanel(new GridLayout(5, 4, 0, 0));
        equationsPanel.setPreferredSize(new Dimension(100, 170));

        JButton acButton = new JButton("AC");
        JButton undoButton = new JButton("<-");
        JButton redoButton = new JButton("->");
        JButton divisionButton = new JButton("➗");
        JButton sevenButton = new JButton("7");
        JButton eightButton = new JButton("8");
        JButton nineButton = new JButton("9");
        JButton multiplicationButton = new JButton("X");
        JButton fourButton = new JButton("4");
        JButton fiveButton = new JButton("5");
        JButton sixButton = new JButton("6");
        JButton subtractionButton = new JButton("-");
        JButton oneButton = new JButton("1");
        JButton twoButton = new JButton("2");
        JButton threeButton = new JButton("3");
        JButton additionButton = new JButton("+");
        JButton moduloButton = new JButton("%");
        JButton zeroButton = new JButton("0");
        JButton dotButton = new JButton(".");
        JButton equalButton = new JButton("=");

        equationsPanel.add(acButton);
        equationsPanel.add(undoButton);
        equationsPanel.add(redoButton);
        equationsPanel.add(divisionButton);
        equationsPanel.add(sevenButton);
        equationsPanel.add(eightButton);
        equationsPanel.add(nineButton);
        equationsPanel.add(multiplicationButton);
        equationsPanel.add(fourButton);
        equationsPanel.add(fiveButton);
        equationsPanel.add(sixButton);
        equationsPanel.add(subtractionButton);
        equationsPanel.add(oneButton);
        equationsPanel.add(twoButton);
        equationsPanel.add(threeButton);
        equationsPanel.add(additionButton);
        equationsPanel.add(moduloButton);
        equationsPanel.add(zeroButton);
        equationsPanel.add(dotButton);
        equationsPanel.add(equalButton);
        
        optionsPanel.add(textPanel);
        optionsPanel.add(equationsPanel);

        mainPanel.add(optionsPanel);
        add(mainPanel);
        setVisible(true);
    }
    public static void main(String[] args){
        new Simple_Calculator_Practice();
    }
}
