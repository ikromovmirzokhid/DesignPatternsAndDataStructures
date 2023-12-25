package designPatterns.factory.abstractFactory;

public class CustomerDaoImpl implements CustomerDAO {
    @Override
    public Customer getCustomer(int id) {
        return new Customer(id, "Miz");
    }
}
