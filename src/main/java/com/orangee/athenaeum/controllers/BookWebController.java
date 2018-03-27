package com.orangee.athenaeum.controllers;

import com.orangee.athenaeum.dao.BookDao;
import com.orangee.athenaeum.models.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.text.SimpleDateFormat;
import java.util.List;

/**
 * Created by Luca on 27/03/2018.
 */
@Controller
public class BookWebController {

    @Autowired
    private BookDao bookDao;

    @RequestMapping(value = "/findbook", method = RequestMethod.GET)
    public ModelAndView findBook(HttpServletRequest request) {

        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("find_book");
        String book_name = "";
        if (request.getParameter("findbyname") != null) {

            book_name = request.getParameter("findbyname").toString();
            System.out.println("findbyname: " + book_name);
            modelAndView.addObject("book_name", book_name);

            List<Book> bookList = bookDao.getAll();


            for (Book book : bookList) {

                if (book.getNome().toLowerCase().equals(book_name.toLowerCase())) {

                    modelAndView.addObject("book_id", book.getLibro_id());
                    modelAndView.addObject("anno", book.getAnno());
                    modelAndView.addObject("nome_libro", book.getNome());

                    SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
                    modelAndView.addObject("data", simpleDateFormat.format(book.getData_pubblicazione()));
                    modelAndView.addObject("autore", book.getAutore());

                    break;
                }

            }

        }

        return modelAndView;
    }


    /*  listner for url /inserisciLibro and implementation */
}
