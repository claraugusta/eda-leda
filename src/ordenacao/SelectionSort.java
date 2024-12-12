package ordenacao;

public class SelectionSort {

    public static int [] selectionSort(int[] in){

        for (int j = 0; j < in.length; j++) {
            int indexMenor = j;
            for (int i = j + 1; i < in.length; i++) {
                if (in[i] < in[indexMenor])
                    indexMenor = i;
            }
            swap(in, indexMenor, j);
        }
        return in;
    }

    public static void swap(int[] in, int i, int j){
        int aux = in[i];
        in[i] = in[j];
        in[j] = aux;
    }
}
