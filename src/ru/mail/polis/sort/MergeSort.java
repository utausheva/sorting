package ru.mail.polis.sort;

/**
 * Created by user on 21.11.2016.
 */
public class MergeSort {
    public static int[] sort(int a[]) {
        int[]t1 = new int[a.length];
        for (int len = 1; len < a.length; len *= 2) {
            for (int left = 0; left < a.length - len; left += len + len) {
                int mid = left + len - 1;
                int right = Math.min(left + len + len - 1, a.length - 1);
                Helper.merge(a, t1, left, mid, right);
            }
        }
        return a;
    }
}
