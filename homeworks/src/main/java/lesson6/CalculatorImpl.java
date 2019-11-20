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
        cache.put(x, result);
        return result;
    }

    private static Map<Integer, Integer> cache = new HashMap<>();

    static Map<Integer, Integer> getCache() {
        return cache;
    }

    public static void main(String[] args) {
        CalculatorImpl calculator = new CalculatorImpl();
        ClassLoader classLoader = calculator.getClass().getClassLoader();
        Class[] interfaces = calculator.getClass().getInterfaces();
        CustomInvocationHandler invocationHandler = new CustomInvocationHandler(calculator);

        calculator.calc(10);

        Calculator cached = (Calculator) Proxy.newProxyInstance(classLoader, interfaces, invocationHandler);
        System.out.println(cached.calc(10));
        System.out.println(cached.calc(11));
        System.out.println(cached.calc(10));
    }
}
