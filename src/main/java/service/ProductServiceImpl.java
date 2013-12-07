package service;

import dao.ProductDAO;
import dao.ProductDAOImpl;
import entity.Client;
import entity.Product;
import entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;



import java.util.Date;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: User
 * Date: 02.10.13
 * Time: 10:13
 * To change this template use File | Settings | File Templates.
 */
@Service
public class ProductServiceImpl implements ProductService {
    //@Autowired
   /* private*/ ProductDAO productDAO /*= new ProductDAOImpl()*/;
    @Override
    public void deleteProduct(Integer productId, Integer clientId, User user) {
        productDAO.deleteProduct(productId, clientId, user);
    }

    @Override
    public void saveProduct(Product product, Integer clientId, User user) {

       productDAO.saveProduct(product, clientId, user);

    }

    public Product retriveProduct (Integer productId){
        Product product = productDAO.retriveProduct(productId);
        return product;
    }

    @Override
    public void editProduct(Integer productId, Product product) {
        productDAO.editProduct(productId, product);
    }

    @Override
    public List<Product> listProducts(Integer clientId) {
        List<Product> listProd = productDAO.listProducts(clientId);
        return listProd;
    }

    @Override
    public Product findClientByName(String name) {
        return null;  //To change body of implemented methods use File | Settings | File Templates.
    }

    public List<Product> listProductsByDate(Date dateEnd, Integer userId ){
        dateEnd.setTime(2014/12/02);

        List<Product> listProd = productDAO.listProductsByDate(dateEnd,userId);
        return listProd;
    }
}
