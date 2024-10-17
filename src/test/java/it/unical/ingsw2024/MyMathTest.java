package it.unical.ingsw2024;

import org.junit.jupiter.api.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import static org.mockito.Mockito.*;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import java.time.Duration;
import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
public class MyMathTest {

    private static MyMath myMath;

    @Mock
    private ConnectionManager connectionManagerMock;

    @BeforeAll
    public static void prepareAll() {
        System.out.println("before all");
        //myMath = new MyMath();
    }

    @AfterAll
    public static void afterAll() {
        System.out.println("AFTER ALL");
    }

    @BeforeEach
    public void prepareTest() {
        System.out.println("BEFORE EACH");
        myMath = new MyMath(connectionManagerMock);
    }

    @AfterEach
    public void cleanTest() {
        System.out.println("AFTER EACH");
    }

    @Test
    public void fibonacciShouldThrowsIllegalArgumentExceptionOnNegativeNumber() {
        System.out.println("fibonacciThrowsException");
        //The fibonacci method should throw IllegalArgumentException.class
        Exception ex = assertThrows(IllegalArgumentException.class, () -> myMath.fibonacci(-1));
        //The exception message should be as expected
        assertEquals("Illegal value -1", ex.getMessage());
    }

    @Test
    public void fibonacciShouldWork() {
        System.out.println("Testing that fibonacci works");
        assertEquals(0, myMath.fibonacci(0));
        assertEquals(1, myMath.fibonacci(1));
        assertEquals(1, myMath.fibonacci(2));
        assertEquals(5, myMath.fibonacci(5));
        assertEquals(8, myMath.fibonacci(6));
        assertEquals(102334155, myMath.fibonacci(40));
    }

    @ParameterizedTest
    //@ValueSource(ints = {1, 2, 3, 4, 5})
    //@EnumSource(Month.class)
    @CsvSource({"0,0", "1,1", "5,5", "6,8", "40,102334155"})
    public void fibonacciWorksParametrized(int value, int expected) {
        System.out.println("testing that fibonacci works wit ParameterizedTest");
        assertEquals(expected, myMath.fibonacci(value));
    }

    @Test
    public void factorialWorks() {
        System.out.println("testing that factorial works");
        assertEquals(1, myMath.factorial(0));
        assertEquals(120, myMath.factorial(5));
    }

    @Test
    public void fibonacciIsFastEnough() {
        System.out.println("fibonacciIsFastEnough");
        assertTimeout(Duration.ofSeconds(1), () -> {
            myMath.fibonacci(40);
        });
    }

    @Test
    public void testOnDoubles() {
        System.out.println("testOnDoubles");
        assertEquals(0.3, 0.1 + 0.1 + 0.1, 0.001, "Test to show how the delta param works");
    }

    /**
     * Just to show that we can modify the Mocked instance behavior
     */
    @Test
    public void remoteFactorialWorks() {
        System.out.println("testing that remoteFactorial Works");
        when(connectionManagerMock.isNetworkConnected()).thenReturn(true);
        assertEquals(12345678, myMath.remoteFactorial(2));
    }

    /**
     * Just to show that we can modify the Mocked instance behavior
     */
    @Test
    public void remoteFactorialThrowsRuntimeExceptionExceptionOnConnectionProblem() {
        System.out.println("testing that remoteFactorial throws");
        when(connectionManagerMock.isNetworkConnected()).thenReturn(false);
        Exception ex = assertThrows(RuntimeException.class, () -> myMath.remoteFactorial(5));
        assertEquals("It's not possible to reach the server", ex.getMessage());

    }

}
