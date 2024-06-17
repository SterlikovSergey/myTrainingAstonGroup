package by.st.Exeptions;

import java.util.*;

public class ExceptionsMain {
    public static void main(String[] args) {
        // Пример 1: NullPointerException

        try {
            String str = null;
            str.length();
        } catch (MyExceptions e) {
            System.out.println("Caught RuntimeException: " + e);
        }

        // Пример 2: ArrayIndexOutOfBoundsException
        try {
            int[] array = new int[5];
            int number = array[10];
        } catch (MyExceptions e) {
            System.out.println("Caught RuntimeException: " + e);
        }

        // Пример 3: ArithmeticException
        try {
            int result = 10 / 0;
        } catch (MyExceptions e) {
            System.out.println("Caught RuntimeException: " + e);
        }

        // Пример 4: ClassCastException
        try {
            Object x = new Integer(0);
            System.out.println((String)x);
        } catch (MyExceptions e) {
            System.out.println("Caught RuntimeException: " + e);
        }

        // Пример 5: IllegalArgumentException
        try {
            Thread thread = new Thread();
            thread.setPriority(11); // Приоритет должен быть от 1 до 10
        } catch (MyExceptions e) {
            System.out.println("Caught RuntimeException: " + e);
        }

        // Пример 6: MoSuchElementExcention
        try{
            List<String> list = new ArrayList<>();
            Iterator<String> iterator = list.iterator();
            iterator.next();
        }catch (MyExceptions e){
            System.out.println("Caught RuntimeException: " + e);
        }
    }
}

