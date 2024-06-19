package by.st.Exeptions;

import java.util.*;

public class ExceptionsMain {
    public static void main(String[] args) {
        // Пример 1: NullPointerException
        try {
            String str = null;
            str.length();
        } catch (NullPointerException e) {
            System.out.println("Caught 1 - NullPointerException: " + e.getMessage());
        }

        // Пример 2: ArrayIndexOutOfBoundsException
        try {
            int[] array = new int[5];
            int number = array[10];
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Caught 2 - ArrayIndexOutOfBoundsException: " + e);
        }

        // Пример 3: ArithmeticException
        try {
            int result = 10 / 0;
        } catch (ArithmeticException e) {
            System.out.println("Caught 3 - ArithmeticException: " + e);
        }

        // Пример 4: ClassCastException
        /*try {
            Object x = new Integer(0);

                System.out.println((String)x);

            } catch (Exception e) {
                System.out.println("Caught - Exception: " + e);
            } catch (ArrayIndexOutOfBoundsException e) {
                System.out.println("Caught - ArrayIndexOutOfBoundsException: " + e);
            } catch (ArithmeticException e) {
                System.out.println("Caught - ArithmeticException: " + e);
            } catch (ClassCastException e) {
                System.out.println("Caught - ClassCastException: " + e);
            } catch (IllegalArgumentException e) {
                System.out.println("Caught - IllegalArgumentException: " + e);
            } catch (NoSuchElementException e) {
                System.out.println("Caught - NoSuchElementException: " + e);
            } catch (NullPointerException e) {
                System.out.println("Caught - NullPointerException: " + e);
            }*/

        // Пример 5: IllegalArgumentException
        try {
            Thread thread = new Thread();

            thread.setPriority(11); // Этот код не будет выполнен, так как исключение уже выброшено
        } catch (IllegalArgumentException e) {
            System.out.println("Caught 5 - IllegalArgumentException: " + e);
        }

        // Пример 6: NoSuchElementException
        try{
            List<String> list = new ArrayList<>();
            Iterator<String> iterator = list.iterator();
            iterator.next();
        }catch (NoSuchElementException e){
            System.out.println("Caught 6 - NoSuchElementException: " + e);
        }
    }
}
