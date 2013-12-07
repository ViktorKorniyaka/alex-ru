package controller;

import dao.HibernateSession;
import entity.EnterService;
import entity.User;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;


@Controller
@RequestMapping ("/user")
public class UserController {


    @RequestMapping(method = RequestMethod.GET)       //view показываем после нажатия на ссылку /user
    public String userPage(HttpServletRequest request, Model model) {

        HttpSession sessionHttp = request.getSession(true);    // достаем из сесии user
        User user =  (User)  sessionHttp.getAttribute("user");
        // тут можно полезть в базу и достать конекшен

        model.addAttribute("message", "Hello world!");
        model.addAttribute("userName", user.getUserName());
      //  model.addAttribute("login", user.getLogin());    //!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!1
        model.addAttribute("email", user.getEmail());

        return "/user";  // jsp если все пусто и ввести /user return login - появится логин страничка
    }

    //-----------------------
    @RequestMapping(value = "/account")
    public String requestParam(@RequestParam("log") String log , Model model/*@RequestParam("login") String login, @RequestParam("password") String password, Model model*/) {
        model.addAttribute("content", "foo=" + log );
       /* model.addAttribute("content", "foo=" + foo );
        return OTHER_VIEW_NAME*/
        return log;
    }



}

