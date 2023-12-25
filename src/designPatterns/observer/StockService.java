package designPatterns.observer;

public class StockService extends Subject {
    public void changeStockValue(String stockName, double value) {
        Stock stock = new Stock(stockName, value);
        System.out.println("StockService changeStockValue: - " + stock);
        notify(stock);
    }
}
