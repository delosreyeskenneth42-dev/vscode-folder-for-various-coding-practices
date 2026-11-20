
package building_arithmetic_game_step_by_step.operations;

public class Subtraction extends ArithmeticOperation {

    @Override
    public int calculate(int firstNumber, int secondNumber) {
        return firstNumber - secondNumber;
    }

    @Override
    public String getSymbol() {
        return "-";
    }

}
