package designPatterns.strategy;

import java.util.List;

public interface SortStrategy {
    abstract void sort(List<String> ps);
}
