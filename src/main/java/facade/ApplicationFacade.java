/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package facade;

import entities.Customer;
import entities.ItemType;
import entities.Orderline;
import entities.Orderm;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

public class ApplicationFacade {
    EntityManagerFactory emf = Persistence.createEntityManagerFactory("pu");
    
    public Customer createCustomer(Customer c) {
        
        EntityManager em = emf.createEntityManager();
        
        Customer newCust = c;
        
        try {
            em.getTransaction().begin();
            em.persist(newCust);
            em.getTransaction().commit();
            
            return newCust;
        } finally {
            em.close();
        }
        
    }
    
    public Customer findCustomer(int id) {
        
        EntityManager em = emf.createEntityManager();
        
        try {
            Customer foundCust = (Customer)em.createQuery("SELECT c FROM Customer c WHERE c.id = "+ id).getSingleResult();
            return foundCust;
        } finally {
            em.close();
        }
        
    }
    
    public List<Customer> getAllCustomers() {
        
        EntityManager em = emf.createEntityManager();
        
        try {
            List<Customer> allCust = em.createQuery("SELECT c FROM Customer c").getResultList();
            
            return allCust;
        } finally {
            em.close();
        }
        
    }
    
    public ItemType createItemType(ItemType it) {
        
        EntityManager em = emf.createEntityManager();
        
        ItemType item = it;
        try {
            em.getTransaction().begin();
            em.persist(item);
            em.getTransaction().commit();
            
            return item;
        } finally {
            em.close();
        }
    }
    
    public ItemType findItemType(int id) {
        
        EntityManager em = emf.createEntityManager();
        
        ItemType foundItem = em.find(ItemType.class, id);
        return foundItem;
    }
    
    public Customer addOrder(int custID, Orderm order) {
        
        EntityManager em = emf.createEntityManager();
        
        try {    
            Customer foundCust = em.find(Customer.class, custID);

            foundCust.setOrder(order);

            em.getTransaction().begin();
            em.persist(foundCust);
            em.getTransaction().commit();
            
            return foundCust;
        } finally {
            em.close();
        }
    }
    
    public void addOrderline(Orderm order, Orderline ol) {
        
        EntityManager em = emf.createEntityManager();
        
        try {    
            Orderm foundOrder = em.find(Orderm.class, order.getId());

            foundOrder.setOrderline(ol);

            em.getTransaction().begin();
            em.persist(foundOrder);
            em.getTransaction().commit();

        } finally {
            em.close();
        }
    }
    
    public List<Orderm> getAllOrdersForCustomer(Customer c) {
        EntityManager em = emf.createEntityManager();
        try {
            List<Orderm> allOrders;
            TypedQuery<Orderm> tq = em.createQuery("SELECT o FROM Customer c JOIN c.orders o WHERE c.id = :cid", Orderm.class);
            tq.setParameter("cid", c.getId());
            allOrders = tq.getResultList();
            return allOrders;
        } finally {
            em.close();
        }
    }
    
}
