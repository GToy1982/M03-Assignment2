import java.math.BigInteger;
import java.util.Scanner;

public class TestRational {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        // Prompt the user to enter two rational numbers
        System.out.print("Enter the first rational number: ");
        BigInteger num1 = input.nextBigInteger();
        BigInteger den1 = input.nextBigInteger();

        System.out.print("Enter the second rational number: ");
        BigInteger num2 = input.nextBigInteger();
        BigInteger den2 = input.nextBigInteger();

        // Create and display the rational numbers
        Rational rational1 = new Rational(num1, den1);
        Rational rational2 = new Rational(num2, den2);

        System.out.println(rational1 + " + " + rational2 + " = " + rational1.add(rational2));
        System.out.println(rational1 + " - " + rational2 + " = " + rational1.subtract(rational2));
        System.out.println(rational1 + " * " + rational2 + " = " + rational1.multiply(rational2));
        System.out.println(rational1 + " / " + rational2 + " = " + rational1.divide(rational2));
        System.out.println(rational2 + " is " + rational2.doubleValue());
    }
}
