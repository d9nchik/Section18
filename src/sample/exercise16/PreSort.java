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
        int pos = change(a, l, r, a[l]);

        int temp = a[l];
        a[l] = a[pos];
        a[pos] = temp;
        return pos;
    }

    private static int change(int[] a, int l, int r, int value) {//Part of quick sort O(n)
        if (r < l)
            return r;
        if (a[l] > value) {
            if (a[r] < value) {
                int temp = a[l];
                a[l] = a[r];
                a[r] = temp;
                return change(a, l + 1, r, value);
            } else
                return change(a, l, r - 1, value);
        } else
            return change(a, l + 1, r, value);
    }
}
