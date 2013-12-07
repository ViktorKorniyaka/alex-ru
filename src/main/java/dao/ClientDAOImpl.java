package dao;

import entity.Client;
import entity.Product;
import entity.User;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: User
 * Date: 25.09.13
 * Time: 14:17
 * To change this template use File | Settings | File Templates.
 */
@Repository
public class ClientDAOImpl extends AbstractDAO<Client, Long> implements ClientDAO {

   /* @Autowired
    private SessionFactory sessionFactory;*/

    /*private User;*/

    @Override
    public void addClient(Client client, User user) {
        user.getClient().add(client);    //   my_users_my_client проставляет индексы в users clients

        client.setUser(user);   // проставляет индексы юзеров таблице  my_client

//       HibernateUtil.saveSession(client, user);
       add(client);


    }

    @Override
    public List<Client> listClients(Integer UserId) {
        List<Client> listClients =    HibernateUtil.getSession().createSQLQuery("select * from my_client where user_userid = "+ UserId).addEntity(Client.class).list();
   //     List<Client> listClients =   getSession().createSQLQuery("select * from my_client where user_userid = "+ UserId).addEntity(Client.class).list();

        return listClients;
    }


    @Override
    public void deleteClient(User user, Integer clientId) {
        Client client = (Client) HibernateUtil.getSession().get(Client.class,clientId);   // достаем клиента и удаляем

       HibernateUtil.beginTransaction();// момоему будет открыто много транзауций
/*???*/  //      HibernateUtil.getSession().createSQLQuery("delete * from my_users_my_client where client_clientid = "+ clientId)/*.addEntity(Client.class).list()*/;
        user.getClient().remove(client);  // кругом добавил user  удаляем в my_users_my_client
        user.getClient().remove(client);  // ??????????????? НЕПОНЯТНО ПОЧЕМУ НО С ДВУМЯ РАБОТАЕТ А С ОДНОЙ НЕТ(

        HibernateUtil.getSession().delete(client);


    /*    DELETE FROM suppliers
        WHERE EXISTS
        ( select customers.name
        from customers
        where customers.customer_id = suppliers.supplier_id
        and customers.customer_name = 'IBM' );*/

       // user.getClient().remove(client);

        // вложенная транзакция  может получится
        // удаляем продукт

        // user.getProducts().remove(product);      // удаляем связи  my_users_my_product

      HibernateUtil.commitTransaction();



    }

    @Override
    public void editClient(Long id) {

    }

    @Override
    public Client findClientByName(String name) {
        return null;  //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public List<Client> findAll() {    //from baseDAO
        return null;  //To change body of implemented methods use File | Settings | File Templates.
    }
}
