package dao;

import entity.Client;
import entity.Product;
import entity.User;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: User
 * Date: 02.10.13
 * Time: 10:09
 * To change this template use File | Settings | File Templates.
 */
@Repository
public class ProductDAOImpl implements ProductDAO {
    @Override
    public void saveProduct(Product product, Integer clientId, User user) {
      //  Client myclient = (Client) session.get(Client.class,idClient);
        Client myclient = (Client) HibernateUtil.getSession().get(Client.class,clientId);
      //  HibernateUtil.getSession()                                                        // НУЖЕН USER OBJECT!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!111
      //  user.getProducts().add(product); //создаем таблицу связей user & product
        myclient.getProductCollection().add(product);
        product.setUser(user);   // сохдаем связь и в табл. product вставляем Id
        product.setClient(myclient);
       /* session.save(product);
        session.save(myclient);
        session.getTransaction().commit();*/
// HibernateUtil.saveSession(product, myclient, user);
        HibernateUtil.saveSession(product);
        HibernateUtil.saveSession(myclient/*,user*/);

       // HibernateUtil.saveSession(user);
    }

    @Override
     public List<Product> listProducts(Integer clientId) {
        List<Product> listProduct =    HibernateUtil.getSession().createSQLQuery("select * from my_product where client_clientid = "+ clientId).addEntity(Product.class).list();

        for(Product product: listProduct){
             System.out.println("product.getProductId() - "+product.getProductId());
             System.out.println("product.getProductName() - "+product.getProductName());
             System.out.println("================================================== ");
         }
        return listProduct;
    }

    public List<Product> listProductsByDate(Date dateEnd , Integer userId) {
       List<Product> listProduct =    HibernateUtil.getSession().createSQLQuery("select * from my_product  where  user_userid = "+userId ).addEntity(Product.class).list();
       // dateend = "+ dateEnd

       List<Product> listProductByDate = new ArrayList<Product>();
        for(Product product: listProduct){
            if(product.getDateEnd().equals(dateEnd)){
                listProductByDate.add(product);
            }

        }
        return listProductByDate;
    }


    @Override
    public void deleteProduct(Integer productId, Integer clientId, User user) {           //поудалять связи с User user  !!!!!!!!!!!!!!!!!!!!!

        Client client = (Client) HibernateUtil.getSession().get(Client.class,clientId);
        Product product = (Product)HibernateUtil.getSession().get(Product.class,productId);

        System.out.println("product.getProductId() DELETE - "+product.getProductId());
        System.out.println("product.getProductName() DELETE - "+product.getProductName());
        System.out.println("=====================DELETE============================= ");

        HibernateUtil.getSession().beginTransaction();// вложенная транзакция  может получится
         // удаляем продукт

       // user.getProducts().remove(product);      // удаляем связи  my_users_my_product
        client.getProductCollection().remove(product);         // удаляем связи  my_client_my_product  !!!!!!!!!!!!!!!!!таблица пуста!!!!!!!!!!!!!!!
        HibernateUtil.getSession().delete(product);
        HibernateUtil.getSession().getTransaction().commit();



    }

    public Product retriveProduct (Integer productId){
        Product product = (Product)HibernateUtil.getSession().get(Product.class,productId);
        return product;
    }

    @Override
    public void editProduct(Integer productId, Product product) {
        HibernateUtil.saveSession(product);

    }



    @Override
    public Product findClientByName(String name) {
        return null;  //To change body of implemented methods use File | Settings | File Templates.
    }
}
