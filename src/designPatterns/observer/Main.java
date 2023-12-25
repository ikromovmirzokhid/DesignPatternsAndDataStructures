package designPatterns.observer;

public class Main {
    public static void main(String[] args) {
        StockService stockService = new StockService();
        HistoryLogger historyLogger = new HistoryLogger();
        StockNotifier stockNotifier = new StockNotifier();
        Trader trader = new Trader();
        stockService.addObserver(historyLogger);
        stockService.addObserver(stockNotifier);
        stockService.addObserver(trader);
        stockService.changeStockValue("Google", 210d);
        stockService.removeObserver(stockNotifier);
        stockService.changeStockValue("Amazon", 170d);
    }
}