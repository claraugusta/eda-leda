package ordenacao;

import java.util.Arrays;
import java.util.Scanner;

public class QuickSort {

    public void sort(int[] v, int left, int right){
        if(left >= right)
            return;
        int index_pivot = partitionLomuto(v, left, right);
        sort(v, left, index_pivot-1);
        sort(v, index_pivot+1, right);
    }

    public int partitionLomuto(int[]v, int ini, int fim){
        int range = fim - ini + 1;
        int index = (int)(Math.random() * range) + ini;
        swap(v, index, ini);
        int pivot = v[ini];
        int i = ini;

        for (int j = ini+1; j < fim+1; j++) {
            if(v[j] <= pivot){
                i++;
                swap(v, i, j);
            }
        }
        swap(v, ini, i);
        return i;
    }

    public int partitionHoare(int[]v, int ini, int fim){
        int index_pivot = pickPivotMedianadeTres(v, ini, fim);
        swap(v, ini, index_pivot);
        int pivot = v[ini];
        int i = ini + 1;
        int j = fim;

        while (i <= j){
            while (i <= j && v[i] <= pivot)
                i++;
            while (i <= j && v[j] > pivot)
                j--;
            if(i < j)
                swap(v, i, j);
        }
        swap(v, ini, j);
        return j;
    }

    private void swap(int[] v, int i, int j){
        int aux = v[i];
        v[i] = v[j];
        v[j] = aux;
    }

    private int pickPivotMedianadeTres(int v[], int ini, int fim){
        int[] mediana = new int[]{v[ini], v[(ini+fim)/2], v[fim]};
        Arrays.sort(mediana);
        if(mediana[1] == v[ini])   return ini;
        if(mediana[1] == v[(ini+fim)/2])   return (ini+fim)/2;
        else
            return fim;
    }
}
