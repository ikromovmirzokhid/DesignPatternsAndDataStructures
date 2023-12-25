package designPatterns.factory.abstractFactory;

interface DaoFactory {

    ProductDAO getProductDao();

    CustomerDAO getCustomerDao();
}
