package designPatterns.proxy;

import java.util.HashMap;
import java.util.Map;

public class CustomerCachingProxy implements CustomerDAO {
    private CustomerDAO customerDAO;
    private Map<Integer, Customer> customers = new HashMap<>();

    public CustomerCachingProxy(CustomerDAO customerDAO) {
        this.customerDAO = customerDAO;
    }

    @Override
    public Customer getCustomer(int id) {
        Customer customer;
        if (customers.getOrDefault(id, null) != null) {
            System.out.println("Result gotten from cache");
            customer = customers.get(id);
        } else {
            customer = customerDAO.getCustomer(id);
            customers.put(id, customer);
        }
        System.out.println("Caching Proxy customer - " + customer);
        return customer;
    }
}
