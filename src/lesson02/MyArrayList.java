package lesson02;

import java.util.Arrays;

public class MyArrayList<T extends Comparable<T>> {
    private T[] list;
    private int size;
    private int capacity;
    private final int DEFAULT_CAPACITY = 10;

    public MyArrayList(int capacity) {
        if (capacity <= 0) {
            throw new IllegalArgumentException("размер < 0: " + capacity);
        }

        this.capacity = capacity;
        list = (T[]) new Comparable[capacity];
    }

    public MyArrayList() {
        list = (T[]) new Comparable[DEFAULT_CAPACITY];
        this.capacity = DEFAULT_CAPACITY;
    }

    // добавление эл-та в конец
    public void add(T item) {
        checkSizeArray();

        list[size] = item;
        size++;
    }

    // вставка элемента в массив
    public void insert(int index, T item) {
        checkSizeArray();
        checkIndex(index);

        for (int i = size; i > index; i--) {
            list[i] = list[i - 1];
        }

        list[index] = item;
        size++;
    }

    public int indexOf(T item) {
        return index(item);
    }

    // удаление элемента по индексу
    public T delete(int index) {
        checkIndex(index);

        T temp = list[index];
        for (int i = index; i < size - 1; i++) {
            list[i] = list[i + 1];
        }
        list[size - 1] = null;
        size--;
        return temp;
    }

    // удаление элемента по объекту
    public boolean delete(T item) {
        int pos = index(item);
        if (pos < 0) return false;
        delete(pos);
        return true;
    }

    // назначить значение
    public void set(int index, T item) {
        checkIndex(index);

        list[index] = item;
    }

    // получение по индексу
    public T get(int index) {
        checkIndex(index);

        return list[index];
    }

    private int index(T item) {
        if (item == null) {
            return -1;
        }
        for (int i = 0; i < size; i++) {
            if (list[i].equals(item)) {
                return i;
            }
        }
        return -1;
    }

    public int size() {
        return size;
    }

    public int capacity() {
        return capacity;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    private void checkSizeArray() {
        if (size == capacity) {
            extendArray();
        }
    }

    // проверка по индексу
    private void checkIndex(int index) {
        if (index < 0 || index > size) {
            throw new IndexOutOfBoundsException("Индекс меньше 0 или больше размера массива. index : " + index);
        }
    }

    private void extendArray() {
        capacity = (int) (capacity * 1.5 + 1);
        T[] extendArray = (T[]) new Comparable[capacity];

        if (size >= 0) System.arraycopy(list, 0, extendArray, 0, size);

        list = extendArray;
    }

    @Override
    public String toString() {
        return Arrays.toString(Arrays.copyOf(list, size));
    }

    private boolean less(T item1, T item2) {
        return  item1.compareTo(item2) < 0;
    }

    private void swap(int index1, int index2) {
        T temp = list[index1];
        list[index1] = list[index2];
        list[index2] = temp;
    }

    // Методы сортировок:
    // сортировка выбором
    public void selectionSort() {
        for (int i = 0; i < size - 1; i++) {
            int iMin = i;
            for (int j = i; j < size; j++) {
                if (less(list[j], list[iMin])) {
                    iMin = j;
                }
            }
            if (iMin != i) {
                swap(i, iMin);
            }
        }
    }

    // сортировка вставкой
    public void insertionSort() {
        T key;
        for (int i = 1; i < size; i++) {
            int j = i;
            key = list[i];
            while(j > 0 && less(key, list[j - 1])) {
                list[j] = list[j - 1];
                j--;
            }

            list[j] = key;
        }
    }

    // сортировка пузырьком
    public void bubbleSort() {
        for (int i = size - 1; i > 0; i--) {
            for (int j = 0; j < i; j++) {
                if (less(list[j + 1], list[j])) {
                    swap(j + 1, j);
                }
            }
        }
    }
}
