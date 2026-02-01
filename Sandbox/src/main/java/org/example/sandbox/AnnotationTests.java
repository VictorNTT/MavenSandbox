package org.example.sandbox;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class AnnotationTests {
    @MyClass
    static class ClassA {
        @MyMethod
        public void foo() {
            System.out.println("foo() is invoked");
        }
        public void bar() {
            System.out.println("bar()");
        }
    }

    public static void main(String[] args) throws InvocationTargetException, IllegalAccessException {
        Object object = new ClassA();
        for (Method m : object.getClass().getMethods())
        {
            if(m.isAnnotationPresent(MyMethod.class)) {
                m.invoke(object, null);
            }
        }
    }
}
