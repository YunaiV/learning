package cn.iocoder.learning.bytebuddy;

import net.bytebuddy.ByteBuddy;
import net.bytebuddy.dynamic.loading.ClassLoadingStrategy;
import net.bytebuddy.implementation.FixedValue;
import net.bytebuddy.matcher.ElementMatchers;

public class Example001 {

    public static void main(String[] args) throws IllegalAccessException, InstantiationException {
        Class dynamicType = new ByteBuddy()
                .subclass(Object.class)
                .method(ElementMatchers.named("toString"))

                .intercept(FixedValue.value("Hello World!"))
                .make()
                .load(Example001.class.getClassLoader(), ClassLoadingStrategy.Default.WRAPPER)
                .getLoaded();
        Object s = dynamicType.newInstance();
        System.out.println(s);
    }

}
