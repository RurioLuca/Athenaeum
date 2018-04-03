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
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.Date;
import java.util.List;

/**
 * Created by Luca on 03/04/2018.
 */
@Controller
public class BorrowWebController {

    @Autowired
    BorrowDao borrowDao;

    @Autowired
    ClientDao clientDao;

    @Autowired
    BookDao bookDao;

    @Autowired
    UsersDao usersDao;


    @RequestMapping(value = "/mainBorrow", method = RequestMethod.GET)
    public ModelAndView mainBorrow() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("main_borrow");

        List<Borrow> borrowList = borrowDao.getAll();

        modelAndView.addObject("size", borrowList.size() - 1);
        modelAndView.addObject("borrow_list", borrowList);
        modelAndView.addObject("users_list", usersDao.getAll());
        modelAndView.addObject("book_list", bookDao.getAll());
        modelAndView.addObject("client_list", clientDao.getAll());

        return modelAndView;
    }

    @RequestMapping(value = "/addBorrow", method = RequestMethod.POST)
    public ModelAndView addBorrow(@RequestParam("user") long user_id,
                                  @RequestParam("client") long client_id,
                                  @RequestParam("book") long book_id,
                                  @RequestParam("durata") int durata) {

        ModelAndView modelAndView = new ModelAndView("redirect:/mainBorrow");

        Users users = usersDao.findById(user_id);
        Client client = clientDao.findById(client_id);
        Book book = bookDao.findById(book_id);

        Borrow borrow = new Borrow();
        borrow.setUser(users);
        borrow.setClient(client);
        borrow.setBook(book);

        borrow.setDurata_prestito(durata);
        borrow.setData_prestito(new Date());
        borrow.setStato_prestito("ACTIVE");

        borrowDao.create(borrow);

        return modelAndView;
    }

    @RequestMapping(value = "/borrowDetail", method = RequestMethod.GET)
    public ModelAndView borroDetail(@RequestParam("borrow_id") long borrow_id) {


        // ricerca del prestito nel database

        //popolo il Bean BorrowForm

        // aggiungo il bean al modelAndView

        // return borrow_detail.jsp


        return new ModelAndView();
    }


    //update borrow

    //delete borrow

}
