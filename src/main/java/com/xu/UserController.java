package com.xu;  

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.web.servlet.ModelAndView;  
import org.springframework.web.bind.annotation.PathVariable;


@Controller  
@RequestMapping("/user")  
public class UserController {  
  
    @RequestMapping("/{id}")  
    public ModelAndView view(@PathVariable("id") Long id, HttpServletRequest req) {  
        User user = new User();  
        user.setId(id);  
        user.setName("zhang");  
  
        ModelAndView mv = new ModelAndView();  
        mv.addObject("user", user);  
        mv.setViewName("user/view");  
        return mv;  
    }  
}  
