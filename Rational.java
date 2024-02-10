import java.math.BigInteger;

public class Rational extends Number implements Comparable<Rational> {
    private final BigInteger numerator;
    private final BigInteger denominator;

    // Construct a rational with default properties
    public Rational() {
        this(BigInteger.ZERO, BigInteger.ONE);
    }

    // Construct a rational with specified numerator and denominator
    public Rational(BigInteger numerator, BigInteger denominator) {
        BigInteger gcd = gcd(numerator, denominator);
        this.numerator = (denominator.compareTo(BigInteger.ZERO) > 0) ? numerator.divide(gcd) : numerator.divide(gcd).negate();
        this.denominator = denominator.divide(gcd);
    }

    // Find gcd of two numbers
    private static BigInteger gcd(BigInteger n, BigInteger d) {
        BigInteger n1 = n.abs();
        BigInteger n2 = d.abs();
        BigInteger gcd = BigInteger.ONE;

        for (BigInteger k = BigInteger.ONE; k.compareTo(n1) <= 0 && k.compareTo(n2) <= 0; k = k.add(BigInteger.ONE)) {
            if (n1.remainder(k).equals(BigInteger.ZERO) && n2.remainder(k).equals(BigInteger.ZERO)) {
                gcd = k;
            }
        }

        return gcd;
    }

    // Return numerator
    public BigInteger getNumerator() {
        return numerator;
    }

    // Return denominator
    public BigInteger getDenominator() {
        return denominator;
    }

    // Add a rational number to this rational
    public Rational add(Rational secondRational) {
        BigInteger n = numerator.multiply(secondRational.getDenominator()).add(denominator.multiply(secondRational.getNumerator()));
        BigInteger d = denominator.multiply(secondRational.getDenominator());
        return new Rational(n, d);
    }

    // Subtract a rational number from this rational
    public Rational subtract(Rational secondRational) {
        BigInteger n = numerator.multiply(secondRational.getDenominator()).subtract(denominator.multiply(secondRational.getNumerator()));
        BigInteger d = denominator.multiply(secondRational.getDenominator());
        return new Rational(n, d);
    }

    // Multiply a rational number by this rational
    public Rational multiply(Rational secondRational) {
        BigInteger n = numerator.multiply(secondRational.getNumerator());
        BigInteger d = denominator.multiply(secondRational.getDenominator());
        return new Rational(n, d);
    }

    // Divide a rational number by this rational
    public Rational divide(Rational secondRational) {
        BigInteger n = numerator.multiply(secondRational.getDenominator());
        BigInteger d = denominator.multiply(secondRational.getNumerator());
        return new Rational(n, d);
    }

    // Override toString() method
    @Override
    public String toString() {
        if (denominator.equals(BigInteger.ONE))
            return numerator + "";
        else
            return numerator + "/" + denominator;
    }

    // Override the equals method in the Object class
    @Override
    public boolean equals(Object other) {
        if ((this.subtract((Rational) (other))).getNumerator().equals(BigInteger.ZERO))
            return true;
        else
            return false;
    }

    // Implement the abstract intValue method in Number
    @Override
    public int intValue() {
        return (int) doubleValue();
    }

    // Implement the abstract floatValue method in Number
    @Override
    public float floatValue() {
        return (float) doubleValue();
    }

    // Implement the abstract doubleValue method in Number
    @Override
    public double doubleValue() {
        return numerator.doubleValue() / denominator.doubleValue();
    }

    // Implement the abstract longValue method in Number
    @Override
    public long longValue() {
        return (long) doubleValue();
    }

    // Implement the compareTo method in Comparable
    @Override
    public int compareTo(Rational o) {
        BigInteger thisNumerator = this.numerator.multiply(o.denominator);
        BigInteger otherNumerator = o.numerator.multiply(this.denominator);

        return thisNumerator.compareTo(otherNumerator);
    }
}

