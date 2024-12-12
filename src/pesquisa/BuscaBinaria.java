package pesquisa;

public class BuscaBinaria {
    public static int buscaBinaria(int[] in, int key){

        int ini = 0;
        int fim = in.length-1;
        int mid;

        while (ini <= fim){
            mid = ini + (fim - ini) / 2;
            if(in[mid] == key)  return mid;

            if (key > in[mid])
                ini = mid + 1;
            else
                fim = mid - 1;
        }
        return -1;
    }
}
