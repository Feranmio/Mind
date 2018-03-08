package labMVC.controller;

import static labMVC.LabMvcApplication.ROLE_ADMIN;
import static labMVC.LabMvcApplication.ROLE_CLIENT;
import static labMVC.LabMvcApplication.ROLE_DEBTOR;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import labMVC.repository.UserRepository;

@Controller
public class AuthenticationController {
		
	@Autowired UserRepository userRepo;
	
//	@Autowired UserDAO userDAO;

	
	@RequestMapping(value="/user-login", method=RequestMethod.GET)
	public String loginForm() {
		return "security/login-form";
	}

	@RequestMapping(value="/error-login", method=RequestMethod.GET)
	public String invalidLogin(Model model) {
		model.addAttribute("error", true);
		return "security/login-form";
	}
	
	@RequestMapping(value="/success-login", method=RequestMethod.GET)
	public String successLogin(HttpSession session) { //HttpServletRequest httpServletRequest, Authentication authentication
        User authUser = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();  
        labMVC.domain.User user = userRepo.findByEmail((authUser.getUsername()));
        String view;
        switch (user.getRole()) {
        	case ROLE_ADMIN: 
        		view = "redirect:/admin/adminDashboard"; 
        		break;
        	default: 
        		view = "security/success-login"; 
        		break;
        }
        switch (user.getRole()) {
    	case ROLE_CLIENT: 
    		view = "redirect:/client/clientDashboard"; 
    		break;
    	default: 
    		view = "security/success-login"; 
    		break;
        }
        switch (user.getRole()) {
    	case ROLE_DEBTOR: 
    		view = "redirect:/case/caseDashboard"; 
    		break;
    	default: 
    		view = "security/success-login"; 
    		break;
        }
        session.setAttribute("User", user);
		return view;
	}

	@RequestMapping(value="/user-logout", method=RequestMethod.GET)
	public String logout(Model model, HttpSession session) {
		session.removeAttribute("User");
		model.addAttribute("logout", true);
		return "security/login-form";
	}
	
	@RequestMapping(value="/access-denied", method=RequestMethod.GET)
	public String error() {
		return "security/error-message";
	}
}