package it.unical.ingsw2024;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.mockito.Mock;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ParameterizedMathTest {

    private static MyMath myMath;


    @BeforeAll
    public static void prepareAll() {
        System.out.println("before all");
        myMath = new MyMath();
    }

    public ParameterizedMathTest() {
    }

    @ParameterizedTest
    //@ValueSource(ints = {1, 2, 3, 4, 5})
    //@EnumSource(Month.class)
    @CsvSource({"0,0", "1,1", "5,5", "6,8", "40,102334155"})
    public void fibonacciWorksParametrized(int value, int expected) {
        System.out.println("testing that fibonacci works parametrized");
        assertEquals(expected, myMath.fibonacci(value));
    }

}
