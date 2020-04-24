package com.company;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

public class Main {

    public static void main(String[] args) throws Exception {

        Test obj = new Test();

        Class cls = obj.getClass();
        System.out.println("Class name is : " + cls.getName());

        Constructor[] constructors = cls.getConstructors();
        for(Constructor constructor : constructors) {
            System.out.println("Constructor name is : " + constructor.getName());
            System.out.println(constructor.getModifiers());
        }

        System.out.println("The public methods of this class are : ");
        Method[] methods = cls.getMethods();
        for(Method method : methods){
            System.out.println(method.getName());
        }

        Method methodcall1 = cls.getDeclaredMethod("ShowInt", int.class);
        methodcall1.invoke(obj, 17);

        Field field = cls.getDeclaredField("s");
        field.setAccessible(true);
        field.set(obj, "JAVA");

        Method methodcall2 = cls.getDeclaredMethod("ShowString");
        methodcall2.invoke(obj);

        Method methodcall3 = cls.getDeclaredMethod("Priv");
        methodcall3.setAccessible(true);
        methodcall3.invoke(obj);

    }
}
