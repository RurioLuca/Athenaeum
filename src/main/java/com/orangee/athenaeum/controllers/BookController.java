package com.orangee.athenaeum.controllers;

import com.orangee.athenaeum.dao.BookDao;
import com.orangee.athenaeum.models.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Luca on 22/03/2018.
 */
@Controller
public class BookController {

    @Autowired
    private BookDao bookDao;

    @ResponseBody
    @RequestMapping(value = "/books/all", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Book> getAllBooks() {
        List<Book> books = bookDao.getAll();


        return books;
    }

    @ResponseBody
    @RequestMapping(value = "/books/insert", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    public Map insertBook(
            @RequestParam("nome") String nome,
            @RequestParam("autore") String autore,
            @RequestParam("data_pubblicazione") String data_pubblicazione,
            @RequestParam("anno") int anno
    ) {

        Book book = new Book();
        book.setAnno(anno);
        book.setAutore(autore);
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd/MM/yyyy");
        try {
            book.setData_pubblicazione(simpleDateFormat.parse(data_pubblicazione));
        } catch (ParseException e) {
            e.printStackTrace();
            Map<String, String> response = new HashMap<>();
            response.put("code", "failed");

            return response;
        }
        book.setNome(nome);

        bookDao.create(book);


        Map<String, String> response = new HashMap<>();
        response.put("code", "success");

        return response;

    }

    @ResponseBody
    @RequestMapping(value = "/books/delete/{book_id}", method = RequestMethod.DELETE, produces = MediaType.APPLICATION_JSON_VALUE)
    public Map deleteBook(
            @PathVariable("book_id") long book_id
    ) {

        Book book = bookDao.findById(book_id);

        bookDao.delete(book);

        Map<String, String> response = new HashMap<>();
        response.put("code", "success");
        return response;

    }
}
