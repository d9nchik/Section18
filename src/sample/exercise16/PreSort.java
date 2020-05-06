package sample.exercise16;

import java.util.Arrays;

public class PreSort {
    public static void main(String[] args) {
        int[] a = {8, 7, 4, 1, 9, 6, 2, 5, 3, 0};
        System.out.println(Arrays.toString(a));
        pos(a, 2, 7);
        System.out.println(Arrays.toString(a));
    }

    public static int pos(int[] a, int l, int r) {
        if (l == r)
            return l;
        int pos = pos(a, l, r - 1);
        if (a[r] > a[pos])
            return pos;
        int temp = a[pos];
        a[pos] = a[r];
        a[r] = a[pos + 1];
        a[pos + 1] = temp;
        return pos + 1;
    }
}
