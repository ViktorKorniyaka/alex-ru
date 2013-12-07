package controller;

import dao.HibernateSession;
import dao.HibernateUtil;
import entity.EnterService;
import entity.User;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import service.UserServiceImpl;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 * Created with IntelliJ IDEA.
 * User: User
 * Date: 25.09.13
 * Time: 16:27
 * To change this template use File | Settings | File Templates.
 */
@Controller
@RequestMapping("/login")
public class LoginController {
    @Autowired
    @Qualifier("enterService")   //will sow
    EnterService enterService;
    @Autowired
    @Qualifier("userService") // быть внимательным
    UserServiceImpl userService;
    @RequestMapping(method = RequestMethod.POST)   //(value = "{client}")        ссылка:- /category/{categoryName}/product/{productName}
    public String getLogin(@RequestParam("login") String login,@RequestParam("password") String password,
                           HttpServletRequest request, Model model,
                           RedirectAttributes attributes) {//помещена в переменную productName -PathVariable

      //  model.addAttribute("login",login);
      //  model.addAttribute("password",password);

//!!!        EnterService enterService = new EnterService();
        Integer id = enterService.autenticate(login,password);

//!!!        UserServiceImpl userService = new UserServiceImpl();
        User user =  userService.retriveUser(id);

        HttpSession session2 = request.getSession(true);   //
        session2.setAttribute("user", user);               //        сохраняем в user !!! сесии
        String email = user.getEmail();
        String userName = user.getUserName();

        attributes.addFlashAttribute("userName", userName);
        attributes.addFlashAttribute("email", email);

       return   "redirect:/user"; /*"redirect:user";*/   // пока после запроса -  http://localhost:8080/user?login=LoginUserName-88&password=88888
    }

    @RequestMapping( method = RequestMethod.GET)
    public String getLoginPage( Model model) {

        return "login";
    }
 }
