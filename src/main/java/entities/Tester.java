package entities;

import facade.ApplicationFacade;
import java.util.List;

public class Tester {
    ApplicationFacade af = new ApplicationFacade();
    
    public static void main(String[] args) {
        new Tester().run();
    }
    
    public void run() {
        Customer c1 = new Customer("pp boi", "a@a.com");
        af.createCustomer(c1);
     
        Orderm o1 = new Orderm(c1);
        af.addOrder(c1.getId(), o1);
        
        ItemType it = new ItemType("Name", "description", 999);
        af.createItemType(it);
        
        Orderline oLine = new Orderline(10, it);
        af.addOrderline(o1, oLine);
        
        
        List<Orderm> l = af.getAllOrdersForCustomer(c1);
        
        for (Orderm order : l) {
            System.out.println(order.getCustomer().getName());
        }
        
        
    }
}
