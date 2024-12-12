package ordenacao;

import java.util.Arrays;
import java.util.Scanner;

public class InsertionSortRecursivo {

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        String[] in = sc.nextLine().split(" ");
        int[] intArr = Arrays.stream(in).mapToInt(Integer::parseInt).toArray();
        insertionSort(intArr, 1);
    }
    public static int[] insertionSort(int[] in, int n) {
        if(n >= in.length)   return in;

        int current = n;

        while (current > 0 && in[current] < in[current - 1]) {
                swap(in, current);
                current--;
            }

        System.out.println(Arrays.toString(in));
        return insertionSort(in, n+1);
    }

    public static void swap(int[] in, int i){
        int aux = in[i];
        in[i] = in[i-1];
        in[i-1] = aux;
    }
}
