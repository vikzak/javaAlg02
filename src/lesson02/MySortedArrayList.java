package lesson02;

public class MySortedArrayList<T extends Comparable<T>> extends lesson02.MyArrayList<T> {

    @Override
    public void add(T item) {
        int i = 0;
        while (i < size() && item.compareTo(get(i)) >= 0) {
            i++;
        }

        super.insert(i, item);
    }

    @Override
    public void insert(int index, T item) {
        add(item);
    }

    public int binaryFind(T item) {
        int low = 0;
        int high = size() - 1;
        int mid;

        while (low <= high) {
            mid = low + (high - low) / 2;
            if (item.compareTo(get(mid)) < 0) {
                high = mid - 1;
            } else if (item.compareTo(get(mid)) > 0){
                low = mid + 1;
            } else {
                return mid;
            }
        }
        return -1;
    }
}
