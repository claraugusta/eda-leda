package ordenacao;

public class InsertionSort {
    public static int[] insertionSort(int[] in){

        for (int i = in.length - 1; i > 0; i--) {
            int j = i;
            while (j > 0 && in[j] < in[j-1]){
                swap(in,j);
                j--;
            }
        }
        return in;
    }

    public static void swap(int[] in, int i){
        int aux = in[i];
        in[i] = in[i-1];
        in[i-1] = aux;
    }
}
