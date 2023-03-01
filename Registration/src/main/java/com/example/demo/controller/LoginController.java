package com.example.demo.controller;

import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.example.demo.model.Employee;

import com.example.demo.service.LoginService;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@Controller
public class LoginController {

@Autowired
    private LoginService loginService;
 	
@GetMapping("/login")
public String showNewLoginForm(Model model) {
	Employee employee = new Employee();
	model.addAttribute("employee",employee);
	return "login";
}
                                  
    /*@GetMapping("/login")
          
    public ModelAndView login() {
     ModelAndView mav = new ModelAndView("login");
        mav.addObject("user", new Employee());
        return mav;
    }*/
 
    @PostMapping("/login")
    public String login(@ModelAttribute("user") Employee user, HttpSession session ) {
    
     Employee oauthUser = loginService.employee(user.getUsername(), user.getPassword());
    
 
     System.out.print(oauthUser);
     if(Objects.nonNull(oauthUser))
     {
    	 session.setAttribute("loggedInUser", user.getUsername());
    	 return "redirect:/home";
    
    
     } else {
     return "redirect:/login?error";
     }
 
}
    @GetMapping("/home")
    public String showHomePage(HttpSession session) {
        String username = (String) session.getAttribute("loggedInUser");
        if (username == null) {
            return "redirect:/login";
        } else {
            // Render the home page with the user's information
            return "home";
        }
    }
    @PostMapping("/logout")
    //@RequestMapping(value = {"/logout"}, method = RequestMethod.POST)
    public String logoutDo(HttpServletRequest request,HttpServletResponse response,HttpSession session)
    {
    	session.invalidate();
        return "redirect:/login";
    }
    
    @GetMapping("/registration")
	public String showNewEmployeeForm(Model model) {
		Employee employee = new Employee();
		model.addAttribute("employee",employee);
		return "registration";
	}
    @PostMapping("/saveEmployee")
	public String saveEmployee(@ModelAttribute("employee") Employee employee ){
		loginService.saveEmployee(employee);
		return ("redirect:/login?success");
		
	}
 
}