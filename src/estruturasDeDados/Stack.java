package estruturasDeDados;

import java.util.Arrays;

public class Stack {

    private int topo;
    private int[] stack;

    public Stack(int capacidade) {
        this.topo = -1;
        this.stack = new int[capacidade];
    }

    public boolean isEmpty() {
        return this.topo == -1;
    }

    public boolean isFull() {
        return this.topo +1 == this.stack.length;
    }

    // deve lançar exceção caso a pilha esteja cheia.
    public void push(int valor) {
        if(isFull())    throw new RuntimeException("pilha cheia");
        this.stack[++this.topo] = valor;
    }

    // deve lançar exceção caso a pilha esteja vazia.
    public int pop() {
        if(isEmpty())    throw new RuntimeException("pilha vazia");
        return this.stack[this.topo--];
    }

    // deve lançar exceção caso a pilha esteja vazia.
    public int peek() {
        if(isEmpty())    throw new RuntimeException("pilha vazia");
        return this.stack[this.topo];
    }


    // deve retornar uma string representando a pilha. Veja os testes para a especificação
    // detalhada. Não é permitido iterar diretamente sobre o array ou criar arrays. Crie outra pilha, se preciso. Use as operações push, pop,
    // isEmpty etc.
    public String toString() {
        Stack aux = new Stack(stack.length);
        String out = "";
        while (!isEmpty()){
            aux.push(peek());
            out += pop();
            if (!isEmpty()) out += ", ";
        }
        while (!aux.isEmpty())
            push(aux.pop());
        return out;
    }

    // Deve retornar a posição da primeira ocorrência do elemento passado como parâmetro. Note que
    // o topo sempre está na primeira posição (0), abaixo do topo é a posição 1 etc. Não confunda
    // com os índices do array. Interprete os testes para a especificação mais detalhada.
    // Não é permitido iterar diretamente sobre o array. Use as operações push, pop,
    // isEmpty etc.
    public int indexOf(int valor) {
        Stack aux = new Stack(stack.length);
        int index = -1;
        while (!isEmpty()){
            aux.push(peek());
            index++;
            if(pop() == valor)  break;
        }
        while (!aux.isEmpty())
            push(aux.pop());

        return index;
    }

    public int size() {
        return topo + 1;
    }

}
