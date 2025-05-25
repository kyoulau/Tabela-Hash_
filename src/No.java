import java.util.EmptyStackException;

public class No<E> {

    E element;
    No <E> next;

    public No(E element) {
        this.element = element;
        this.next = null;
    }

    public No(E element, No<E> next) {
        this.element = element;
        this.next = next;
    }
}