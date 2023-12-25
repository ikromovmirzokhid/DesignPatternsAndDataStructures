package designPatterns.observer;

public class Stock {
    String stockName;
    double value;

    public Stock(String stockName, double value) {
        this.stockName = stockName;
        this.value = value;
    }

    @Override
    public String toString() {
        return "Stock{" +
                "stockName='" + stockName + '\'' +
                ", value=" + value +
                '}';
    }
}
