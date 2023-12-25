package designPatterns.factory.abstractFactory;

public class MockDaoFactory implements DaoFactory {
    @Override
    public ProductDAO getProductDao() {
        return new MockProductDao();
    }

    @Override
    public CustomerDAO getCustomerDao() {
        return new MockCustomerDao();
    }
}
