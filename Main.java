import basic.sort.Sort;
import basic.sort.Selection;
import basic.sort.Shell;
import basic.sort.Insertion;
import basic.sort.Merge;
import basic.sort.Quick;
import basic.sort.Bubble;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        Sort sort = new Quick();
        int[] a = new int[] { 2, 1, 5, 2, 3, 6, 7, 4, 2, 6, 8, 1 };
        sort.sort(a);
        System.out.println(Arrays.toString(a));
    }
}