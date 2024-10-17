package it.unical.ingsw2024;

public class MyMath {

    private ConnectionManager cm;

    /**
     * Creating dependency within the class makes testing difficult,
     * it might be better to receive the dependency from outside
     */
    public MyMath() {
        //this.cm =  new ConnectionManager();
    }

    /**
     * This constructor is used to receive the ConnectionManager dependency
     * (Set methods could also be used)
     */
    public MyMath(ConnectionManager cm) {
        this.cm = cm;
    }

    /**
     * Finds the nth number in the fibonacci series. The first index is 0.
     *
     * @param n the nth position
     * @return the nth number in the fibonacci series
     */
    public int fibonacci(int n) {
        if (n < 0) {
            throw new IllegalArgumentException("Illegal value " + n);
        }
        if (n == 0) {
            return 0;
        }
        if (n == 1) {
            return 1;
        }
        return fibonacci(n - 1) + fibonacci(n - 2);
    }

    /**
     * Calculates the factorial of a given number
     *
     * @param n the number to calculate the factorial
     * @return the factorial for a given integer
     */
    public int factorial(int n) {

        if (n == 0) {
            return 1;
        }
        return n * factorial(n - 1);
    }

    /**
     * This method is to simulate a network connection manager with Mockito
     *
     * @param n the number to calculate the factorial
     * @return the factorial calculated remotely
     */
    public int remoteFactorial(int n) {
        if (!cm.isNetworkConnected()) {
            throw new RuntimeException("It's not possible to reach the server");
        }
        return 12345678;
    }

}
