package basic.sort;

public class Shell implements Sort {
    @Override
    public void sort(int[] a) {
        int N = a.length;
        int h = 1;
        // 设置一个数字,表示每次挪动h个位置,希尔排序的性能取决于该数字的算法.
        // 简单起见我只是将该数字设置小于length的最大2^n
        while (h < N / 2)
            h = 2 * h;
        while (h >= 1) {
            // 下面类似插入排序了,只是每次如果需要插入,则直接插入到前面h个位置的地方
            for (int i = h; i < N; i++) {
                for (int j = i; j >= h; j -= h) {
                    if (a[j] < a[j - h]) {
                        exch(a, j, j - h);
                    }
                }
            }
            // 将h/2,让它最终迭代为1-有序数组
            h = h / 2;
        }
    }
}