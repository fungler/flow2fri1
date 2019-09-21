package entities;

import entities.Customer;
import entities.Orderline;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2019-09-20T14:28:31")
@StaticMetamodel(Orderm.class)
public class Orderm_ { 

    public static volatile ListAttribute<Orderm, Orderline> orderlines;
    public static volatile SingularAttribute<Orderm, Integer> id;
    public static volatile SingularAttribute<Orderm, Customer> customer;

}