package controller;

import entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import service.UserService;
import service.UserServiceImpl;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: User
 * Date: 25.09.13
 * Time: 13:05
 * To change this template use File | Settings | File Templates.
 */
@Controller
@RequestMapping(value="/registration")
public class RegistrationController {
    @Autowired
    @Qualifier("userService")     // быть внимательным
    UserServiceImpl userService;
    @RequestMapping(method = RequestMethod.POST)         //???
    public String test2(@RequestParam("login") String login,@RequestParam("userName") String userName,
                        @RequestParam("password") String password,@RequestParam("email") String email, Model model){
        model.addAttribute("login",login);
        System.out.println(login);
        model.addAttribute("userName",userName);
        System.out.println(userName);
        model.addAttribute("password",password);
        System.out.println(password);
        model.addAttribute("email",email);
        System.out.println(email);

        User user = new User();
        user.setLogin(login);
        user.setUserName(userName);
        user.setPassword(password);
        user.setEmail(email);

 // !!!  UserServiceImpl userService = new UserServiceImpl();
        userService.addUser(user);

        return "HelloView";
    }

    @RequestMapping(method = RequestMethod.GET)         //???
    public String test3( Model model){
            return "registration";
    }
}
