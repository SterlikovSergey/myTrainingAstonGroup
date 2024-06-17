package by.st.Exeptions;

import java.util.*;

public class ExceptionsMain {
    public static void main(String[] args) {
        // Пример 1: NullPointerException
        try {
            String str = null;
            if (str == null) {
                throw new MyExceptions("Null reference");
            }
            str.length();
        } catch (MyExceptions e) {
            System.out.println("Caught MyExceptions: " + e);
        }

        // Пример 2: ArrayIndexOutOfBoundsException
        try {
            int[] array = new int[5];
            if (array.length <= 10) {
                throw new MyExceptions("Array index out of bounds");
            }
            int number = array[10];
        } catch (MyExceptions e) {
            System.out.println("Caught MyExceptions: " + e);
        }

        // Пример 3: ArithmeticException
        try {
            if (true) { // Условие всегда истинно для демонстрации
                throw new MyExceptions("Arithmetic exception on division by zero");
            }
            int result = 10 / 0;
        } catch (MyExceptions e) {
            System.out.println("Caught MyExceptions: " + e);
        }

        // Пример 4: ClassCastException
        try {
            Object x = new Integer(0);
            if (x instanceof String) {
                System.out.println((String)x);
            } else {
                throw new MyExceptions("Class cast exception");
            }
        } catch (MyExceptions e) {
            System.out.println("Caught MyExceptions: " + e);
        }

        // Пример 5: IllegalArgumentException
        try {
            Thread thread = new Thread();
            if (thread.getPriority() < 1 || thread.getPriority() > 10) {
                throw new MyExceptions("Illegal argument exception on thread priority");
            }
            thread.setPriority(11); // Этот код не будет выполнен, так как исключение уже выброшено
        } catch (IllegalArgumentException e) {
            System.out.println("Caught MyExceptions: " + e);
        }

        // Пример 6: NoSuchElementException
        try{
            List<String> list = new ArrayList<>();
            Iterator<String> iterator = list.iterator();
            if (!iterator.hasNext()) {
                throw new MyExceptions("No such element exception");
            }
            iterator.next();
        }catch (MyExceptions e){
            System.out.println("Caught MyExceptions: " + e);
        }
    }
}
