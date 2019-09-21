package entities;

import entities.Orderline;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2019-09-20T14:28:31")
@StaticMetamodel(ItemType.class)
public class ItemType_ { 

    public static volatile SingularAttribute<ItemType, Double> price;
    public static volatile SingularAttribute<ItemType, String> description;
    public static volatile ListAttribute<ItemType, Orderline> orderlines;
    public static volatile SingularAttribute<ItemType, Long> id;
    public static volatile SingularAttribute<ItemType, String> productName;

}