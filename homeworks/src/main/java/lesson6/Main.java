package lesson6;

import java.lang.reflect.Proxy;

public class Main {
    public static void main(String[] args) {

        CalculatorImpl calculator = new CalculatorImpl();

        Class[] interfaces = calculator.getClass().getInterfaces();
        ClassLoader classLoader = calculator.getClass().getClassLoader();
        CachedProxy cachedProxy = new CachedProxy(calculator);

        Calculator cachedCalc = (Calculator) Proxy.newProxyInstance(classLoader, interfaces, cachedProxy);
        System.out.println(cachedCalc.calc(10));
        System.out.println(cachedCalc.calc(999));
        System.out.println(cachedCalc.calc(10));
        System.out.println(cachedCalc.calc(999));

        ModifiersGetterImpl modifierGetter = new ModifiersGetterImpl();

        Class[] interfacesOfModGetter = modifierGetter.getClass().getInterfaces();
        ClassLoader classLoaderOfModGetter = modifierGetter.getClass().getClassLoader();
        CachedProxy cachedProxyOfModGetter = new CachedProxy(modifierGetter);

        ModifiersGetter cachedModGetter = (ModifiersGetter) Proxy.newProxyInstance(classLoaderOfModGetter, interfacesOfModGetter, cachedProxyOfModGetter);
        System.out.println(cachedModGetter.modsGetter(calculator));
        System.out.println(cachedModGetter.modsGetter(calculator));

    }
}
