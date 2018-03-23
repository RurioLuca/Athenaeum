package com.orangee.athenaeum.dao;

import com.orangee.athenaeum.models.Borrow;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

/**
 * Created by Luca on 23/03/2018.
 */
@Repository
@Transactional
@SuppressWarnings("unchecked")
public class BorrowDao {


    @PersistenceContext
    private EntityManager entityManager;

    public void create(Borrow borrow) {
        entityManager.persist(borrow);
        return;
    }


    public void delete(Borrow borrow) {
        if (entityManager.contains(borrow))
            entityManager.remove(borrow);
        else
            entityManager.remove(entityManager.merge(borrow));
        return;
    }

    public void update(Borrow borrow) {
        entityManager.merge(borrow);
        return;
    }

    public List<Borrow> getAll() {
        return (List<Borrow>) entityManager.createQuery("from Borrow borrow").getResultList();
    }


    public Borrow findById(long borrowId) {
        List<Borrow> borrowList = (List<Borrow>) entityManager.createQuery(
                "from Borrow borrow where borrow.prestito_id = :borrowId")
                .setParameter("borrowId", borrowId)
                .getResultList();
        if (borrowList.isEmpty()) {
            return null;
        } else {
            return borrowList.get(0);
        }
    }

}
