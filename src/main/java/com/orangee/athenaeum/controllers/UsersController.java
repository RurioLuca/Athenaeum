package com.orangee.athenaeum.controllers;

import com.orangee.athenaeum.dao.UsersDao;
import com.orangee.athenaeum.models.Users;
import com.orangee.athenaeum.utils.CodeUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Luca on 23/03/2018.
 */
@Controller
public class UsersController {

    @Autowired
    private UsersDao usersDao;

    @ResponseBody
    @RequestMapping(value = "users/all", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Users> getAllUsers() {

        return usersDao.getAll();

    }

    @ResponseBody
    @RequestMapping(value = "users/insert", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    public Map insertNewClient(@RequestParam(value = "nome") String nome,
                               @RequestParam(value = "cognome") String cognome
    ) {

        Map<String, String> response = new HashMap<>();


        Users user = new Users();
        user.setCognome(cognome);
        user.setNome(nome);


        user.setMatricola(CodeUtils.randomGenerationCode(15));


        usersDao.create(user);

        response.put("code", "success");
        return response;
    }

    @ResponseBody
    @RequestMapping(value = "/client/delete/{users_id}", method = RequestMethod.DELETE, produces = MediaType.APPLICATION_JSON_VALUE)
    public Map deleteBook(
            @PathVariable("user_id") long user_id
    ) {
        Map<String, String> response = new HashMap<>();

        Users users = usersDao.findById(user_id);
        if (users == null) {
            response.put("code", "failed");
            response.put("message", "utente inesistente");
            return response;
        }

        usersDao.delete(users);

        response.put("code", "success");
        return response;

    }
}
