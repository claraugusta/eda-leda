package ordenacao;

import java.util.Arrays;
import java.util.Scanner;

public class SelectionSortPasso {

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        String[] in = sc.nextLine().split(" ");
        int[] intArr = Arrays.stream(in).mapToInt(Integer::parseInt).toArray();
        selectionSort(intArr);

    }

    private static void selectionSort(int[] in){
        for (int i = 0; i < in.length; i++) {
            int menor = i;
            for (int j = i + 1; j < in.length; j++) {
                if (in[j] < in[menor])
                    menor = j;
            }

            swap(in, menor, i);
            if(menor != i)
                System.out.println(Arrays.toString(in));
        }
    }


    private static void swap(int[] in, int i, int j){
        int aux = in[i];
        in[i] = in[j];
        in[j] = aux;
    }
}
