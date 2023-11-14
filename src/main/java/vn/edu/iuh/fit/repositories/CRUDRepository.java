package vn.edu.iuh.fit.repositories;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;
import org.slf4j.Logger;

public abstract class CRUDRepository <T>{
    protected final EntityManager em;
    protected final EntityTransaction trans;
    protected Logger logger;
    public CRUDRepository(){
        em = Persistence.createEntityManagerFactory("lab_week_2")
                .createEntityManager();
        trans = em.getTransaction();
    }
    public boolean add(T t){
        try {
            trans.begin();
            em.persist(t);
            trans.commit();
            return true;
        }
        catch (Exception e){
            trans.rollback();
            logger.error(e.getMessage());
        }
        return false;
    }
    public boolean update(T t){
        try {
            trans.begin();
            em.merge(t);
            trans.commit();
            return true;
        }
        catch (Exception e){
            trans.rollback();
            logger.error(e.getMessage());
        }
        return false;
    }
}
