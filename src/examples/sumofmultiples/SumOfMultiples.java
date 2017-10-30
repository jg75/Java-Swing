package examples.sumofmultiples;

import java.math.BigInteger;
import java.util.Set;
import java.util.TreeSet;

/**
 *
 * @author jgarner1
 */
public class SumOfMultiples {
    
    private Set<BigInteger> factors;
    private BigInteger range;
    private boolean inclusive;
    private BigInteger sum;
    
    /**
     * Default Constructor.
     */
    public SumOfMultiples() {
        
        factors = new TreeSet<>();
        range = BigInteger.ONE;
        inclusive = false;
        sum = sumOfMultiples(factors, range, inclusive);
    }

    /**
     * Constructor.
     * @param factors a set of numbers
     * @param range the range
     * @param inclusive true if the range is inclusive
     */
    public SumOfMultiples(Set<BigInteger> factors,
                          BigInteger range,
                          boolean inclusive) {
        
        this.factors = factors;
        this.range = range;
        this.inclusive = inclusive;
        sum = sumOfMultiples(factors, range, inclusive);
    }

    /**
     * Gets the factors.
     * @return the factors
     */
    public Set<BigInteger> getFactors() {
        return factors;
    }
    
    /**
     * Sets the factors.
     * @param factors a set of factors
     */
    public void setFactors(Set<BigInteger> factors) {
        this.factors = factors;
        sum = sumOfMultiples(factors, range, inclusive);
    }

    /**
     * Gets the range.
     * @return the range
     */
    public BigInteger getRange() {
        return range;
    }

    /**
     * Sets the range.
     * @param range the range
     */
    public void setRange(BigInteger range) {
        this.range = range;
        sum = sumOfMultiples(factors, range, inclusive);
    }

    /**
     * Checks if the range is inclusive.
     * @return true if the range is inclusive
     */
    public boolean isInclusive() {
        return inclusive;
    }

    /**
     * Set to true if the range should be inclusive.
     * @param inclusive true if the range should be inclusive
     */
    public void setInclusive(boolean inclusive) {
        this.inclusive = inclusive;
        sum = sumOfMultiples(factors, range, inclusive);
    }
    
    /**
     * Gets the sum of the multiples of the set of numbers within the range.
     * @return the sum
     */
    public BigInteger getSum() {
        return sum;
    }
    
    /**
     * Gets the greatest common divisor of two numbers.
     * @param a number
     * @param b number
     * @return the greatest common divisor
     */
    public static BigInteger gcd(BigInteger a, BigInteger b) {
        
        while (b.compareTo(BigInteger.ZERO) > 0) {
            BigInteger t = b;
            b = a.mod(b);
            a = t;
        }
        
        return a;
    }
    
    /**
     * Gets the least common multiple of two numbers.
     * @param a number
     * @param b number
     * @return the least common multiple
     */
    public static BigInteger lcm(BigInteger a, BigInteger b) {
        
        BigInteger gcd = gcd(a, b);
        
        if (gcd.compareTo(BigInteger.ONE) == 0) {
            return a.multiply(b);
        }
        
        return gcd;
    }
    
    /**
     * Gets a set of the least common multiples of the pairs of numbers in a set.
     * @param numberSet a set of numbers
     * @return a set of the least common multiples of the pairs of numbers in a set
     */
    public static Set<BigInteger> lcm(Set<BigInteger> numberSet) {
        
        BigInteger[] numbers = numberSet.toArray(new BigInteger[numberSet.size()]);
        Set<BigInteger> lcmSet = new TreeSet<>();
        
        for (int i = 0; i < numbers.length; i++) {
            for (int j = numbers.length -1; j > i; j--) {
                lcmSet.add(lcm(numbers[i], numbers[j]));
            }
        }
        
        return lcmSet;
    }
    
    /**
     * Gets the sum of the multiples of a number within a range.
     * @param factor the number
     * @param range the range
     * @param inclusive true if the range is inclusive
     * @return the sum of the multiples of a number within a range
     */
    public static BigInteger sumOfMultiples(BigInteger factor,
                                            BigInteger range,
                                            boolean inclusive) {
        BigInteger sum = BigInteger.ZERO;
        
        if (!inclusive) {
            range = range.subtract(BigInteger.ONE);
        }
        
        if (factor.compareTo(range) <= 0) {
            BigInteger count = range.divide(factor);
            BigInteger lastMultiple = factor.multiply(count);
        
            BigInteger term1 = factor.multiply(count);
            BigInteger term2 = lastMultiple.multiply(count);
            sum = term1.add(term2).divide(BigInteger.valueOf(2));
        }
        
        return sum;
    }
    
    /**
     * Gets the sum of the multiples of a set of numbers within a range.
     * @param factors a set of numbers
     * @param range the range
     * @param inclusive true if the range is inclusive
     * @return the sum of the multiples of a set of numbers within a range
     */
    public static BigInteger sumOfMultiples(Set<BigInteger> factors,
                                            BigInteger range,
                                            boolean inclusive) {
        
        Set<BigInteger> lcmSet = lcm(factors);
        BigInteger sum = BigInteger.ZERO;
        
        for (BigInteger factor : factors) {
            sum = sum.add(sumOfMultiples(factor, range, inclusive));
        }
        
        for (BigInteger factor : lcmSet) {
            sum = sum.subtract(sumOfMultiples(factor, range, inclusive));
        }
        
        return sum;
    }
    
    @Override
    public String toString() {
        return String.format("%,d", sum);
    }
}
