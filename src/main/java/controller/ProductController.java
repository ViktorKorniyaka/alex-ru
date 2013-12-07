package controller;

import entity.Client;
import entity.Product;
import entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import service.ClientService;
import service.ProductServiceImpl;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.Date;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: User
 * Date: 02.10.13
 * Time: 10:17
 * To change this template use File | Settings | File Templates.
 */
@Controller
@RequestMapping("/client/{clientName}/products")//("/client/{clientName}")
public class ProductController {

    @Autowired
    @Qualifier("clientService")     // быть внимательным
/*    private*/ ClientService clientService;
    @Autowired
    @Qualifier("productService")     // быть внимательным
    ProductServiceImpl productService ;
    @Autowired
    Product product;

    @RequestMapping( method = RequestMethod.GET)
    public String listProducts(@PathVariable String clientName, HttpServletRequest request, Model model) {

        model.addAttribute("clientName", clientName);
       /* model.addAttribute("productId", productId);*/

        HttpSession sessionHttp = request.getSession(true);    // достаем из сесии user
        User user =  (User)  sessionHttp.getAttribute("user");

        List<Client> listC =  clientService.listClients( user.getUserId()); // integer userId     можно сохранить в сесии и от туда и достать

        System.out.print("clientName by PathVariable - "+ clientName);

        int idClient = -1;
        for(Client client: listC){

            String clientNameInList = client.getClientName();

            if(clientNameInList.equals(clientName)){                          // --- *****  My10client **** -------
                System.out.println("I FIND ClientID" + idClient);     // находим клиента с таким именем и берем его Id
                idClient = client.getClientId();
            }

        }
//!!!        ProductServiceImpl productService = new ProductServiceImpl();
        List<Product> listProd = productService.listProducts( idClient );
        model.addAttribute("listProduct", listProd);
        //лезим в базу достаем лист Products
        //берем объект клиента полусаем id клиента, и подстаем из таблицы  client_clientId продукты где id равен id клиента
       return "products";
    }

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public String addProduct(@PathVariable String clientName, @RequestParam("productName") String productName,
                             @RequestParam("productPrice") Double productPrice,
                             @RequestParam("productCount") String productCount,
                             @RequestParam("dateBuy") Date dateBuy,
                             @RequestParam("dateEnd") Date dateEnd,
                            /* @PathVariable String productId,*/
                            RedirectAttributes attributes,
                             HttpServletRequest request,  Model model) {
        model.addAttribute("clientName", clientName);   // сюда не получаем имя клиента
       System.out.print("clientName ======" + clientName);


        attributes.addFlashAttribute("productName", productName);
        attributes.addFlashAttribute("productPrice", productPrice);
        attributes.addFlashAttribute ("productCount", productCount);
        attributes.addFlashAttribute ("dateBuy", dateBuy);
        attributes.addFlashAttribute ("dateEnd", dateEnd);

      /*  model.addAttribute("productName", productName);
        model.addAttribute("productPrice", productPrice);
        model.addAttribute("productCount", productCount);
        model.addAttribute("dateBuy", dateBuy);
        model.addAttribute("dateEnd", dateEnd);*/

 //       model.addAttribute("productId", productId);


        //new Product
//!!!        Product product = new Product();
        product.setProductName(productName);
        product.setProductPrice(productPrice);
        product.setProductCount(Integer.parseInt(productCount));
        product.setDateBuy(dateBuy);
        product.setDateEnd(dateEnd);
        // client servise - add
        // product service add достаем клиент client и product


        HttpSession sessionHttp = request.getSession(true);    // достаем из сесии user   нужен для создания Листа клиентов
        User user =  (User)  sessionHttp.getAttribute("user");

        Integer clientId = clientService.findClientByName(user, clientName);

 //!!!       ProductServiceImpl productService = new ProductServiceImpl();
        productService.saveProduct(product, clientId, user);

        return "redirect:/client/{clientName}";
    }


