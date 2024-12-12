import ordenacao.InsertionSort;
import ordenacao.InsertionSortRecursivo;
import pesquisa.BuscaBinaria;
import pesquisa.BuscaLinear;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) {

        int[] test1 = {1, 2, 3, 4, 5};
        int[] test2 = {5,4,3,2,1};
        System.out.println(InsertionSortRecursivo.insertionSort(test2,1));
        System.out.println(BuscaBinaria.buscaBinaria(test1,5));

        System.out.println(BuscaBinaria.buscaBinaria(test1,9));
    }
}