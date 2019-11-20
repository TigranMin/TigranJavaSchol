package lesson6;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.util.Objects;

public class CustomInvocationHandler implements InvocationHandler {

    private CalculatorImpl calculator;

    CustomInvocationHandler(CalculatorImpl calculator) {
        this.calculator = calculator;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        if (method.getName().equals("calc") && CalculatorImpl.getCache().containsKey(args[0])){
            return CalculatorImpl.getCache().get(args[0]);
        }
        return method.invoke(calculator, args);
    }
}
