
import java.util.LinkedList;

public class Lista<T> {

    private LinkedList<T> data;

    public Lista() {
        this.data = new LinkedList<>();
    }

    public int size(){
        return this.data.size();
    }

    public boolean add(T newElement) {
        return this.data.add(newElement);
    }

    public T[] allElements(T[] array) {
        T[] allData = this.data.toArray(array);
        return allData;
    }

}
