package basic.sort;

public class Insertion implements Sort {
    @Override
    public void sort(int[] a) {
        // i表示当前有几个数字是有序的
        for (int i = 1; i < a.length; i++) {
            // j表示未排序数字的所在位置
            for (int j = i; j > 0; j--) {
                // 如果j的前一个比j小,就将它插到前面.
                if (a[j - 1] > a[j]) {
                    exch(a, j, j - 1);
                }
            }
        }
    }
}