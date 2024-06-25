package by.st.multithreading;

public class MultithreadingMain {
    public static void main(String[] args) {
        int[] data = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16};
        int numThreads = 4;

        Thread[] threads = new Thread[numThreads];
        for(int i = 0; i < numThreads; i++) {
            final int start = i * data.length / numThreads;
            final int end = (i + 1) * data.length / numThreads;
            threads[i] = new Thread(() -> processSubarray(data, start, end));
            threads[i].start();
        }

        for(Thread thread : threads) {
            try {
                thread.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println("All threads finished.");
    }

    private static void processSubarray(int[] data, int start, int end) {
        for (int i = start; i < end; i++) {
            data[i] *= 20;
            System.out.println("data[" + i + "] = " + data[i]);
        }
    }
}
