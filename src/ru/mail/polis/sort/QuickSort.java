package ru.mail.polis.sort;

/**
 * Created by user on 21.11.2016.
 */
public class QuickSort {
    public static int[] sort(int a[]) {
        Helper.doSort(0, a.length-1, a);
        return a;
    }
}
