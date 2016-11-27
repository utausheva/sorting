package ru.mail.polis.sort;

/**
 * Created by user on 27.11.2016.
 */
public class LSDSort {
    public static int[] sort(int a[]) {
        int m = Helper.getCountsOfDigits(a[0]);
        int k =10001;
        int[] c = new int[k];
        int[] b = new int[a.length];

        for (int i = 1; i <= m; i++){
            for (int j = 0; j < k; j++){
                c[j] = 0;
            }
            for (int j = 0; j < a.length; j++){
                c[Helper.digit(a[j], i)]++;
            }
            int count = 0;
            for (int j = 0; j < a.length; j++){
                long tmp = c[j];
                c[j] = count;
                count += tmp;
            }
            for (int j = 0; j < a.length; j++){
                int d = Helper.digit(a[j], i);
                b[c[d]] = a[j];
                c[d]++;
            }
            for (int j = 0; j < a.length; j++){
                a[j] = b[j];
            }
        }
        return a;
    }
}
