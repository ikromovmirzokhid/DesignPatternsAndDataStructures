package designPatterns.observer;

public class StockNotifier implements Observer {
    @Override
    public void update(Stock stock) {
        handleStockChange(stock);
    }

    private void handleStockChange(Stock stock) {
        System.out.println("StockNotifier handleStockChange: - " + stock);
    }
}
