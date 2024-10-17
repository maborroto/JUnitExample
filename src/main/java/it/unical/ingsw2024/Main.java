package it.unical.ingsw2024;

public class Main {

    public static void main(String[] args) {
        MyMath myMath = new MyMath();
        System.out.println("First number in the Fibonacci sequence:");
        for (int i = 0; i < 12; i++) {
            System.out.println(myMath.fibonacci(i));
        }
    }
}

