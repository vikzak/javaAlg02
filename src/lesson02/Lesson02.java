package lesson02;

import org.apache.commons.lang3.time.StopWatch;

import java.util.Random;

public class Lesson02 {
    public static void main(String[] args) {
//        MyArrayList<Integer> mal = new MyArrayList<>(3);
//        System.out.println(mal);
//        System.out.println("1. capacity: " + mal.capacity() + ", size: " + mal.size());
//        mal.add(10);
//        mal.add(20);
//        mal.add(30);
//        System.out.println("2. capacity: " + mal.capacity() + ", size: " + mal.size());
//        mal.add(40);
//        mal.add(50);
//        System.out.println("3. capacity: " + mal.capacity() + ", size: " + mal.size());
//        mal.add(60);
//        System.out.println("4. capacity: " + mal.capacity() + ", size: " + mal.size());
//        mal.add(70);
//        System.out.println("5. capacity: " + mal.capacity() + ", size: " + mal.size());
//        mal.add(80);
//        System.out.println("6. capacity: " + mal.capacity() + ", size: " + mal.size());
//        mal.add(90);
//        System.out.println("7. capacity: " + mal.capacity() + ", size: " + mal.size());
//        System.out.println(mal);
//
//        Integer[] ints = new Integer[10];
//        System.out.println(Arrays.toString(ints));
//
//        System.out.println("----------------");
//        mal.insert(2, 33);
//        System.out.println(mal);
//        mal.insert(10, 99);
//        System.out.println(mal);
//        mal.insert(0, 11);
//        System.out.println(mal);
//        //mal.insert(-1, 2);
//        //mal.insert(15, 222);
//
//        //System.out.println(mal.delete(0));
//        mal.add(111);
//        System.out.println(mal);
//        System.out.println(mal.size());
//        System.out.println(mal.capacity());
//        System.out.println(mal.delete(11));
//
//        System.out.println(mal);
//        System.out.println(mal.indexOf(20));
//        System.out.println(mal.indexOf(111));
//        System.out.println(mal.indexOf(1112));
//
//        System.out.println(mal);
//        System.out.println(mal.delete((Integer) 50));
//        System.out.println(mal);
//
//        System.out.println("--------------------------------------");
//        MySortedArrayList<Integer> msal = new MySortedArrayList<>();
//        msal.add(16);
//        msal.add(13);
//        msal.add(4);
//        msal.add(6);
//        msal.add(5);
//        msal.add(8);
//        msal.add(1);
//        System.out.println(msal);
//        msal.insert(5, 2);
//        System.out.println(msal);
//        System.out.println(msal.binaryFind(6));


        //System.out.println(mal3);
        //mal3.selectionSort();
        //mal3.insertionSort();
        //mal3.bubbleSort();
        //System.out.println(mal3);
        long timeSelectionSort = 0;
        long timeInsertionSort = 0;
        long timeBubbleSort = 0;
        int N = 1;
        for (int i = 0; i < N; i++) {
            MyArrayList<Integer> arr1 = generateArray();
            MyArrayList<Integer> arr2 = generateArray();
            MyArrayList<Integer> arr3 = generateArray();
            timeSelectionSort += getTimeSelectionSort(arr1);
            timeInsertionSort += getTimeInsertionSort(arr2);
            timeBubbleSort += getTimeBubbleSort(arr3);
        }

        System.out.println("timeSelectionSort : " + timeSelectionSort / N);
        System.out.println("timeInsertionSort : " + timeInsertionSort / N);
        System.out.println("timeBubbleSort : " + timeBubbleSort / N);
    }

    private static long getTimeSelectionSort(MyArrayList<Integer> array) {
        StopWatch watch = new StopWatch();
        watch.start();

        array.selectionSort();

        watch.stop();
        return watch.getTime();
    }

    private static long getTimeInsertionSort(MyArrayList<Integer> array) {
        StopWatch watch = new StopWatch();
        watch.start();

        array.insertionSort();

        watch.stop();
        return watch.getTime();
    }

    private static long getTimeBubbleSort(MyArrayList<Integer> array) {
        StopWatch watch = new StopWatch();
        watch.start();
        array.bubbleSort();
        watch.stop();
        return watch.getTime();
    }

    private static MyArrayList<Integer> generateArray() {
        Random random = new Random();
        int n = 100000;
        MyArrayList<Integer> generatedArray = new MyArrayList<>(n);
        for (int i = 0; i < n; i++) {
            generatedArray.add(random.nextInt(1000));
        }
        return generatedArray;
    }

}
