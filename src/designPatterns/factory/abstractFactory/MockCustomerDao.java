package designPatterns.factory.abstractFactory;

public class MockCustomerDao implements CustomerDAO {
    @Override
    public Customer getCustomer(int id) {
        return new Customer(id, "testCustomer");
    }
}
