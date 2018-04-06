package com.orangee.athenaeum.controllers;

import com.orangee.athenaeum.dao.BookDao;
import com.orangee.athenaeum.dao.BorrowDao;
import com.orangee.athenaeum.dao.ClientDao;
import com.orangee.athenaeum.dao.UsersDao;
import com.orangee.athenaeum.form.BorrowForm;
import com.orangee.athenaeum.models.Book;
import com.orangee.athenaeum.models.Borrow;
import com.orangee.athenaeum.models.Client;
import com.orangee.athenaeum.models.Users;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
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

        ModelAndView modelAndView = new ModelAndView();
        // ricerca del prestito nel database
        Borrow borrow = borrowDao.findById(borrow_id);

        //popolo il Bean BorrowForm

        BorrowForm borrowForm = new BorrowForm();

        borrowForm.setBorrow_id(borrow.getPrestito_id());
        borrowForm.setNomeLibro(borrow.getBook().getNome());
        borrowForm.setNomeCliente(borrow.getClient().getNome());
        borrowForm.setNomeUtente(borrow.getUser().getNome());
        borrowForm.setDurataPrestito(borrow.getDurata_prestito());
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");

        borrowForm.setData_prestito(simpleDateFormat.format(borrow.getData_prestito()));
        Calendar calendar_scadenza = Calendar.getInstance();
        calendar_scadenza.setTime(borrow.getData_prestito());
        calendar_scadenza.add(Calendar.DATE, borrow.getDurata_prestito());
        borrowForm.setData_scadenza(simpleDateFormat.format(calendar_scadenza.getTime()));

        if (calendar_scadenza.before(new Date())) {

            borrowForm.setStato_prestito("EXPIRED");

        } else {

            borrowForm.setStato_prestito(borrow.getStato_prestito());

        }

        // aggiungo il bean al modelAndView
        modelAndView.addObject("borrow_form", borrowForm);

        // return borrow_detail.jsp
        modelAndView.setViewName("borrow_detail");

        return modelAndView;
    }


    @RequestMapping(value = "/updateBorrow", method = RequestMethod.POST)
    public String updateBorrow(@ModelAttribute("borrow_form") BorrowForm borrowForm) {
        Borrow borrow = borrowDao.findById(borrowForm.getBorrow_id());

        for (Users users : usersDao.getAll()) {
            if (users.getNome().equals(borrowForm.getNomeUtente())) {
                borrow.setUser(users);
                break;
            }
        }


            for (Client client : clientDao.getAll()) {
            if (client.getNome().equals(borrowForm.getNomeCliente())) {
                borrow.setClient(client);
                break;
            }
        }

        for (Book book : bookDao.getAll()) {
            if (book.getNome().equals(borrowForm.getNomeLibro())) {
                borrow.setBook(book);
                break;
            }
        }

        borrow.setStato_prestito(borrowForm.getStato_prestito());

        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        try {
            borrow.setData_prestito(simpleDateFormat.parse(borrowForm.getData_prestito()));
        } catch (ParseException e) {
            e.printStackTrace();
        }


        borrow.setDurata_prestito(borrowForm.getDurataPrestito());

        borrowDao.update(borrow);
        return "redirect:/mainBorrow";
    }


}
