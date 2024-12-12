package ordenacao;

import java.util.Arrays;
import java.util.Scanner;

public class InserePrimeiro {

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        String[] in = sc.nextLine().split(" ");
        int[] intArr = Arrays.stream(in).mapToInt(Integer::parseInt).toArray();
        insere(intArr);
        System.out.println(Arrays.toString(intArr));
    }

    public static void insere(int[] in){
        int ini = 0;
        while (ini < in.length-1 && in[ini] > in[ini + 1]) {
            swap(in, ini);
            ini++;
        }
    }

    public static void swap(int[] in, int i){
        int aux = in[i];
        in[i] = in[i+1];
        in[i+1] = aux;
    }
}
