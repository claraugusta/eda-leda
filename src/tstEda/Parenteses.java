package tstEda;

import java.util.Arrays;
import java.util.Scanner;
import java.util.Stack;

public class Parenteses {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] parenteses = sc.next().split("");
        System.out.println(verificaParenteses(parenteses));
    }

    public static Character verificaParenteses(String[] parenteses){
        Stack<String> stack = new Stack<>();
        for (int i = 0; i < parenteses.length; i++) {
            if(parenteses[i].equals("(")){
                stack.push("(");
            } else if (parenteses[i].equals(")") && !stack.isEmpty()) {
                stack.pop();
            } else return 'N';
        }
        if(stack.isEmpty())
            return 'S';
        return 'N';
    }
}
