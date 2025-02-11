package tstEda;

import java.util.Arrays;
import java.util.Scanner;

public class OrdenacaoDePlacas {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] placas = sc.nextLine().split(",");
        radixSort(placas);
        String out = Arrays.toString(placas);
        System.out.println(out.substring(1, out.length()-1));
    }

    public static void radixSort(String[] v){
        int numDigits = v[0].length();
        int place = v[0].length();
        while (numDigits > 4){
            countingSort(v, place);
            place--;
            numDigits--;
        }
    }

    public static void countingSort(String[] v, int place){
        int[] c = new int[10];
        String[] s = new String[v.length];

        for (int i = 0; i < v.length; i++) {
            c[Integer.parseInt(v[i].substring(place-1, place))]++;
        }

        for (int j = 1; j < c.length; j++) {
            c[j] += c[j-1];
        }

        for (int k = v.length-1; k >= 0; k--) {
            s[c[Integer.parseInt(v[k].substring(place-1, place))]-1] = v[k];
            c[Integer.parseInt(v[k].substring(place-1, place))]--;
        }

        for (int q = 0; q < v.length; q++) {
            v[q] = s[q];
        }
    }


}
