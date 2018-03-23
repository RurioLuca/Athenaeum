package com.orangee.athenaeum.dao;

import com.orangee.athenaeum.models.Client;
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
public class ClientDao {


    @PersistenceContext
    private EntityManager entityManager;

    public void create(Client client) {
        entityManager.persist(client);
        return;
    }


    public void delete(Client client) {
        if (entityManager.contains(client))
            entityManager.remove(client);
        else
            entityManager.remove(entityManager.merge(client));
        return;
    }

    public void update(Client client) {
        entityManager.merge(client);
        return;
    }

    public List<Client> getAll() {
        return (List<Client>) entityManager.createQuery("from Client client").getResultList();
    }


    public Client findById(long clientId) {
        List<Client> clientList = (List<Client>) entityManager.createQuery(
                "from Client client where client.cliente_id = :clientId")
                .setParameter("clientId", clientId)
                .getResultList();
        if (clientList.isEmpty()) {
            return null;
        } else {
            return clientList.get(0);
        }
    }
}
