package bll;

import bll.validators.EmailValidator;
import bll.validators.Validator;
import com.mysql.cj.xdevapi.Client;
import dao.ClientsDAO;
import model.Clients;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

public class ClientsBLL {
    private Validator validator;
    private ClientsDAO clientDAO;

    /**
     * client
     */
    public ClientsBLL(){
        validator = new EmailValidator();
        clientDAO = new ClientsDAO();
    }

    /**
     * @param id i
     * @return returneaza
     */
    public Clients findById(int id){
        Clients client = clientDAO.findById(id);
        if(client == null){
            throw new NoSuchElementException("The student was not found");
        }
        return client;
    }

    /**
     * @return retureaza
     */
    public List<Clients> findAll(){
        List<Clients> clienti = clientDAO.findAll();
        if(clienti == null){
            throw new NoSuchElementException("There are no clients");
        }
        return clienti;
    }

    /**
     * @param client c
     */
    public void insertClient(Clients client){
        validator.validate(client);
        clientDAO.insert(client);
    }

    /**
     * @param client c
     * @param id i
     */
    public void updateClient(Clients client, int id){
        validator.validate(client);
        clientDAO.update(client, id);
    }

    /**
     * @param id i
     */
    public void deleteClient(int id){
        Clients client = clientDAO.findById(id);
        validator.validate(client);
        clientDAO.delete(client.getId());
    }
}
