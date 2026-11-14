package building_arithmetic_game_step_by_step;

import javax.swing.JFrame;

public class ArithmeticGame extends JFrame{
    
    public ArithmeticGame(){
        setTitle("Interactive Arithmetic Game");
        setSize(750,700);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setVisible(true);
    }
    public static void main(String[] args){
        new ArithmeticGame();
    }
}
