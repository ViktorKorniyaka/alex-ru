package controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * Created with IntelliJ IDEA.
 * User: User
 * Date: 22.09.13
 * Time: 14:42
 * To change this template use File | Settings | File Templates.
 */
@Controller
@RequestMapping("/welcome2")
public class HelloViewController {

    @RequestMapping(method = RequestMethod.POST)         //???
    public String test(@RequestParam("name") String param, Model model){
        model.addAttribute("name",param);
        System.out.println(param);
        return "HelloView";
    }

}
