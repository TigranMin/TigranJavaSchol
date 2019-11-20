package lesson6;

import java.lang.reflect.Proxy;

public class Main {
    public static void main(String[] args) {

        Class[] interfaces = CalculatorImpl.class.getInterfaces();
        ClassLoader classLoader = CalculatorImpl.class.getClassLoader();
        CachedProxy cachedProxy = new CachedProxy(new CalculatorImpl());

        Calculator cached = (Calculator) Proxy.newProxyInstance(classLoader, interfaces, cachedProxy);
        System.out.println(cached.calc(10));
        System.out.println(cached.calc(11));
        System.out.println(cached.calc(10));

    }
}
