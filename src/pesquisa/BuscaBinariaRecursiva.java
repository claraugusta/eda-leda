package pesquisa;

import java.util.Arrays;
import java.util.Scanner;

public class BuscaBinariaRecursiva {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] arr = sc.nextLine().split(" ");
        int[] intArr = Arrays.stream(arr).mapToInt(Integer::parseInt).toArray();
        System.out.println(buscaBinaria(intArr, 9, 0, intArr.length-1));
    }

    public static int buscaBinaria(int[] in, int key, int ini, int fim){
        if(ini > fim)  return -1;
        int mid = ini + (fim - ini)/2;
        if(key == in[mid])  return mid;

        if(key < in[mid])
            fim = mid - 1;
        else
            ini = mid + 1;
        return buscaBinaria(in, key, ini, fim);
    }
}
