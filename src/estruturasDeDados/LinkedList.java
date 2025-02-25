package estruturasDeDados;
import java.util.NoSuchElementException;


public class LinkedList {

    private Node head;
    private Node tail;
    private int size;

    public LinkedList() {
        this.size = 0;
        this.head = null;
        this.tail = null;
    }

    public boolean isEmpty() {
        return this.head == null;
    }

    public void addFirst(int valor) {
        Node newNode = new Node(valor);
        if(isEmpty()){
            this.tail = newNode;
        }else {
            this.head.prev = newNode;
            newNode.next = this.head;

        }
        this.head = newNode;
        size++;
    }

    public void addLast(int valor) {
        Node newNode = new Node(valor);
        if(isEmpty()){
            this.head = newNode;
        }else{
            this.tail.next = newNode;
            newNode.prev = this.tail;
        }
        this.tail = newNode;
        size++;
    }

    // adiciona um valor na posição passada como parâmetro
    public void add(int index, int valor) {
        if (index < 0 || index > this.size) throw new IndexOutOfBoundsException();

        if (index == 0) {
            addFirst(valor);
        } else if (index == this.size) {
            addLast(valor);
        } else{
            Node newNode = new Node(valor);
            Node aux = this.head;

            for (int i = 0; i < index - 1; i++)
                aux = aux.next;
            newNode.prev = aux;
            newNode.next = aux.next;
            aux.next = newNode;
            newNode.next.prev = newNode;
            size++;
        }
    }

    public int getFirst() {
        if(isEmpty()) throw new NoSuchElementException();
        return this.head.value;
    }

    public int getLast() {
        if(isEmpty()) throw new NoSuchElementException();
        return this.tail.value;
    }

    // retorna o elemento na posição  passada como parâmetro
    // deve lançar IndexOutOfBoundsException se o índice não for válido.
    public int get(int index) {
        if(index < 0 || index >= size()) throw new IndexOutOfBoundsException();
        Node aux = this.head;
        for (int i = 0; i < index; i++) {
            aux = aux.next;
        }
        return aux.value;
    }

    // deve lançar exceção caso a fila esteja vazia.
    public int removeFirst() {
        if(isEmpty())   throw new NoSuchElementException();

        int rm = this.head.value;
        if(this.head.next == null){
            this.head = null;
            this.tail = null;
        }else{
            this.head = this.head.next;
            this.head.prev = null;
        }
        size--;
        return rm;
    }

    // deve lançar exceção caso a fila esteja vazia.
    public int removeLast() {
        if(isEmpty()) throw new NoSuchElementException();
        int rm = this.tail.value;
        if(this.head.next == null){
            this.head = null;
            this.tail = null;
        }else {
            this.tail = this.tail.prev;
            this.tail.next = null;
        }
        size--;
        return rm;
    }

    // remove o valor no índice passado como parâmetro. retorna o valor removido.
    // lançar exceção se o índice não for válido.
    public int remove(int index) {
        if(index < 0 || index >= size()) throw new IndexOutOfBoundsException();
        int rm = get(index);
        if (index == 0){
            removeFirst();
        } else if (index == size() - 1){
            removeLast();
        } else{
            Node aux = this.head;
            for (int i = 0; i < index; i++) {
                aux = aux.next;
            }
            aux.prev.next = aux.next;
            aux.next.prev = aux.prev;
            size--;
        }
        return rm;
    }

    // remove a primeira ocorrência do elemento cujo valor foi passado como parâmetro.
    // se não encontrar, não faça nada. true se remover, false se não remover.
    public boolean removeByValue(int value) {
        Node aux = this.head;
        int i = 0;
        while (aux != null){
            if (aux.value == value){
                remove(i);
                return true;
            }
            i++;
            aux = aux.next;
        }
        return false;
    }

    // retorna a posição da primeira ocorrência do valor passado como parâmetro.
    public int indexOf(int value) {
        Node aux = this.head;
        int i = 0;
        while (aux != null){
            if (aux.value == value) return i;
            i++;
            aux = aux.next;
        }
        return -1;
    }

    public boolean contains(int v) {
        Node aux = this.head;
        while (aux != null){
            if (aux.value == v) return true;
            aux = aux.next;
        }
        return false;
    }

    // Deve retornar a posição da última ocorrência do elemento passado como parâmetro. 
    public int lastIndexOf(int value) {
        Node aux = this.tail;
        int i = size() - 1;
        while (aux != null){
            if(aux.value == value)  return i;
            i--;
            aux = aux.prev;
        }
        return -1;
    }

    // deve retornar uma string representando a lista. 
    public String toString() {
        if (isEmpty()) return "";

        Node aux = this.head;
        String out = "";
        while (aux != null) {
            out += aux.value + " ";
            aux = aux.next;
        }
        return out.substring(0, out.length() - 1);
    }

    public int size() {
        return this.size;
    }

    public Node getNode(int index) {
        Node aux = this.head;
        int i = 0;
        while (aux != null){
            if(i == index)
                return aux;
            aux = aux.next;
            i++;
        }
        return null;
    }

    public void swap(int indexA, int indexB) {
        if(indexA == indexB)
            return;
        if(indexA < indexB){
            swapNode(indexA, indexB);
        }else swapNode(indexB, indexA);

    }

    private void swapNode(int first, int second){
        Node nodeA = getNode(first);
        Node nodeB = getNode(second);
        Node tempAnext = nodeA.next;
        Node tempBprev = nodeB.prev;
        if(first!=0){
            nodeB.prev = nodeA.prev;
            nodeA.prev.next = nodeB;
        }else
            this.head = nodeB;

        if(second != this.size-1){
            nodeA.next = nodeB.next;
            nodeB.next.prev = nodeA;
        }else
            this.tail = nodeA;

        if(second == first+1){
            nodeB.next = nodeA;
            nodeA.prev = nodeB;
        }else{
            nodeB.next = tempAnext;
            tempAnext.prev = nodeB;
            nodeA.prev = tempBprev;
            tempBprev.next = nodeA;
        }
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