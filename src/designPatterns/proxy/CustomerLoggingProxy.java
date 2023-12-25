package designPatterns.proxy;

public class CustomerLoggingProxy implements CustomerDAO {
    private CustomerDAO customerDAO;

    public CustomerLoggingProxy(CustomerDAO customerDAO) {
        this.customerDAO = customerDAO;
    }

    @Override
    public Customer getCustomer(int id) {
        Customer customer = customerDAO.getCustomer(id);
        System.out.println("Logging Proxy customer: " + customer);
        return customer;
    }
}
