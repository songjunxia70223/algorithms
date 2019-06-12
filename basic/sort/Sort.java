package basic.sort;

public interface Sort {
    void sort(int[] a);

    default void exch(int[] a, int i, int j) {
        int temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }
}