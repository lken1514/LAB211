package Model;

import java.util.Hashtable;
import java.util.Map;

public class Order {
    private String Customer;
    private Map<Fruit, Integer> order = new Hashtable<>();

    public Order() {
    }

    public Order(String Customer, Map<Fruit, Integer> order) {
        this.Customer = Customer;
        this.order = order;
    }

    public String getCustomer() {
        return Customer;
    }

    public void setCustomer(String Customer) {
        this.Customer = Customer;
    }

    public Map<Fruit, Integer> getOrder() {
        return order;
    }

    public void setOrder(Map<Fruit, Integer> order) {
        this.order = order;
    }

    @Override
    public String toString() {
        return super.toString();
    }
    
}
