package outrosAlgoritmos;

import java.util.Arrays;
import java.util.Scanner;

public class EncontraQuebraRecursivo {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] arr = sc.nextLine().split(" ");
        int[] intArr = Arrays.stream(arr).mapToInt(Integer::parseInt).toArray();
        System.out.println(encontraQuebra(intArr, 0));
    }

    public static int encontraQuebra(int[] in, int i){
        if(i >= in.length - 1)  return -1;
        if(in[i+1] < in[i]) return i+1;
        return encontraQuebra(in, ++i);
    }
}