    @RequestMapping(value = "/add", method = RequestMethod.GET)
    public String addProduct(@PathVariable String clientName, RedirectAttributes attributes/* Model model*/) {
      //  model.addAttribute("clientName", clientName);
        attributes.addAttribute("clientName", clientName);
        return "addProduct";//"/client/{clientName}";
    }

    @RequestMapping(value = "/{productId}/delete", method = RequestMethod.GET)
    public String deleteProduct(@PathVariable String clientName,@PathVariable Integer productId,  Model model) {
        model.addAttribute("clientName", clientName);
        model.addAttribute("productId", productId);
 //!!!       ProductServiceImpl productService = new ProductServiceImpl();
        Product product = productService.retriveProduct(productId);
        model.addAttribute("productName", product.getProductName());
        return "deleteProduct";//"/client/{clientName}";
    }
    @RequestMapping(value = "/{productId}/delete", method = RequestMethod.POST)
    public String deleteProductNow(@PathVariable String clientName, @PathVariable String productId,
                                   HttpServletRequest request,  RedirectAttributes attributes, Model model) {

     /*   model.addAttribute("clientName", clientName);
        model.addAttribute("productId", productId);*/

        attributes.addFlashAttribute("clientName", clientName);
        attributes.addFlashAttribute("productId", productId);
     //-------------------------------------------------------------
        HttpSession sessionHttp = request.getSession(true);    // достаем из сесии user   нужен для создания Листа клиентов
        User user =  (User)  sessionHttp.getAttribute("user");

        Integer clientId =  clientService.findClientByName(user ,clientName); // client ID в таблицу - нужно ли7

 //!!!       ProductServiceImpl productService = new ProductServiceImpl();
        productService.deleteProduct(Integer.parseInt(productId), clientId, user);

        return "redirect:/client/{clientName}";
    }


    @RequestMapping(value = "/{productId}/change", method = RequestMethod.GET)
    public String changeProduct(@PathVariable String clientName,@PathVariable String productId,  Model model) {
        model.addAttribute("clientName", clientName);
        model.addAttribute("productId", productId);

//!!!        ProductServiceImpl productService = new ProductServiceImpl();
        Product product = productService.retriveProduct(Integer.parseInt(productId));
        model.addAttribute("productName", product.getProductName());
        model.addAttribute("productPrice", product.getProductPrice());
        model.addAttribute("productCount", product.getProductCount());
        model.addAttribute("dateBuy", product.getDateBuy());
        model.addAttribute("dateEnd", product.getDateEnd());


        return "changeProduct";//"/client/{clientName}";
    }

    @RequestMapping(value = "/{productId}/change", method = RequestMethod.POST)
    public String changeProductSave(@PathVariable String clientName,@PathVariable Integer productId,
                                    @RequestParam("productName") String productName,
                                    @RequestParam("productPrice") Double productPrice,
                                    @RequestParam("productCount") Integer productCount,
                                    @RequestParam("dateBuy") Date dateBuy,
                                    @RequestParam("dateEnd") Date dateEnd,
                                    Model model) {
//!!!        ProductServiceImpl productService = new ProductServiceImpl();
        Product product = productService.retriveProduct(productId);

        product.setProductName(productName);
        product.setProductPrice(productPrice);
        product.setProductCount(productCount);
 /*!!!Calendat*/  product.setDateBuy(dateBuy);
 /*!!!Calendat*/  product.setDateEnd(dateEnd);

        productService.editProduct(productId, product);

       return  "redirect:/client/{clientName}";
    }

    @RequestMapping(value = "/{productId}", method = RequestMethod.GET)
    public String showProduct(@PathVariable String clientName,@PathVariable String productId,  Model model) {
        model.addAttribute("productId",productId);
        model.addAttribute("clientName",clientName);

//!!!        ProductServiceImpl productService = new ProductServiceImpl();
        Product product = productService.retriveProduct(Integer.parseInt(productId));
        model.addAttribute("productName", product.getProductName());
        model.addAttribute("productPrice", product.getProductPrice());
        model.addAttribute("productCount", product.getProductCount());
        model.addAttribute("dateBuy", product.getDateBuy());
        model.addAttribute("dateEnd", product.getDateEnd());

        return "product";
    }

}