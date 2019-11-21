package lesson6;

import java.math.BigInteger;

public class CalculatorImpl implements Calculator {

    public BigInteger calc(Integer x) {
        BigInteger result = BigInteger.valueOf(1);
        for (int i = 1; i < x + 1; i++) {
            result = result.multiply(BigInteger.valueOf(i)) ;
        }
        System.out.print("Calculated by calc: ");
        return result;
    }
}
