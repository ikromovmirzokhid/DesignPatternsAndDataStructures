package designPatterns.factory.abstractFactory;

public class ProdDaoFactory implements DaoFactory {
    @Override
    public ProductDAO getProductDao() {
        return new ProductDaoImpl();
    }

    @Override
    public CustomerDAO getCustomerDao() {
        return new CustomerDaoImpl();
    }
}
