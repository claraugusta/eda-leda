package ordenacao;

import java.util.Arrays;
import java.util.Scanner;

public class MergeSort {

    public void sort(int[]v, int left, int right){
        if(left >= right)
            return;
        int mid = (left + right) / 2;
        sort(v, left, mid);
        sort(v, mid + 1, right);
        merge(v, left, mid, right);
    }

    // o merge une duas partes cada uma já ordenada.
    private void merge(int[]v, int left, int mid, int right){
        int i = left;
        int j = mid + 1;
        int k = left;
        int[] helper = new int[v.length];

        for (int l = 0; l < v.length; l++) {
            helper[l] = v[l];
        }

        while (i <= mid && j <= right){
            if(helper[i] <= helper[j]){
                v[k] = helper[i];
                i++;
            } else{
                v[k] = helper[j];
                j++;
            }
            k++;
        }

        while (i <= mid){
            v[k] = helper[i];
            i++;
            k++;
        }
    }
}
