package designPatterns.factory.abstractFactory;

public class CustomerService extends Service {

    Customer getCustomerById(int id) {
        return factory.getDaoFactory().getCustomerDao().getCustomer(id);
    }

}
