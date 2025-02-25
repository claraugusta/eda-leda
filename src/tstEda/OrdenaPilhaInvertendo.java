package tstEda;

import java.util.Scanner;
import java.util.Stack;

//errado
public class OrdenaPilhaInvertendo {

    private static Stack<Integer> stack;
    private static int size;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        size = sc.nextInt();
        sc.nextLine();
        String[] in = sc.nextLine().split(" ");
        stack = new Stack<>();
        for (int i = 0; i < size; i++)
            stack.push(Integer.parseInt(in[i]));
        ordenaPilha();
    }
    public static int maxPilhaIndex(int index) {
        Stack<Integer> aux = new Stack<>();
        int max = stack.peek();
        int maxIndex = 0;

        for (int i = 0; i <= index; i++) {
            int current = stack.pop();
            if (current > max) {
                max = current;
                maxIndex = i;
            }
            aux.push(current);
        }

        while (!aux.isEmpty())
            stack.push(aux.pop());

        return maxIndex;
    }
    public static Stack<Integer> invertePilha(int index){
        int size = stack.size();
        Stack<Integer> aux = new Stack<>();
        Stack<Integer> aux2 = new Stack<>();
        for (int i = size-1; i > index; i--){
            aux.push(stack.pop());
        }
        for (int j = 0; j <= index; j++) {
            aux2.push(stack.pop());
        }
        for (int k = 0; k <= index; k++) {
            aux.push(aux2.pop());
        }
        stack = aux;
        return aux;
    }
    public static void ordenaPilha() {
        for (int i = size - 1; i > 0; i--) {
            int maxIndex = maxPilhaIndex(i); // Encontra o índice do maior elemento
            invertePilha(maxIndex); // Inverte até o índice do maior elemento
            invertePilha(i); // Inverte até o índice atual
        }
        System.out.println(stack.toString());
    }

    }

