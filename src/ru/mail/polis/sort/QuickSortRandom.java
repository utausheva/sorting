package ru.mail.polis.sort;

import java.util.Random;

/**
 * Created by user on 27.11.2016.
 */
public class QuickSortRandom {
    public static int[] sort(int[] a) {
        Random random = new Random();
        sorted(a, 0, a.length-1, random);
        return a;
    }
    public static void sorted(int[] a, int start, int end, Random random ){
        if (start >= end) return;

        int tmp = random.nextInt(end - start) + start;
        int pivot=a[tmp];
        int b = start;
        int j = start;

        Helper.swap(a, start, tmp);

        for(int i = start + 1; i <=end ; i++){
            if (a[i] < pivot) {
                Helper.swap(a, ++j, i);
            }
            else if (a[i] == pivot){
                Helper.swap(a, i, ++j);
                Helper.swap(a, ++b, j);
            }
        }

        int del=j;
        for(int i = start; i <= b; i++) {
            Helper.swap(a, i, j);
            j--;
        }

        sorted(a, start, j,random);
        sorted(a,del+1, end, random);
    }
}
