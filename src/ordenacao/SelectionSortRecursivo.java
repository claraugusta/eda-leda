package ordenacao;

import java.util.Arrays;
import java.util.Scanner;

// Isso ta parecendo uma gambiarra, mas fiz o método encontra menor recursivo só pra treinar recursividade.
// Esse algoritmo pode ser melhorado.

public class SelectionSortRecursivo {

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        String[] in = sc.nextLine().split(" ");
        int[] intArr = Arrays.stream(in).mapToInt(Integer::parseInt).toArray();
        selectionSort(intArr, 0);
    }

    public static int[] selectionSort(int[] in, int n){
        if(n >= in.length-1)  return in;
        swap(in, n, encontraMenor(in, n, n));
        System.out.println(Arrays.toString(in));
        return selectionSort(in, ++n);
    }

    private static int encontraMenor(int[] in, int n, int x){
        if(n >= in.length-1)   return x;
        if(in[n+1] < in[x])
            x = n+1;
        return encontraMenor(in, ++n, x);
    }
    private static void swap(int in[], int n, int menor){
        int aux = in[menor];
        in[menor] = in[n];
        in[n] = aux;
    }
}
