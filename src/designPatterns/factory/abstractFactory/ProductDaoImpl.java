package designPatterns.factory.abstractFactory;

public class ProductDaoImpl implements ProductDAO {
    @Override
    public Product getProductById(int id) {
        return new Product("Apple", id);
    }
}
