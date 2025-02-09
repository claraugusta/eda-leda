package ordenacao;

import java.util.Arrays;
import java.util.Scanner;

public class CountingSort {

    //k é o maior valor no array v
    public int[] sort(int[]v, int k){
       int[] s = new int[v.length];
       int[] c = new int[k];

        for (int i = 0; i < v.length; i++)
            c[v[i]-1]++;

        for (int j = 1; j < c.length; j++)
            c[j] = c[j] + c[j-1];

        for (int t = v.length-1; t >= 0; t--) {
            s[c[v[t] - 1] - 1] = v[t];
            c[v[t]-1]--;
        }
       return s;
    }

    public int[] sortNegativos(int[]v, int k){
        int min = getMin(v);
        int[] s = new int[v.length];
        int[] c = new int[k+1-min];

        for (int i = 0; i < v.length; i++)
            c[v[i]-min]++;

        for (int j = 1; j < c.length; j++)
            c[j] = c[j] + c[j-1];

        for (int t = v.length-1; t >= 0; t--) {
            s[c[v[t] - min] - 1] = v[t];
            c[v[t]-min]--;
        }
        return s;
    }

    public int getMin(int[] v){
        int min = v[0];
        for (int i = 1; i < v.length; i++) {
            if(v[i] < min)
                min = v[i];
        }
        return min;
    }
}
