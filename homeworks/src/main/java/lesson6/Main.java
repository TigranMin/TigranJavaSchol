package lesson6;

import java.lang.reflect.Proxy;

public class Main {
    public static void main(String[] args) {

        CalculatorImpl calculator = new CalculatorImpl();

        Class[] interfaces = calculator.getClass().getInterfaces();
        ClassLoader classLoader = calculator.getClass().getClassLoader();
        CachedProxy cachedProxy = new CachedProxy(calculator);

        Calculator cached = (Calculator) Proxy.newProxyInstance(classLoader, interfaces, cachedProxy);
        System.out.println(cached.calc(10));
        System.out.println(cached.calc(999));
        System.out.println(cached.calc(10));
        System.out.println(cached.calc(999));


    }
}
