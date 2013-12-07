package controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

@Controller
@RequestMapping("/welcome")
public class HalloController {

    @RequestMapping(method = RequestMethod.GET)
    public String printWelcome(/*@RequestParam("testForm") String testForm,*/ Model model) {
        String testForm = "aaa";
        model.addAttribute("message", "Spring_3_MVC-Hello_World");
        model.addAttribute("testForm",testForm);
        return "Hallo";

    }

   /* @RequestMapping(method = RequestMethod.POST)         //???
      public String test(@RequestParam("name") String param, Model model){
        model.addAttribute("name",param);
        System.out.println(param);
        return "HelloView";
    }*/

    @RequestMapping(value = "/form", method = RequestMethod.POST)         //???
    public String test2(@RequestParam("testForm") String param, Model model  ){
      model.addAttribute("testForm",param);

       System.out.println("testForm - " + param);

       /* HalloController.this.printWelcome(model);
        attributes.addFlashAttribute(model);
        bindingResult.*/
       // attributes.addFlashAttribute( "flashMessage", "Flash message");
       // HalloController.this.photoEdit(imageId,binding, model,attributes);
        return "redirect:/welcome";  //Hallo
    }
    @RequestMapping(value = "/form",method = RequestMethod.GET)         //???
    public String test3(/*@RequestParam("lol") String param,@RequestParam("lol2") String param2,@RequestParam("lol3") String param3,*/ Model model){
     /*   model.addAttribute("lol",param);
        System.out.println(param);*/
       /* model.addAttribute("lol2",param2);
        model.addAttribute("lol3",param3);*/

       /* System.out.println(param2);
        System.out.println(param3);*/
        return "HelloView";
    }

    @RequestMapping(value = "/{albumId}/photo/{imageId}/edit", method = RequestMethod.POST)
    public String photoEdit(@PathVariable long imageId, /*@Valid ImageView imageView,*/ BindingResult binding, Model model, RedirectAttributes attributes) {
      //  imageController.edit(imageId, imageView, binding, model, attributes);
        return "redirect:/brand/{manufacturerId}/{modelId}/{vehicleId}/{username}/album/{albumId}/photo/{imageId}";
    }


    /*@RequestMapping(value = "{client}")        //ссылка:- /category/{categoryName}/product/{productName}
    public String classPathVariable(@PathVariable String client,        //помещена в переменную productName -PathVariable
                                                                 Model model) {
        System.out.println("client "+client);
        model.addAttribute("client", client);

        return "HelloView";
    }*/
        //----------------------------CLASS----------------------------------
   /* @Controller
    @RequestMapping(value = "/category/{categoryName}")        //  указанное тут categoryName можно использовать в методах
    public class ClassPathVariableController {

        public static final String PATH_VARIABLE_VIEW_NAME = "class_path_variable";    // jsp которая отображает страицу

        @RequestMapping(value = "/product/{productName}")        //ссылка:- /category/{categoryName}/product/{productName}
        public String classPathVariable(@PathVariable String productName,        //помещена в переменную productName -PathVariable
                                        @PathVariable String categoryName,
                                        Model model) {

            model.addAttribute("categoryName", categoryName);
            model.addAttribute("productName", productName);
            return PATH_VARIABLE_VIEW_NAME;                               // jsp которая отображает страицу
        }*/
  //-------------------------------------------------------------



  /*  @RequestMapping(method = RequestMethod.POST)
    protected String formLog(HttpServletRequest request) throws Exception {
        String log;
        log = request.getParameter("log");
        System.out.println(log);

        ModelMap mm = new ModelMap();
        mm.addAttribute("lol", log);

        return "/welcome/"+log;
    }*/



}