package by.st.gitCollections;

import java.util.Arrays;

public class MyArrayList<T extends Comparable<T>> {
    private static final int DEFAULT_CAPACITY = 10;
    private Object[] elements;
    private int size = 0;

    public MyArrayList() {
        elements = new Object[DEFAULT_CAPACITY];
    }

    public void add(T element) {
        if (size == elements.length) {
            increaseCapacity();
        }
        elements[size++] = element;
    }

    @SuppressWarnings("unchecked")
    public T get(int index) {
        if (index >= size || index < 0) {
            throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + size);
        }
        return (T) elements[index];
    }

    public T remove(int index) {
        if (index >= size || index < 0) {
            throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + size);
        }
        @SuppressWarnings("unchecked")
        T removedElement = (T) elements[index];
        int numElementsToMove = size - index - 1;
        if (numElementsToMove > 0) {
            System.arraycopy(elements, index + 1, elements, index, numElementsToMove);
        }
        elements[--size] = null; // Ясно, что сборщик мусора делает свою работу
        return removedElement;
    }

    private void increaseCapacity() {
        int newCapacity = elements.length * 2;
        elements = Arrays.copyOf(elements, newCapacity);
    }

    public int size() {
        return size;
    }
    public void bubbleSort() {
        boolean swapped;
        for (int i = 0; i < size - 1; i++) {
            swapped = false;
            for (int j = 0; j < size - i - 1; j++) {
                if (((T) elements[j]).compareTo((T) elements[j + 1]) > 0) {
                    // Поменять местами элементы[j] и элементы[j + 1]
                    T temp = (T) elements[j];
                    elements[j] = elements[j + 1];
                    elements[j + 1] = temp;
                    swapped = true;
                }
            }
            // Если ни один из двух элементов не поменялся местами внутренним циклом, то break
            if (!swapped) break;
        }
    }
    public int binarySearch(T key) {
        int low = 0;
        int high = size - 1;
        while (low <= high) {
            int mid = (low + high) / 2;
            T midVal = (T) elements[mid];
            int cmp = ((Comparable<T>) midVal).compareTo(key);
            if (cmp < 0) {
                low = mid + 1;
            } else if (cmp > 0) {
                high = mid - 1;
            } else {
                return mid;
            }
        }
        return -1;
    }

    public void selectionSort() {
        for (int i = 0; i < size - 1; i++) {
            int minIndex = i;
            for (int j = i + 1; j < size; j++) {
                if (((Comparable<T>) elements[j]).compareTo((T) elements[minIndex]) < 0) {
                    minIndex = j;
                }
            }
            // Поменять местами элементы[minIndex] и elements[i]
            T temp = (T) elements[minIndex];
            elements[minIndex] = elements[i];
            elements[i] = temp;
        }
    }

    public void insertionSort() {
        for (int i = 1; i < size; i++) {
            T key = (T) elements[i];
            int j = i - 1;
            while (j >= 0 && ((Comparable<T>) elements[j]).compareTo(key) > 0) {
                elements[j + 1] = elements[j];
                j = j - 1;
            }
            elements[j + 1] = key;
        }
    }

}