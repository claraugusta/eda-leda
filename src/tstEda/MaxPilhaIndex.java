package tstEda;

import java.util.Arrays;
import java.util.Scanner;
import java.util.Stack;

public class MaxPilhaIndex {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] in = sc.nextLine().split(" ");
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < in.length; i++)
            stack.push(Integer.parseInt(in[i]));
        int index = sc.nextInt();
        System.out.println(maxPilhaIndex(stack, index));
    }

    public static int maxPilhaIndex(Stack<Integer> stack, int index){
        Stack<Integer> aux = new Stack<>();
        int max = stack.peek();
        aux.push(stack.pop());
        for (int i = 0; i < index; i++) {
            if(stack.peek() > max)
                max = stack.peek();
            aux.push(stack.pop());
        }
        while (!aux.isEmpty())
            stack.push(aux.pop());
        return max;
    }
}
