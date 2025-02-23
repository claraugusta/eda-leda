package tstEda;

import java.util.Arrays;
import java.util.Scanner;
import java.util.Stack;

public class InvertePilhaIndex {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int size = sc.nextInt();
        sc.nextLine();
        String[] in = sc.nextLine().split(" ");
        Stack<Integer> stack = new Stack<>();
        for (int i = size - 1; i >= 0; i--) {
            stack.push(Integer.parseInt(in[i]));
        }
        int index = sc.nextInt();
        System.out.println("-");
        stack = invertePilha(index, stack);

        for (int j = 0; j < size; j++) {
            System.out.println(stack.pop());
        }
    }

    public static Stack<Integer> invertePilha(int index, Stack<Integer> stack){
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
        return aux;
    }
}
