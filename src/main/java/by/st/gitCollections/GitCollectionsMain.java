package by.st.gitCollections;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;

public class GitCollectionsMain {
    public static void main(String[] args) {
        System.out.println("MyArrayList");

        MyArrayList<Integer> list = new MyArrayList<>();
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        list.add(5);
        list.add(6);
        list.add(7);

        Stack<Integer> stack = new Stack<>();
        stack.add(1);
        stack.add(2);
        stack.add(3);
        System.out.println("My stack: " + stack);
        stack.push(4);
        System.out.println("push " + stack);
        stack.add(5);
        System.out.println(stack);
        stack.pop();
        System.out.println("search" + stack.search(2));


        System.out.println(stack);
        System.out.println(stack.peek());
        if(!stack.empty()){
            System.out.println(stack + "not empty");
        } else {
            System.out.println("is empty");
        }




        List<Integer> integerList = new LinkedList<>();
        Queue<Integer> queue = new LinkedList<>();
        queue.add(1);
        queue.add(2);
        queue.add(3);
        System.out.println("queue " + queue);
        System.out.println(queue.size());

        System.out.println("Элемент с индексом 1:" + list.get(1));
        System.out.println("Удаленный элемент:" + list.remove(1));
        System.out.println("Элемент с индексом 1 после удаления: " + list.get(1));

        list.bubbleSort();
        System.out.println("После сортировки bubbleSort() :");
        for (int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i));
        }

        list.selectionSort();
        System.out.println("После сортировки selectionSort() :");
        for (int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i));
        }

        list.insertionSort();
        System.out.println("После сортировки insertionSort() :");
        for (int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i));
        }

        int index = list.binarySearch(4);
        System.out.println("Результат binarySearch(4): " + index);
    }
}
