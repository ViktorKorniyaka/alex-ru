package service;

import entity.Client;
import entity.User;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: User
 * Date: 25.09.13
 * Time: 14:56
 * To change this template use File | Settings | File Templates.
 */
public interface ClientService {

    public void addClient(Client client, User user);      // добавить / сохранить
    public void deleteClient(User user, Integer clientId);
    public List<Client> listClients(Integer UserId);
    public Integer findClientByName(User user, String clientName);

}
