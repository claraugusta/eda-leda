package ordenacao;

import java.util.Arrays;
import java.util.Scanner;

public class InsereUltimo {

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        String[] in = sc.nextLine().split(" ");
        int[] intArr = Arrays.stream(in).mapToInt(Integer::parseInt).toArray();
        insere(intArr);
        System.out.println(Arrays.toString(intArr));
    }

    private static void insere(int[] in){
        int fim = in.length-1;
        while (fim > 0 && in[fim] < in[fim - 1]){
            swap(in, fim);
            fim--;
        }
    }

    private static void swap(int[] in, int i){
        int aux = in[i];
        in[i] = in[i-1];
        in[i-1] = aux;
    }
}
