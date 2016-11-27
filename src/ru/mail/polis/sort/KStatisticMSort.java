package ru.mail.polis.sort;

import java.util.Random;

/**
 * Created by user on 21.11.2016.
 */
public class KStatisticMSort {
    public static int[] sort(int[] a) {
        int k =0;
        Random random = new Random();
        int left = 0, right = a.length - 1;
        while (right > left) {
            int pivotIdx = left + random.nextInt(right - left + 1);
            int idx = Helper.partition(a, left, right, pivotIdx);
            if (k < idx) right = idx - 1;
            else if (k > idx) left = idx + 1;
            else return a;
        }
        return a;
    }


}
