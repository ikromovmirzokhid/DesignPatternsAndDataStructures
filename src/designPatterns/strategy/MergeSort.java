package designPatterns.strategy;

import java.util.List;

public class MergeSort implements SortStrategy {
    @Override
    public void sort(List<String> ps) {
        System.out.println("MergeSort sort()");
    }
}
