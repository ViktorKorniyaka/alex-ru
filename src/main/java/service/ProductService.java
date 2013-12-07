package service;

import entity.Client;
import entity.Product;
import entity.User;

import java.util.Date;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: User
 * Date: 02.10.13
 * Time: 10:15
 * To change this template use File | Settings | File Templates.
 */
public interface ProductService {

    public void saveProduct(Product product, Integer clientId, User user);      // добавить / сохранить
    public void deleteProduct(Integer productId, Integer clientId, User user);
    public void editProduct(Integer productId, Product product);    // редактировать
    public List<Product> listProducts(Integer ClientId);
    public List<Product> listProductsByDate(Date dateEnd,  Integer userId );
    public Product findClientByName(String name);
}
