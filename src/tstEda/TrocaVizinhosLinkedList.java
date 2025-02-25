package tstEda;

import estruturasDeDados.LinkedList;

import java.util.Scanner;

 class TrocaVizinhosLinkedList {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        LinkedList ll = new LinkedList();
        String[] in = sc.nextLine().split(" ");
        for (int i = 0; i < in.length; i++)
            ll.addLast(Integer.parseInt(in[i]));
        int i = sc.nextInt();
        ll.swap(i,i+1);
        System.out.println(ll);
    }
 }


