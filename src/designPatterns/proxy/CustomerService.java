package designPatterns.proxy;

import designPatterns.proxy.dynamic.CachingProxy;
import designPatterns.proxy.dynamic.LoggingProxy;
import designPatterns.proxy.dynamic.StopWatchProxy;

import java.lang.reflect.Proxy;

public class CustomerService {
    //    private CustomerDAO customerDao = new CustomerLoggingProxy(new CustomerCachingProxy(new CustomerDAOImpl()));
    CustomerDAO customerDAO = new CustomerDAOImpl();
    ClassLoader classLoader = CustomerDAO.class.getClassLoader();
    CustomerDAO cacheProxy = (CustomerDAO) Proxy.newProxyInstance(classLoader, new Class[]{CustomerDAO.class}, new CachingProxy(customerDAO));
    CustomerDAO loggingProxy = (CustomerDAO) Proxy.newProxyInstance(classLoader, new Class[]{CustomerDAO.class}, new StopWatchProxy(cacheProxy));
    CustomerDAO stopWatchProxy = (CustomerDAO) Proxy.newProxyInstance(classLoader, new Class[]{CustomerDAO.class}, new LoggingProxy(loggingProxy));

    Customer getCustomer(int id) {
        return stopWatchProxy.getCustomer(id);
    }

}
