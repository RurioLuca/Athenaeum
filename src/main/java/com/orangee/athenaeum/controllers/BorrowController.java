package com.orangee.athenaeum.controllers;

import com.orangee.athenaeum.dao.BookDao;
import com.orangee.athenaeum.dao.BorrowDao;
import com.orangee.athenaeum.dao.ClientDao;
import com.orangee.athenaeum.dao.UsersDao;
import com.orangee.athenaeum.models.Book;
import com.orangee.athenaeum.models.Borrow;
import com.orangee.athenaeum.models.Client;
import com.orangee.athenaeum.models.Users;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Luca on 23/03/2018.
 */
@Controller
public class BorrowController {

    @Autowired
    private UsersDao usersDao;

    @Autowired
    private BookDao bookDao;

    @Autowired
    private ClientDao clientDao;

    @Autowired
    private BorrowDao borrowDao;


    @ResponseBody
    @RequestMapping(value = "borrow/all", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Borrow> getAllBorrow() {

        return borrowDao.getAll();

    }

    @ResponseBody
    @RequestMapping(value = "borrow/insert", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    public Map insertNewClient(@RequestParam(value = "book_id") long book_id,
                               @RequestParam(value = "client_id") long client_id,
                               @RequestParam(value = "user_id") long user_id,
                               @RequestParam(value = "durata_prestito") int durata_prestito


    ) {

        Map<String, String> response = new HashMap<>();


        Users users = usersDao.findById(user_id);
        Book book = bookDao.findById(book_id);
        Client client = clientDao.findById(client_id);

        Borrow borrow = new Borrow();
        borrow.setData_prestito(new Date());
        borrow.setStato_prestito("ACTIVE");
        borrow.setDurata_prestito(durata_prestito);
        borrow.setBook(book);
        borrow.setClient(client);
        borrow.setUser(users);

        borrowDao.create(borrow);

        response.put("code", "success");
        return response;

    }


    @ResponseBody
    @RequestMapping(value = "/borrow/delete/{borrow_id}", method = RequestMethod.DELETE, produces = MediaType.APPLICATION_JSON_VALUE)
    public Map deleteBook(
            @PathVariable("borrow_id") long borrow_id
    ) {
        Map<String, String> response = new HashMap<>();

        Borrow borrow = borrowDao.findById(borrow_id);

        if (borrow == null) {
            response.put("code", "failed");
            response.put("message", "prestito inesistente");
            return response;
        }

        borrowDao.delete(borrow);

        response.put("code", "success");
        return response;

    }
}
