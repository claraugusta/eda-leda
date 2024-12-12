package pesquisa;

public class BuscaLinear {

    public static int buscaLinear(int[] in, int key){
        for (int i = 0; i < in.length; i++)
            if(in[i] == key)
                return i;
        return -1;
    }
}
