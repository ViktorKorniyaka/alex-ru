package controller;

import dao.HibernateSession;
import entity.Client;
import entity.Product;
import entity.User;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
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
import service.ClientServiceImpl;
import service.ProductServiceImpl;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: User
 * Date: 22.09.13
 * Time: 19:10
 * To change this template use File | Settings | File Templates.
 */
@Controller
@RequestMapping("/client")  /*(value = "{client}")*/
public class ClientController {
    @Autowired
    Client client;
    @Autowired
    @Qualifier("clientService")     // быть внимательным
    ClientServiceImpl clientService;
    @Autowired
    @Qualifier("productService")     // быть внимательным
    ProductServiceImpl productService;

    @RequestMapping(method = RequestMethod.GET)
    public String getListClients(HttpServletRequest request,Model model) {
        // достаем список клиентов
        // достаем userId и передаем его в servise (servise лезит в базу через DAO)
        HttpSession sessionHttp = request.getSession(true);    // достаем из сесии user
        User user =  (User)  sessionHttp.getAttribute("user");

//!!!        ClientServiceImpl clientService = new ClientServiceImpl();
        List<Client> listC =  clientService.listClients( user.getUserId()); // integer userId

        model.addAttribute("usId", listC);

        return "clients";    //clients.jsp
    }

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public String newClient(@RequestParam("clientName") String clientName,@RequestParam("clientTelephone") String clientTelephone,
                                    @RequestParam("clientEmail") String clientEmail, HttpServletRequest request,
                                    RedirectAttributes attributes/*Model model*/) {


        HttpSession sessionHttp = request.getSession(true);    // достаем из сесии user
        User user =  (User)  sessionHttp.getAttribute("user");
        user.getUserName();

        user.getLogin();
 /*       model.addAttribute("clientName", clientName);
        model.addAttribute("clientTelephone", clientTelephone);
        model.addAttribute("clientEmail", clientEmail);*/
        attributes.addFlashAttribute("clientName", clientName);
        attributes.addFlashAttribute("clientTelephone", clientTelephone);
        attributes.addFlashAttribute("clientEmail", clientEmail);

        System.out.println("user.getUserName(); "+user.getUserName());
        System.out.println("user.getEmail(); "+ user.getEmail());
        System.out.println("user.getLogin(); "+   user.getLogin());

        System.out.println("clientName "+clientName);
        System.out.println("clientTelephone "+clientTelephone);
        System.out.println("clientEmail "+clientEmail);

  //!!!      Client client = new Client();
        client.setClientName(clientName);
        client.setClientTelephone(clientTelephone);
        client.setClientEmail(clientEmail);

 //!!!       ClientServiceImpl clientService = new ClientServiceImpl();
        clientService.addClient(client, user);

        return "redirect:/user";
    }
    @RequestMapping(value = "/add", method = RequestMethod.GET)
    public String newClientForm(Model model) {
        return "newClient";    //это имя jsp
    }




    //--------------------------------------
    @RequestMapping(value = "/{clientName}",method = RequestMethod.GET)
    public String getClient(@PathVariable String clientName,/*@RequestParam("productId") String productId,*/ HttpServletRequest request,Model model) {

        System.out.println("clientName - "+clientName);
        model.addAttribute("clientName", clientName);
//-------------------Products--как вставить это содержание через /client/{clientName}/products---------------------------------------------------------------------
        model.addAttribute("clientName", clientName);


        HttpSession sessionHttp = request.getSession(true);    // достаем из сесии user
        User user =  (User)  sessionHttp.getAttribute("user");

 //!!!       ClientServiceImpl clientService = new ClientServiceImpl();
        List<Client> listC =  clientService.listClients(user.getUserId()); // integer userId     можно сохранить в сесии и от туда и достать

        System.out.print("clientName by PathVariable - "+ clientName);

        int idClient = -1;
        for(Client client: listC){

            String clientNameInList = client.getClientName();

            if(clientNameInList.equals(clientName)){                          // --- *****  My10client **** -------
                System.out.println("I FIND ClientID" + idClient);     // находим клиента с таким именем и берем его Id
                idClient = client.getClientId();
            }

        }
 //!!!       ProductServiceImpl productService = new ProductServiceImpl();
        List<Product> listProd = productService.listProducts( idClient );
        model.addAttribute("listProduct", listProd);
        //        model.addAttribute("productId", productId);

        return "client";    //clients.jsp
    }

    @RequestMapping(value = "/{clientName}/delete",method = RequestMethod.GET)
    public String deleteClient(@PathVariable String clientName,HttpServletRequest request,Model model) {
        model.addAttribute("clientName", clientName);
        return "deleteClient";
    }
    @RequestMapping(value = "/{clientName}/delete",method = RequestMethod.POST)
    public String deleteClientNow(@PathVariable String clientName,HttpServletRequest request,RedirectAttributes attributes/*Model model*/) {

        //model.addAttribute("clientName", clientName);

        attributes.addFlashAttribute("clientName", clientName);

        HttpSession sessionHttp = request.getSession(true);    // достаем из сесии user   нужен для создания Листа клиентов
        User user =  (User)  sessionHttp.getAttribute("user");

 //!!!       ClientServiceImpl clientService = new ClientServiceImpl();              // по user и имени достаем Id
        Integer clientId = clientService.findClientByName(user, clientName);
        clientService.deleteClient(user, clientId);



        return "redirect:/client";   //"redirect:/client/{clientName}";
    }





}
