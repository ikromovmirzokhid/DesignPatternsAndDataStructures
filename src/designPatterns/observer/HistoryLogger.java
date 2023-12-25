package designPatterns.observer;

public class HistoryLogger implements Observer {
    @Override
    public void update(Stock stock) {
        log(stock);
    }

    private void log(Stock stock) {
        System.out.println("HistoryLogger log: - " + stock);
    }
}
