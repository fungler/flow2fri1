package entities;
 
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
 
/**
 *
 * @author vince
 */
@Entity
public class Orderm implements Serializable {
 
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
   
    @ManyToOne
    private Customer customer;
   
    @OneToMany(cascade = CascadeType.PERSIST)
    @JoinColumn(name="ORDER_ID")
    private List<Orderline> orderlines = new ArrayList();
 
    public Orderm(Customer customer, List<Orderline> orderline) {
        this.customer = customer;
        this.orderlines = orderline;
    }
 
    public Orderm(Customer customer) {
        this.customer = customer;
    }
   
 
    public Orderm() {
    }
 
    public Customer getCustomer() {
        return customer;
    }
 
    public void setCustomer(Customer customer) {
        this.customer = customer;
    }
 
//    public List<OrderLine> getOrderlines() {
//        return orderlines;
//    }
// 
    public void setOrderline(Orderline orderline) {
        this.orderlines.add(orderline);
    }

 
    public Integer getId() {
        return id;
    }
 
    public void setId(Integer id) {
        this.id = id;
    }
    
}