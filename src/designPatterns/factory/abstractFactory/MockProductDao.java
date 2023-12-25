package designPatterns.factory.abstractFactory;

public class MockProductDao implements ProductDAO {
    @Override
    public Product getProductById(int id) {
        return new Product("testProduct", id);
    }
}
