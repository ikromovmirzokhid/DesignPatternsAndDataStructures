package designPatterns.observer;

public class Trader implements Observer {
    @Override
    public void update(Stock stock) {
        trade(stock);
    }

    private void trade(Stock stock) {
        System.out.println("Trader trade: - " + stock);
    }
}
