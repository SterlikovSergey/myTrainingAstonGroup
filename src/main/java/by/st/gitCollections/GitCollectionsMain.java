package by.st.gitCollections;

public class GitCollectionsMain {
    public static void main(String[] args) {

        MyArrayList<Integer> list = new MyArrayList<>();
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        list.add(5);
        list.add(6);
        list.add(7);

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
