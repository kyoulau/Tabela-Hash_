public class ListaEncadeada<E> {
    private No<E> head;
    private No<E> tail;
    private int size;

    public int getSize() {
        return size;
    }

    public ListaEncadeada() {
        this.head = null;
        this.size = 0;
    }

    public ListaEncadeada(int tamanho) {
        this.head = null;
        this.size = tamanho;
    }

    public void adicionar(E item) {
        No<E> no = new No<>(item);
        if (isEmpty()) {
            head = tail = no;
        } else {
            tail.next = no;
            head = no;
            size++;
    }}

    public boolean remover(E item) {
        No<E> atual = head;
        No<E> anterior = null;

        while (atual != null) {
            if (atual.element.equals(item)) {
                if (anterior == null) {
                    head = atual.next;
                    if (head == null) {
                        tail = null;
                    }
                } else {
                    anterior.next = atual.next;
                    if (atual == tail) {
                        tail = anterior;
                    }
                }

                size--;
                return true;
            }
            anterior = atual;
            atual = atual.next;
        }
        return false;
    }

    public boolean contem(E item) {
        No<E> atual = head;
        while (atual != null) {
            if (atual.element.equals(item)) {
                return true;
            }
            atual = atual.next;
        }
        return false;
    }

    public void listar() {
        No<E> atual = head;
        while (atual != null) {
            System.out.print(atual.element + ", ");
            atual = atual.next;
        }
        System.out.println("null");
    }

    public boolean isEmpty() {
        return head == null;
    }
}
