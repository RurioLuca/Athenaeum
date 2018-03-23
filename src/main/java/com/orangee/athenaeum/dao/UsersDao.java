package com.orangee.athenaeum.dao;

import com.orangee.athenaeum.models.Users;
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
public class UsersDao {

    @PersistenceContext
    private EntityManager entityManager;

    public void create(Users users) {
        entityManager.persist(users);
        return;
    }


    public void delete(Users users) {
        if (entityManager.contains(users))
            entityManager.remove(users);
        else
            entityManager.remove(entityManager.merge(users));
        return;
    }

    public void update(Users users) {
        entityManager.merge(users);
        return;
    }

    public List<Users> getAll() {
        return (List<Users>) entityManager.createQuery("from Users users").getResultList();
    }


    public Users findById(long usersId) {
        List<Users> usersList = (List<Users>) entityManager.createQuery(
                "from Users users where users.utente_id = :usersId")
                .setParameter("usersId", usersId)
                .getResultList();
        if (usersList.isEmpty()) {
            return null;
        } else {
            return usersList.get(0);
        }
    }
}
