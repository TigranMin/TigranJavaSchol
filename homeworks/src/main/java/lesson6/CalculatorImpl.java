package lesson6;

import java.lang.reflect.Proxy;
import java.util.HashMap;
import java.util.Map;

public class CalculatorImpl implements Calculator {

    public Integer calc(Integer x) {
        int result = 1;
        for (int i = 1; i < x + 1; i++) {
            result = result * i;
        }
        System.out.print("Calculated by calc method: ");
        return result;
    }
}
