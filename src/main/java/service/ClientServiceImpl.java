package service;

import dao.*;
import entity.Client;
import entity.Product;
import entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: User
 * Date: 25.09.13
 * Time: 14:57
 * To change this template use File | Settings | File Templates.
 */
/*@Repository*/
@Service
public class ClientServiceImpl implements ClientService {
   // @Autowired
   /* private*/ ProductDAO productDAO /*= new ProductDAOImpl()*/;
  //  @Autowired /*(required=false) @Resource*/
    /*private*/ ClientDAO clientDAO /*= new ClientDAOImpl()*/;

    @Transactional
    public void addClient(Client client, User user) {

        System.out.println("client - "+client);
      //  System.out.println("user - "+user);
        clientDAO.addClient(client, user);
    }

    @Transactional
    public void deleteClient(User user, Integer clientId) {


        List<Product> listProduct =   productDAO.listProducts(clientId);

        for(Product product: listProduct ){
           // client.getProductCollection().remove(product);  // Удалять продукт через ProductServiceImpl

            productDAO.deleteProduct(product.getProductId(),clientId, user);
           // deleteProductList   of product
        }
        clientDAO.deleteClient(user, clientId);
    }


    @Transactional
    public List<Client> listClients(Integer UserId) {
        List<Client> listClients = clientDAO.listClients(UserId);
        return listClients;
    }

    @Transactional
    public Integer findClientByName(User user, String clientName) {
        Integer clientId = -1;
        Integer userID = user.getUserId();
       // List<Client> listClient = listClients(userID);
       List<Client> listClient = clientDAO.listClients(userID);
       // user = 42 и клиент = My11client берем getIdClient

        for(Client client: listClient){

            String clientNameInList = client.getClientName();

            if(clientNameInList.equals(clientName)){                          // --- *****  My10client **** -------
               /* System.out.println("I FIND ClientID" + clientId); */    // находим клиента с таким именем и берем его Id
                clientId = client.getClientId();
            }

        }
        return clientId;
    }
}
