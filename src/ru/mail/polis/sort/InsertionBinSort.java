package ru.mail.polis.sort;

/**
 * Created by user on 21.11.2016.
 */
public class InsertionBinSort {
    public static int[] sort(int a[]) {
        for (int i = 1; i< a.length; i++) {
            int j = i - 1;
            int k = Helper.binSearch(a, a[i], 0, j);
            for (int m = j; m > k; m--) {
                Helper.swap(a, m, m+1);
            }
        }
        return a;
    }
}
