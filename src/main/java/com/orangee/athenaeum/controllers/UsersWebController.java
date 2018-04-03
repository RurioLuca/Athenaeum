package com.orangee.athenaeum.controllers;

import com.orangee.athenaeum.dao.UsersDao;
import com.orangee.athenaeum.form.UserForm;
import com.orangee.athenaeum.models.Users;
import com.orangee.athenaeum.utils.CodeUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * Created by Luca on 30/03/2018.
 */
@Controller
public class UsersWebController {

    @Autowired
    UsersDao usersDao;

    @RequestMapping(value = "/mainUsers", method = RequestMethod.GET)
    public ModelAndView mainUsers(HttpServletRequest request) {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("main_users");
        String message = "Ricerca un utente";

        if (request.getParameter("search_field") != null) {
            message = "Nessun utente trovato con questo nome o cognome";
            String searchField = request.getParameter("search_field").toLowerCase();
            List<Users> usersList = usersDao.getAll();
            for (Users users : usersList) {

                if (users.getNome().toLowerCase().equals(searchField) || users.getCognome().toLowerCase().equals(searchField)) {
                    modelAndView.addObject("search_field", searchField);
                    UserForm userForm = new UserForm();
                    userForm.setUser_id(users.getUtente_id());
                    userForm.setName(users.getNome());
                    userForm.setSurname(users.getCognome());
                    userForm.setRegistrationNumber(users.getMatricola());
                    modelAndView.addObject("user_form", userForm);
                    message = "Utente trovato, ma questo messaggio non sarà visualizzato";
                    modelAndView.addObject("is_exist_user", "true");
                    modelAndView.addObject("user_id", users.getUtente_id());
                    break;
                }
            }
        }

        modelAndView.addObject("message", message);

        return modelAndView;
    }

    @RequestMapping(value = "/updateUsers", method = RequestMethod.POST)
    public ModelAndView updateUsers(@ModelAttribute(value = "user_form") UserForm userForm) {
        ModelAndView modelAndView = new ModelAndView("redirect:/mainUsers?search_field=" + userForm.getName());

        Users user = usersDao.findById(userForm.getUser_id());

        user.setMatricola(userForm.getRegistrationNumber());
        user.setNome(userForm.getName());
        user.setCognome(userForm.getSurname());
        usersDao.update(user);


        return modelAndView;
    }

    @RequestMapping(value = "/addUser", method = RequestMethod.GET)
    public String addUser() {
        return "add_user";
    }


    @RequestMapping(value = "/addUser", method = RequestMethod.POST)
    public String addUserForm(@RequestParam("name") String nome,
                              @RequestParam("surname") String cognome) {

        Users user = new Users();
        user.setCognome(cognome);
        user.setNome(nome);
        user.setMatricola(CodeUtils.randomGenerationCode(15));


        usersDao.create(user);
        return "redirect:/mainUsers?search_field=" + nome;
    }
}
