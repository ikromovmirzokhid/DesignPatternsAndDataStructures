package designPatterns.strategy;

import java.util.List;

public class BubbleSort implements SortStrategy {
    @Override
    public void sort(List<String> ps) {
        System.out.println("BubbleSort sort()");
    }
}
