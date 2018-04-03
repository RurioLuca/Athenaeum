package com.orangee.athenaeum.controllers;

import com.orangee.athenaeum.dao.ClientDao;
import com.orangee.athenaeum.models.Client;
import com.orangee.athenaeum.utils.CodeUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.*;

/**
 * Created by Luca on 23/03/2018.
 */
@Controller
public class ClientController {

    @Autowired
    private ClientDao clientDao;

    @ResponseBody
    @RequestMapping(value = "client/all", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Client> getAllClient() {

        return clientDao.getAll();

    }
    @ResponseBody
    @RequestMapping(value = "client/insert", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    public Map insertNewClient(@RequestParam(value = "nome") String nome,
                               @RequestParam(value = "cognome") String cognome,
                               @RequestParam(value = "telefono") String telefono) {

        Map<String, String> response = new HashMap<>();

        if (telefono.length() < 10 || telefono.length() > 14) {

            response.put("code", "failed");
            response.put("message",
                    "il numero di telefono che hai inserito non è correto, hai inserito "
                            + telefono.length() + " caratteri");
            return response;
        }

        Client client = new Client();
        client.setNome(nome);
        client.setCognome(cognome);
        client.setTelefono(telefono);
        Date data_registrazione = new Date();
        client.setData_registrazione(data_registrazione);

        Calendar c = Calendar.getInstance();
        c.setTime(data_registrazione);
        c.add(Calendar.YEAR, 1);
        client.setData_scadenza(c.getTime());

        String tessera = CodeUtils.randomGenerationCode(10);
        client.setNumero_tessera(tessera);

        clientDao.create(client);

        response.put("code", "success");
        return response;
    }

    @ResponseBody
    @RequestMapping(value = "/client/delete/{client_id}", method = RequestMethod.DELETE, produces = MediaType.APPLICATION_JSON_VALUE)
    public Map deleteBook(
            @PathVariable("client_id") long client_id
    ) {
        Map<String, String> response = new HashMap<>();

        Client client = clientDao.findById(client_id);

        if (client == null) {
            response.put("code", "failed");
            response.put("message", "cliente inesistente");
            return response;
        }

        clientDao.delete(client);

        response.put("code", "success");
        return response;
    }
}
