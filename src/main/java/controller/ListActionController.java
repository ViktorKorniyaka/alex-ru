package controller;

/**
 * Created with IntelliJ IDEA.
 * User: User
 * Date: 04.10.13
 * Time: 11:06
 * To change this template use File | Settings | File Templates.
 */

import entity.Product;
import entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import service.ProductServiceImpl;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Controller
@RequestMapping("/user/{userName}/list")
public class ListActionController {
    /*@Autowired
    Date dateToday ;*/
    @Autowired
    @Qualifier("productService")     // быть внимательным
    ProductServiceImpl productService ;
    @RequestMapping(value = "/products-by-date", method = RequestMethod.GET)
    public String listProductsByDate(@PathVariable String userName, HttpServletRequest request, Model model) {
          //достаем user
          // потом список его listClients
          // у каждого клиента списов прод listProducts
        model.addAttribute("userName",userName);
        HttpSession sessionHttp = request.getSession(true);    // достаем из сесии user   нужен для создания Листа клиентов
        User user =  (User)  sessionHttp.getAttribute("user");

 /*//!!!*/       Date dateToday = new Date();
        dateToday.getTime();

//!!!        SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
// !!!       String formattedDate = formatter.format(dateToday);
//!!!        System.out.println("MM/dd/yyyy- "+formattedDate);


        System.out.print("dateToday - "+dateToday+ "dateToday.getTime(); - " + dateToday.getTime());
  //      ProductServiceImpl productService = new ProductServiceImpl();
        List<Product> listProductsByDate = productService.listProductsByDate(dateToday, user.getUserId());

 //!!!       model.addAttribute("formattedDate", formattedDate);
        model.addAttribute("dateToday", dateToday);
        model.addAttribute("dateToday", dateToday);
        return "listProductAction";
    }

    @RequestMapping(value = "/products-by-date", method = RequestMethod.POST)
    public String listProductsByDateActions(@PathVariable String userName,  Model model) {
           //ставим галочки выполненных дел

        return "------";
    }
}
