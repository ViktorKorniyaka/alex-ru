package dao;

import entity.Client;
import entity.Product;
import entity.User;

import java.util.Date;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: User
 * Date: 02.10.13
 * Time: 9:50
 * To change this template use File | Settings | File Templates.
 */
public interface ProductDAO  {
    public void saveProduct(Product product, Integer clientId, User user);      // добавить / сохранить
    public void deleteProduct(Integer productId, Integer clientId, User user);
    public void editProduct(Integer productId,Product product);
    public List<Product> listProducts(Integer clientId);
    public Product findClientByName(String name);
    public List<Product> listProductsByDate(Date dateEnd,Integer userId );
    public Product retriveProduct (Integer productId);
}
