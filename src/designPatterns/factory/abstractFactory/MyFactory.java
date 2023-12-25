package designPatterns.factory.abstractFactory;

public class MyFactory {
    private DaoFactory daoFactory;
    private int type = 1;

    public MyFactory() {
        if (type == 1)
            daoFactory = new ProdDaoFactory();
        else if (type == 0)
            daoFactory = new MockDaoFactory();
    }

    public DaoFactory getDaoFactory() {
        return daoFactory;
    }
}
