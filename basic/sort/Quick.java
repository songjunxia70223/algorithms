package basic.sort;

public class Quick implements Sort {
    @Override
    public void sort(int[] a) {
        int max = 0;
        for (int i = 1; i < a.length; i++) {
            if (a[max] < a[i])
                max = i;
        }
        exch(a, max, a.length - 1);
        sort(a, 0, a.length - 1);
    }

    private void sort(int[] a, int lo, int hi) {
        if (hi <= lo)
            return;
        int key = partition(a, lo, hi);
        sort(a, lo, key - 1);
        sort(a, key + 1, hi);
    }

    private int partition(int[] a, int lo, int hi) {
        int left = lo, right = hi + 1;
        int key = a[lo];
        while (true) {
            while (a[++left] < key)
                ;
            while (a[--right] > key)
                ;
            if (left >= right)
                break;
            exch(a, left, right);
        }
        exch(a, lo, right);
        return right;
    }
}