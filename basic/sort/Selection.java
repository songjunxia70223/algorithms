package basic.sort;

public class Selection implements Sort {
    @Override
    public void sort(int[] a) {
        // 用i索引当前排序到第几个位置
        for (int i = 0; i < a.length - 1; i++) {
            // 每一轮从未排序的元素中选择一个最小的数字来作为首位置的数字
            // 注意该首位置表明的是当前排序到第几个数字了
            // 比如排序到第二个数字,该首位置就是1,因为数组是从0开始索引的.
            int min = i;
            for (int j = i + 1; j < a.length; j++) {
                // 利用j来判断i后面是否存在比当前首位置数字还小的数字.
                if (a[j] < a[min]) {
                    // 如果a[j]<a[min]的话,就将j设置为最小位置的索引
                    min = j;
                }
            }
            // 如果min发生了变化,表明实际i并不是最小的数字
            // 就将i和实际最小数字所在位置进行交换
            if (min != i) {
                exch(a, min, i);
            }
        }
    }
}