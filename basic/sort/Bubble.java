package basic.sort;

public class Bubble implements Sort {
    @Override
    public void sort(int[] a) {
        // i用来索引当前排序到第几个数字.
        for (int i = 0; i < a.length - 1; i++) {
            // j用来索引正在排序的数字所在的位置
            for (int j = 0; j < a.length - 1 - i; j++) {
                // 如果正排序的数字大于在它后面的数字,就交换两者顺序
                if (a[j] > a[j + 1]) {
                    exch(a, j, j + 1);
                }
            }
        }
    }
}