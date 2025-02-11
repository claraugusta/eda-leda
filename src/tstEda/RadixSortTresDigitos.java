package tstEda;

import java.util.Arrays;
import java.util.Scanner;

public class RadixSortTresDigitos {

    public static int getMax(int[] v){
        int max = v[0];
        for (int i = 1; i < v.length; i++) {
            if(v[i] > max)
                max = v[i];
        }
        return max;
    }

    public static void countingSort(int[] v, int p){
        int[] c = new int[999];
        int[] s = new int[v.length];

        for (int i = 0; i < v.length; i++) {
            c[(v[i] / p % 1000)-1]++;
        }

        for (int j = 1; j < c.length; j++) {
            c[j] += c[j-1];
        }

        for (int k =  v.length-1; k >= 0; k--) {
            s[c[(v[k] / p % 1000) - 1]-1] = v[k];
            c[(v[k] / p % 1000)-1]--;
        }

        for (int q = 0; q < v.length; q++) {
            v[q] = s[q];
        }
    }

    public static void radixSort(int[] v, int d){
        //int max = getMax(v);
        //int numDigits = String.valueOf(max).length();
        int numDigits = d;
        int p = 1;
        while (numDigits > 0){
            countingSort(v, p);
            System.out.println(Arrays.toString(v));
            p *= 1000;
            numDigits -= 3;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] x = sc.nextLine().split(" ");
        int d = sc.nextInt();
        int[] a = new int[x.length];
        for (int i = 0; i < x.length; i++) {
            a[i] = Integer.parseInt(x[i]);
        }

        radixSort(a,d);

    }
}
