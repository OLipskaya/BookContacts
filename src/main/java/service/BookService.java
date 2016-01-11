package service;

import model.Contact;

import javax.persistence.*;
import java.util.List;

public class BookService {
    @PersistenceContext(unitName = "BookPersistenceUnit")
    private EntityManager em;

    public BookService(){
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("BookPersistenceUnit");
        em = emf.createEntityManager();
    }

    public List<Contact> getAll(){
        //ClientRequestContext

        EntityTransaction et = em.getTransaction();
        et.begin();
        Query query = em.createQuery("SELECT c from Contact c");
        List<Contact> contacts = null;
        //contacts = em.getResultList();
        et.commit();
        return contacts;
    }

    public Contact getContact(String id){
        Contact cn = em.find(Contact.class, id);
        if(!cn.equals(null)){ return cn; }
        return new Contact();
    }

    public void updateContact(Contact cn, String id){
        EntityTransaction et = em.getTransaction();
        et.begin();
        Query query = em.createQuery("UPDATE c from Contact c WHERE c.id="+id);
        query.executeUpdate();
        et.commit();
    }

    public void addContact(Contact cn){
        EntityTransaction et = em.getTransaction();
        et.begin();
        em.persist(cn);
        et.commit();
    }
}
