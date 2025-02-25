package estruturasDeDados;

public class ArrayList {

    private int[] list;
    private static final int DEFAULT_CAPACITY = 20;
    private int size;

    public ArrayList(int capacidadeInicial) {
        this.list = new int[capacidadeInicial];
        size = 0;
    }

    public ArrayList() {
        this.list = new int[DEFAULT_CAPACITY];
        size = 0;
    }

    public boolean isEmpty() {
        return size == 0;
    }
    private void shiftRight(int index){
        if(index == this.list.length -1) throw new IndexOutOfBoundsException();
        for (int i = this.size; i > index ; i--) {
            this.list[i] = this.list[i-1];
        }
    }
    private void shiftLeft(int index){
        if(index == this.list.length -1) throw new IndexOutOfBoundsException();
        for (int i = index; i < size - 1; i++) {
            this.list[i] = this.list[i+1];
        }
    }
    public void addFirst(int valor) {
        assegureCapacidade(size + 1);
        shiftRight(0);
        this.list[0] = valor;
        this.size++;
    }

    public void addLast(int valor) {
        assegureCapacidade(size+1);
        this.list[size] = valor;
        this.size++;
    }

    // adiciona um valor no índice passado como parâmetro
    public void add(int index, int valor) {
        assegureCapacidade(size + 1);
        shiftRight(index);
        this.list[index] = valor;
        size++;
    }

    private boolean isFull(){
        return size == this.list.length;
    }

    // você vai precisar desse método quando tentar adicionar e a fila já estiver cheia
    private void resize(int novaCapacidade) {
        int[] newList = new int[novaCapacidade];
        for (int i = 0; i < size; i++) {
            newList[i] = this.list[i];
        }
        this.list = newList;
    }

    public void assegureCapacidade(int capacidadePretendida) {
        if(capacidadePretendida > this.list.length)
            resize(Math.max(this.list.length * 2, capacidadePretendida));
    }

    public int getFirst() {
        if (isEmpty()) throw new IndexOutOfBoundsException();
        return this.list[0];
    }

    public int getLast() {
        if (isEmpty()) throw new IndexOutOfBoundsException();
        return this.list[size-1];
    }

    // retorna o elemento no índice passado como parâmetro
    // deve lançar IndexOutOfBoundsException se o índice não for válido.
    public int get(int index) {
        if(index < 0 || index >= this.size) throw new IndexOutOfBoundsException();
        return this.list[index];
    }

    // deve lançar exceção caso a fila esteja vazia.
    public int removeFirst() {
        if(isEmpty()) throw new IndexOutOfBoundsException();
        int rm = get(0);
        shiftLeft(0);
        size--;
        return rm;
    }

    // deve lançar exceção caso a fila esteja vazia.
    public void removeLast() {
        if(isEmpty()) throw new IndexOutOfBoundsException();
        size--;
    }

    // remove o valor no índice passado como parâmetro.
    // lançar exceção se o índice não for válido.
    public void remove(int index) {
        if(index < 0 || index >= this.size) throw new IndexOutOfBoundsException();
        shiftLeft(index);
        size--;
    }

    // remove a primeira ocorrência do elemento cujo valor foi passado como parâmetro.
    // se não encontrar, não faça nada.
    public void removeByValue(int value) {
        for (int i = 0; i < size; i++) {
            if(this.list[i] == value){
                remove(i);
                break;
            }
        }
    }

    // retorna o índice da primeira ocorrência do valor passado como parâmetro.
    public int indexOf(int value) {
        for (int i = 0; i < size; i++) {
            if(this.list[i] == value)
                return i;
        }
        return -1;
    }

    // Deve retornar a posição da última ocorrência do elemento passado como parâmetro.
    public int lastIndexOf(int valor) {
        for (int i = this.size-1; i >= 0; i--) {
            if(this.list[i] == valor)
                return i;
        }
        return -1;
    }

    // deve retornar uma string representando a lista.
    public String toString() {
        String out = "";
        if(!isEmpty()){
            out += this.list[0];
            for (int i = 1; i < size; i++) {
                out += ", " + this.list[i];
            }
        }
        return out;
    }

    public int size() {
        return this.size;
    }
}