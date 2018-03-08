package labMVC.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import static labMVC.LabMvcApplication.ROLE_CLIENT;
import static labMVC.LabMvcApplication.ROLE_DEBTOR;

import labMVC.domain.Case;
import labMVC.domain.User;
import labMVC.repository.CaseRepository;
import labMVC.repository.UserRepository;
import labMVC.service.CaseService;
import labMVC.service.UserService;

@Controller
@RequestMapping("/client")
public class ClientController {
	
	@Autowired
	CaseService caseServ;

	@Autowired
	CaseRepository caseRepo;
	
	@Autowired
	UserService userServ;
	
	@Autowired
	UserRepository userRepo;
	
	BCryptPasswordEncoder pe = new  BCryptPasswordEncoder();
	
		@RequestMapping("/")
	    public String clientLogin() {
	        return "client/clientDashboard";
		}
		
		@RequestMapping("/clientDashboard")
		public String clientDashboard() {
	        return "client/clientDashboard";
		}
		
		@RequestMapping(value = "/debtorSummary", method = RequestMethod.GET)
		public ModelAndView debtorSummary(Model model) {
	        return new ModelAndView("client/debtorSummary", "debtorList", userRepo.findByRole(ROLE_DEBTOR));
		}
		
		@RequestMapping(value="/clientRegister", method = RequestMethod.GET )
		public ModelAndView clientRegister(@ModelAttribute("user") User user) {
			int id = user.getId();
			String title = user.getTitle();
			String firstname = user.getFirstname();
			String lastname = user.getLastname();
			String email = user.getEmail();
			String companyName = user.getCompanyName();
			String companyType = user.getCompanyType();
			String address = user.getAddress();
			String phone = user.getPhone();
			String password = user.getPassword();
			
			if(firstname != null){
				User userTmp = new User();

				userTmp.setId(id);
				userTmp.setTitle(title);
				userTmp.setFirstname(firstname);
				userTmp.setLastname(lastname);
				userTmp.setEmail(email);
				userTmp.setCompanyName(companyName);
				userTmp.setCompanyType(companyType);
				userTmp.setAddress(address);
				userTmp.setPhone(phone);
				userTmp.setPassword(pe.encode(password));

				userTmp.setRole(ROLE_CLIENT);
				
				userRepo.save(userTmp);
			}
	        return new ModelAndView("client/clientRegister");
		}
		
		@RequestMapping(value= "/caseOfficers", method = RequestMethod.GET)
		public ModelAndView caseOfficers(Model model) {
			org.springframework.security.core.userdetails.User authUser;
			authUser = (org.springframework.security.core.userdetails.User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
	        User user = userRepo.findByEmail((authUser.getUsername()));
	        String companyName = user.getCompanyName();
			
	        return new ModelAndView( "client/caseOfficers", "clientList", userRepo.findByCompanyName(companyName));
		}
		
		@RequestMapping(value = "/caseSummary", method = RequestMethod.GET ) 
		public ModelAndView caseSummary(Model model) {	
			org.springframework.security.core.userdetails.User authUser;
			authUser = (org.springframework.security.core.userdetails.User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
	        User user = userRepo.findByEmail((authUser.getUsername()));
	        String creditorName = user.getCompanyName();
			
	       return new ModelAndView("client/caseSummary", "caseList", caseRepo.findByCreditorName(creditorName));
		}
		
		@RequestMapping(value = "/newCase", method = RequestMethod.GET)
		  public ModelAndView newCase(@ModelAttribute("casee") Case casee, @ModelAttribute("user") User user) {
			//Get Case details
			int caseId = casee.getId();
			String reason = casee.getReason();
			String service = casee.getService();
			String date = casee.getDate();
			double caseAmount = casee.getAmount();
			String info = casee.getInfo();
			String caseDebtor = casee.getDebtorName();
			String caseCreditor = casee.getCreditorName();
			String moneyPaid = casee.getPaid();

			//Get User details
			int id = user.getId();
			String title = user.getTitle();
			String firstname = user.getFirstname();
			String lastname = user.getLastname();
			String email = user.getEmail();
			String companyName = user.getCompanyName();
			String companyType = user.getCompanyType();
			String address = user.getAddress();
			String phone = user.getPhone();
			String password = user.getPassword();
			
			//Set Case details
			if(reason != null){
				Case caseTmp = new Case(); 

				caseTmp.setId(caseId);
				caseTmp.setReason(reason);
				caseTmp.setService(service);
				caseTmp.setDate(date);
				caseTmp.setAmount(caseAmount);
				caseTmp.setInfo(info);
				caseTmp.setDebtorName(caseDebtor);
				caseTmp.setCreditorName(caseCreditor);
				caseTmp.setPaid(moneyPaid);
				
				caseServ.save(caseTmp);
			}	
			
			//Set User details
			if(firstname != null){
				User userTmp = new User();

				userTmp.setId(id);
				userTmp.setTitle(title);
				userTmp.setFirstname(firstname);
				userTmp.setLastname(lastname);
				userTmp.setEmail(email);
				userTmp.setCompanyName(companyName);
				userTmp.setCompanyType(companyType);
				userTmp.setAddress(address);
				userTmp.setPhone(phone);
				userTmp.setPassword(pe.encode(password));
				
				userTmp.setRole(ROLE_DEBTOR);
				
				userServ.save(userTmp);
			}
			return new ModelAndView("client/newCase");
		}
		
		@RequestMapping(value="/newCase2", method = RequestMethod.GET )
		public ModelAndView newCase2(@ModelAttribute("casee") Case casee) {
			//Get Case details
			int caseId = casee.getId();
			String reason = casee.getReason();
			String service = casee.getService();
			String date = casee.getDate();
			double caseAmount = casee.getAmount();
			String info = casee.getInfo();
			String caseDebtor = casee.getDebtorName();
			String caseCreditor = casee.getCreditorName();
			String moneyPaid = casee.getPaid();
			
			//Set Case details
			if(reason != null){
				Case caseTmp = new Case(); 

				caseTmp.setId(caseId);
				caseTmp.setReason(reason);
				caseTmp.setService(service);
				caseTmp.setDate(date);
				caseTmp.setAmount(caseAmount);
				caseTmp.setInfo(info);
				caseTmp.setDebtorName(caseDebtor);
				caseTmp.setCreditorName(caseCreditor);
				caseTmp.setPaid(moneyPaid);
				
				caseServ.save(caseTmp);
			}
	        return new ModelAndView("client/newCase");
		}

}
