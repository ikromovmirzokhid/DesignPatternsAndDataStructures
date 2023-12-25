package designPatterns.strategy;

import java.util.List;

public class QuickSort implements SortStrategy {

    @Override
    public void sort(List<String> ps) {
        System.out.println("QuickSort sort()");
    }
}
