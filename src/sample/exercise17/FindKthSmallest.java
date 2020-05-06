package sample.exercise17;

import sample.exercise16.PreSort;

public class FindKthSmallest {
    public static void main(String[] args) {
        int[] a = {7, 10, 4, 3, 20, 15};
        System.out.println(findKthSmallestValue(a, 3));
    }

    public static int findKthSmallestValue(int[] array, int k) {
        return findKthSmallestValue(array, k, 0, array.length - 1);
    }

    private static int findKthSmallestValue(int[] array, int k, int start, int finish) {
        int pos = PreSort.pos(array, start, finish) + 1;
        if (pos > k)
            return findKthSmallestValue(array, k, start, pos - 2);
        else if (pos < k)
            return findKthSmallestValue(array, k, pos, finish);
        return array[k - 1];
    }
}
