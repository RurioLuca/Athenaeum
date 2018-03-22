package com.orangee.athenaeum.dao;

import com.orangee.athenaeum.models.Book;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

/**
 * Created by Luca on 22/03/2018.
 */
@Repository
@Transactional
@SuppressWarnings("unchecked")
public class BookDao {


    @PersistenceContext
    private EntityManager entityManager;

    public void create(Book book) {
        entityManager.persist(book);
        return;
    }


    public void delete(Book book) {
        if (entityManager.contains(book))
            entityManager.remove(book);
        else
            entityManager.remove(entityManager.merge(book));
        return;
    }

    public void update(Book book) {
        entityManager.merge(book);
        return;
    }

    public List<Book> getAll() {
        return (List<Book>) entityManager.createQuery("from Book book").getResultList();
    }


    public Book findById(long bookId) {
        List<Book> bookList = (List<Book>) entityManager.createQuery(
                "from Book book where book.book_id = :bookId")
                .setParameter("book_id", bookId)
                .getResultList();
        if (bookList.isEmpty()) {
            return null;
        } else {
            return bookList.get(0);
        }
    }
}
