package vn.edu.iuh.fit.db;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;

public class Connection {
    private static Connection instance;
    private EntityManager em;
    private Connection(){
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("lab_week_2");
        em = emf.createEntityManager();
    }
    public static Connection getInstance(){
        if(instance == null){
            instance = new Connection();
        }
        return instance;
    }
    public EntityManager getEntiyManager(){
        return  em;
    }

    public static void main(String[] args) {
        EntityManager em = Connection.getInstance().getEntiyManager();
        EntityTransaction tr = em.getTransaction();
        tr.begin();
        try {
            tr.commit();
        } catch (Exception e) {
            // TODO: handle exception
            e.printStackTrace();
            tr.rollback();
        }
    }
}
