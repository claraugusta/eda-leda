package estruturasDeDados;

import java.lang.reflect.Array;
import java.util.Arrays;

public class Queue {

    int head;
    int tail;
    int[] fila;
    private int size;

    // sua fila deve seguir a abordagem circular que vimos em sala de aula.
    // isso implica em dizer quer adições e remoções são O(1).
    public Queue(int capacidade) {
        this.head = -1;
        this.tail = -1;
        this.fila = new int[capacidade];
        this.size = 0;
    }

    public boolean isEmpty() {
        return head == -1 && tail == -1;
    }
    public boolean isFull() {
        return (this.tail + 1) % fila.length == head;
    }

    // deve lançar exceção caso a fila esteja cheia.
    public void addLast(int valor) {
        if(isFull()) throw new RuntimeException("fila cheia");
        if(isEmpty())
            this.head = 0;
        this.size++;
        this.tail = (tail + 1) % this.fila.length;
        this.fila[tail] = valor;
    }

    // deve lançar exceção caso a fila esteja vazia.
    public int removeFirst() {
        if(isEmpty()) throw new RuntimeException("fila vazia");
        int v = this.fila[this.head];

        if(this.head == this.tail){
            this.head = -1;
            this.tail = -1;
        } else
            this.head = (this.head + 1) % this.fila.length;
        this.size--;
        return v;
    }

    // deve lançar exceção caso a fila esteja vazia. apenas retorna o primeiro da fila, sem
    // remover;
    public int getFirst() {
        if(isEmpty()) throw new RuntimeException("fila vazia");
        return this.fila[this.head];
    }

    // deve lançar exceção caso a fila esteja vazia. apenas retorna o último da fila, sem
    // remover;
    public int getLast() {
        if(isEmpty()) throw new RuntimeException("fila vazia");
        return this.fila[this.tail];
    }

    // deve retornar uma string representando a fila.
    public String toString() {
        if(isEmpty()) return "";
        String out = "";
        int i = head;
        int t = tail;
        while (true){
            if(i == t)  break;
            out += this.fila[i] + ", ";
            i = (i + 1) % this.fila.length;
        }
        out += this.fila[tail];
        return out;
    }

    // Deve retornar a posição da primeira ocorrência do elemento passado como parâmetro.
    public int indexOf(int valor) {
        if(isEmpty()) return -1;
        for (int i = head; i <= tail; i = (i+1) % this.fila.length) {
            if(this.fila[i] == valor)   return i;
        }
        return -1;
    }

    // Deve retornar a posição da última ocorrência do elemento passado como parâmetro.
    public int lastIndexOf(int valor) {
        if(isEmpty()) return -1;
        int idx = 0;
        for (int i = head; i != tail; i = (i+1) % this.fila.length) {
            if(this.fila[i] == valor)
                idx = i;
        }
        if(this.fila[tail] == valor)    return tail;
        return idx;
    }

    public int size() {
        return this.size;
    }

}
