package designPatterns.iterator;

import java.util.Iterator;
import java.util.List;

public class ReverseIterator<T> implements Iterator<T> {
    private List<T> list;
    private int position;

    public ReverseIterator(List<T> list) {
        this.list = list;
        this.position = list.size();
    }

    @Override
    public boolean hasNext() {
        int temp = position;
        temp--;
        return temp >= 0;
    }

    @Override
    public T next() {
        int temp = position;
        temp--;
        if(temp >= 0)
            position = temp;
        return list.get(position);
    }

    @Override
    public void remove() {
        throw new UnsupportedOperationException();
    }
}
