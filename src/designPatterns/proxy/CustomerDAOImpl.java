package designPatterns.proxy;

public class CustomerDAOImpl implements CustomerDAO {

    @Override
    public Customer getCustomer(int id) {
        return new Customer(id, "Miz");
    }
}
