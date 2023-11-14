package vn.edu.iuh.fit.repositories;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;

public class Connection {
    private static Connection instance;
    private EntityManagerFactory emf;
    private Connection(){
        emf = Persistence.createEntityManagerFactory("lab_week_2");
    }
    public static Connection getInstance(){
        if(instance == null){
            instance = new Connection();
        }
        return instance;
    }
    public EntityManagerFactory getEmf(){
        return  emf;
    }
    public static void main(String[] args) {
        EntityManagerFactory emf = Connection.getInstance().getEmf();
        EntityManager em = emf.createEntityManager();
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
