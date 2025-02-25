package tstEda;


import java.util.Scanner;

 class RemoveIndexLinkedList {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        LinkedList ll = new LinkedList();
        String[] in = sc.nextLine().split(" ");
        for (int i = 0; i < in.length; i++)
            ll.addLast(Integer.parseInt(in[i]));
        int i = sc.nextInt();
        ll.remove(i);
        System.out.println(ll);
    }
}

class LinkedList {
    private Node head;
    private Node tail;
    protected int size;

    public void addLast(int valor) {
        Node newNode = new Node(valor);
        if(this.head == null){
            this.head = newNode;
        }else{
            this.tail.next = newNode;
            newNode.prev = this.tail;
        }
        this.tail = newNode;
        size++;
    }

    public void remove(int index) {
        if(index < 0 || index >= size) throw new IndexOutOfBoundsException();
        if (index == 0){
            if(this.head.next == null){
                this.head = null;
                this.tail = null;
            }else{
            this.head = this.head.next;
            this.head.prev = null;
            }
        } else if (index == size - 1){
            if(this.head.next == null){
                this.head = null;
                this.tail = null;
            }else{
                this.tail = this.tail.prev;
                this.tail.next = null;
            }
        } else{
            Node aux = this.head;
            for (int i = 0; i < index; i++) {
                aux = aux.next;
            }
            aux.prev.next = aux.next;
            aux.next.prev = aux.prev;

        }
        size--;
    }

    public String toString() {
        if (this.head == null) return "";

        Node aux = this.head;
        String out = "";
        while (aux != null) {
            out += aux.value + " ";
            aux = aux.next;
        }
        return out.substring(0, out.length() - 1);
    }
}

class Node {

    int value;
    Node prev;
    Node next;

    Node(int v) {
        this.value = v;
    }

}
