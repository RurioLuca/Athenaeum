package com.orangee.athenaeum.controllers;

import com.orangee.athenaeum.dao.BookDao;
import com.orangee.athenaeum.models.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.text.ParseException;
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


    @RequestMapping(value = "/inserisciLibro", method = RequestMethod.POST)
    public String insertBook(
            @RequestParam("nome_libro") String nome,
            @RequestParam("autore") String autore,
            @RequestParam("date") String data_pubblicazione,
            @RequestParam("anno") int anno
    ) {

        Book book = new Book();
        book.setAnno(anno);
        book.setAutore(autore);
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        try {
            book.setData_pubblicazione(simpleDateFormat.parse(data_pubblicazione));
        } catch (ParseException e) {
            e.printStackTrace();
        }
        book.setNome(nome);

        bookDao.create(book);

        return "index";
    }


}
