import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
//        Scanner sc = new Scanner(System.in);
//        String[] in = sc.nextLine().split(" ");
//        int[] arr = Arrays.stream(in).mapToInt(Integer::parseInt).toArray();
//        SelectionSort.selectionSort(arr);
//        System.out.println(Arrays.toString(arr));


        int[] test1 = {1, 2, 3, 4, 5};
        assert Arrays.equals(InsertionSort.insertionSort(test1), new int[]{1, 2, 3, 4, 5}) : "Erro no Teste 1";

        int[] test2 = {5, 4, 3, 2, 1};
        assert Arrays.equals(InsertionSort.insertionSort(test2), new int[]{1, 2, 3, 4, 5}) : "Erro no Teste 2";

        int[] test3 = {4, 2, 4, 2, 4};
        assert Arrays.equals(InsertionSort.insertionSort(test3), new int[]{2, 2, 4, 4, 4}) : "Erro no Teste 3";

        int[] test4 = {7};
        assert Arrays.equals(InsertionSort.insertionSort(test4), new int[]{7}) : "Erro no Teste 4";

        int[] test5 = {};
        assert Arrays.equals(InsertionSort.insertionSort(test5), new int[]{}) : "Erro no Teste 5";

        int[] test6 = {-3, -1, -4, -2, 0};
        assert Arrays.equals(InsertionSort.insertionSort(test6), new int[]{-4, -3, -2, -1, 0}) : "Erro no Teste 6";

        int[] test7 = {3, -2, 5, -1, 0};
        assert Arrays.equals(InsertionSort.insertionSort(test7), new int[]{-2, -1, 0, 3, 5}) : "Erro no Teste 7";

        System.out.println("Todos os testes passaram!");
    }
}