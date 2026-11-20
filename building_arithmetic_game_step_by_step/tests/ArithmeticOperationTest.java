
package building_arithmetic_game_step_by_step.tests;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.Disabled;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;

import building_arithmetic_game_step_by_step.operations.Addition;
import building_arithmetic_game_step_by_step.operations.Subtraction;
import building_arithmetic_game_step_by_step.operations.Multiplication;
import building_arithmetic_game_step_by_step.operations.Division;
import building_arithmetic_game_step_by_step.operations.Modulo;

public class ArithmeticOperationTest {

    private Addition addition;
    private Subtraction subtraction;
    private Multiplication multiplication;
    private Division division;
    private Modulo modulo;

    // Runs once before all tests
    @BeforeAll
    public static void setUpAll() {
        System.out.println("Starting Arithmetic Operation Tests...");
    }

    // Runs before every test
    @BeforeEach
    public void setUp() {
        addition = new Addition();
        subtraction = new Subtraction();
        multiplication = new Multiplication();
        division = new Division();
        modulo = new Modulo();
    }

    // ADDITION TEST
    @Test
    public void testAddition() {
        assertEquals(15, addition.calculate(10, 5));
    }

    // SUBTRACTION TEST
    @Test
    public void testSubtraction() {
        assertEquals(5, subtraction.calculate(10, 5));
    }

    // MULTIPLICATION TEST
    @Test
    public void testMultiplication() {
        assertEquals(50, multiplication.calculate(10, 5));
    }

    // DIVISION TEST
    @Test
    public void testDivision() {
        assertEquals(2, division.calculate(10, 5));
    }

    // MODULO TEST
    @Test
    public void testModulo() {
        assertEquals(2, modulo.calculate(12, 5));
    }

    // TESTING DIFFERENT ASSERTIONS
    @Test
    public void testAssertions() {

        assertNotEquals(20, addition.calculate(10, 5));

        assertTrue(addition.calculate(5, 5) == 10);

        assertFalse(subtraction.calculate(10, 5) == 10);

        assertNotNull(addition);
    }

    // TESTING DIVISION BY ZERO
    @Test
    public void testDivisionByZero() {
        assertThrows(
                ArithmeticException.class,
                () -> division.calculate(10, 0));
    }

    // TESTING MODULO BY ZERO
    @Test
    public void testModuloByZero() {
        assertThrows(
                ArithmeticException.class,
                () -> modulo.calculate(10, 0));
    }

    // DEMONSTRATION OF DISABLED TEST
    @Disabled("This test is intentionally skipped for demonstration.")
    @Test
    public void testDisabledExample() {
        assertEquals(2, addition.calculate(1, 1));
    }

    // Runs after every test
    @AfterEach
    public void tearDown() {
        addition = null;
        subtraction = null;
        multiplication = null;
        division = null;
        modulo = null;
    }

    // Runs once after all tests
    @AfterAll
    public static void tearDownAll() {
        System.out.println("Arithmetic Operation Tests Completed!");
    }

}
