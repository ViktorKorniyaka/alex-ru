package dao;

import entity.Client;
import entity.User;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: User
 * Date: 25.09.13
 * Time: 13:49
 * To change this template use File | Settings | File Templates.
 */
public interface ClientDAO extends BaseDAO<Client,Long>{

    public void addClient(Client client, User user);      // добавить / сохранить
    public void deleteClient(User user, Integer clientId);
    public List<Client> listClients(Integer UserId);
    public void editClient(Long id);
    public Client findClientByName(String name);
  //  public void retriveClient(Long id);      //вызвать

}
