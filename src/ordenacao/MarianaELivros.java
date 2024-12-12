package ordenacao;

import java.util.Arrays;
import java.util.Scanner;

public class MarianaELivros {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        String[] in = sc.nextLine().split(",");
        insertionSort(in);
    }

    private static void insertionSort(String[] in){
        for (int i = 0; i <in.length; i++) {
            int j = i;
            while (j >0 && in[j].compareTo(in[j-1]) < 0){
                swap(in, j);
                j--;
            }
            String out = Arrays.toString(in);
            out = out.substring(1, out.length()-1);
            System.out.println(out);


        }
    }

    private static void swap(String[] in, int i){
        String aux = in[i];
        in[i] = in[i-1];
        in[i-1] = aux;
    }
}
