package designPatterns.factory.abstractFactory;

public class ProductService extends Service {

    Product getProductById(int id) {
        return factory.getDaoFactory().getProductDao().getProductById(id);
    }
}
