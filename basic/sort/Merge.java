package basic.sort;

public class Merge implements Sort {
    // 我们声明一个临时变量,用来存放需要排序的数组,将结果放在原数组中
    // 可以避免我们利用return来返回result结果
    private int[] aux;

    @Override
    public void sort(int[] a) {
        // 实例化临时变量为排序数组的长度
        aux = new int[a.length];
        // 利用另一个方法进行数组的递归拆分操作.
        // 所以要先将排序数组完整的传给该方法.
        sort(a, 0, a.length - 1);
    }

    // 用来递归拆分数组的排序方法.
    // lo表示数组的最低边界,hi表示数组的最高边界.
    private void sort(int[] a, int lo, int hi) {
        // 最低边界大于最高边界,就返回.
        if (hi <= lo)
            return;
        // 算出当前数组的中间位置
        int mid = lo + (hi - lo) / 2;
        // 利用递归,将数组不断地拆分为两个
        sort(a, lo, mid);
        sort(a, mid + 1, hi);
        // 第一次运行merge方法的时候,实际上lo是0,mid也是0,hi为1.
        // 也就是上面说明原理的时候,只有两个数组的数组.
        // 然后递归地将数组不断地归并,最终为一个有序数组.
        merge(a, lo, mid, hi);
    }

    private void merge(int[] a, int lo, int mid, int hi) {
        int i = lo, j = mid + 1;
        for (int k = lo; k <= hi; k++) {
            // 将需要归并的数组中的数字复制到临时变量aux中
            aux[k] = a[k];
        }
        // 利用上面的归并思路,将aux临时变量中的值一一归并到原数组中.
        for (int k = lo; k <= hi; k++) {
            if (i > mid)
                a[k] = aux[j++];
            else if (j > hi)
                a[k] = aux[i++];
            else if (aux[j] < aux[i])
                a[k] = aux[j++];
            else {
                a[k] = aux[i++];
            }
        }
    }

    public int[] merge(int[] a, int[] b) {
        // 新建一个数组,用来存放归并后的结果
        int[] result = new int[a.length + b.length];
        // i表示当前归并到第一个数组的第i个位置
        // j表示归并到第二个数组的第j个位置
        // k表示归并到结果数组的第k个位置
        int i = 0, j = 0, k = 0;
        while (i < a.length && j < b.length) {
            // 判断左边数组的数组和右边数字的大小,将小的放在结果数组中
            // 如果两者相等就都放进去.
            if (a[i] < b[j]) {
                result[k++] = a[i++];
            } else if (a[i] > b[j]) {
                result[k++] = b[j++];
            } else {
                result[k++] = a[i++];
                result[k++] = b[j++];
            }
        }
        // 这两个循环是可能存在两个数组长度不相等的情况.
        while (i < a.length) {
            result[k++] = a[i++];
        }
        while (j < b.length) {
            result[k++] = b[j++];
        }
        return result;
    }
}