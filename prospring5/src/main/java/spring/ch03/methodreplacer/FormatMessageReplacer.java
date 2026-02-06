package spring.ch03.methodreplacer;

import org.springframework.beans.factory.support.MethodReplacer;

import java.lang.reflect.Method;

public class FormatMessageReplacer implements MethodReplacer {

    @Override
    public Object reimplement(Object obj, Method method, Object[] args) {
        if (isFormatMessageMethod(method)) {
            var msg = (String) args[0];
            return "<h2>" + msg + "</h2>";
        } else {
            throw new IllegalArgumentException(
                    "Unable to reimplement method " + method.getName()
            );
        }
    }

    private boolean isFormatMessageMethod(Method method) {
        return "formatMessage".equals(method.getName())
                && method.getParameterTypes().length == 1
                && method.getParameterTypes()[0] == String.class
                && method.getReturnType() == String.class;
    }
}
