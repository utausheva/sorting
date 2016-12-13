package ru.mail.polis.sort;

import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

public class Helper {

    private static final Random r = ThreadLocalRandom.current();

    public static void swap(int[] a, int i, int j) {
        int x = a[i];
        a[i] = a[j];
        a[j] = x;
    }

    public static int[] gen(int n) {
        int[] a = new int[n];
        for (int i = 0; i < a.length; i++) {
            a[i] = i;
        }
        for (int i = a.length - 1; i > 0; i--) {
            int j = r.nextInt(i + 1);
            Helper.swap(a, i, j);
        }
        return a;
    }
    public static int binSearch(int[] a, int key, int left, int right) {
        if (left > right)
            return -1;
        int mid = (left + right) / 2;
        if (a[mid] > key) {
            return binSearch(a, key, left, mid - 1);
        } else if (a[mid] < key) {
            return binSearch(a, key, mid + 1, right);
        } else
            return mid;
    }
    public static int partition(int[] a, int left, int right, int pivot) {
        if (left > right)
            return right;
        int i = left, j = right, x = a[pivot];
        Helper.swap(a, j--, pivot);
        while (i <= j) {
            while (i <= j && a[i] < x) i++;
            while (i <= j && a[j] > x) j--;
            if    (i >= j)
                break;
            Helper.swap(a, i++, j--);
        }
        Helper.swap(a, i, right);
        return i;
    }
    public static void merge(int[] a1, int[] t1, int left, int mid, int right){
        for (int i = left; i <= right; i++) {
            t1[i] = a1[i];
        }
        int i = left, j = mid + 1;
        for (int k = left; k <= right; k++) {
            if (i > mid) {a1[k] = t1[j]; j++;}
            else if (j > right) {a1[k] = t1[i];i++;}
            else if (t1[j] < t1[i]) {a1[k] = t1[j];j++;}
            else {a1[k] = t1[i];i++;}
        }
    }

    public static int doSort(int start, int end, int[] a) {
        //int v = a[(start + end) / 2];
        int v = a[start];
        int i = start;
        int j = end;
        while (i <= j) {
            while (a[i] < v)
                i++;
            while (a[j] > v)
                j--;
            if (i <= j)
                Helper.swap(a,i++,j--);
        }
        return j;
    }
    public static int getCountsOfDigits(long number) {
        return(number == 0) ? 1 : (int) Math.ceil(Math.log10(Math.abs(number) + 0.5));
    }

    public static int digit(int x,int i){
        for (int h = 0; h < i - 1; h++){
            x = x/10;
        }
        return x%10;
    }
}
