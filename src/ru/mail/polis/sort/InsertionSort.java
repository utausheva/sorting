package ru.mail.polis.sort;

/**
 * Created by user on 21.11.2016.
 */
public class InsertionSort {
    public static int[] sort(int a[]) {
        int n = a.length;
        for (int i = 1; i < n; i++) {
            for (int j = i; j > 0 && a[j] < a[j-1]; j--) {
                Helper.swap(a, j, j - 1);
            }
        }
        return a;
    }
}
