package entities;

import entities.ItemType;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2019-09-20T14:28:31")
@StaticMetamodel(Orderline.class)
public class Orderline_ { 

    public static volatile SingularAttribute<Orderline, ItemType> item;
    public static volatile SingularAttribute<Orderline, Integer> qty;
    public static volatile SingularAttribute<Orderline, Long> id;

}