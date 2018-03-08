package labMVC.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import static labMVC.LabMvcApplication.ROLE_ADMIN;
import static labMVC.LabMvcApplication.ROLE_CLIENT;
import static labMVC.LabMvcApplication.ROLE_DEBTOR;

import labMVC.domain.Case;
import labMVC.domain.User;
import labMVC.repository.CaseRepository;
import labMVC.repository.UserRepository;
import labMVC.service.CaseService;
import labMVC.service.UserService;

@Controller
@RequestMapping("/admin")
public class AdminController {
	
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
        return "admin/adminDashboard";
	}
	
	@RequestMapping("/adminDashboard")
	public String clientDashboard() {
        return "admin/adminDashboard";
	}
	
	@RequestMapping(value = "/debtorSummary", method = RequestMethod.GET)
	public ModelAndView debtorSummary(Model model) {
        return new ModelAndView("admin/debtorSummary", "debtorList", userRepo.findByRole(ROLE_DEBTOR));
	}
	
	@RequestMapping(value = "/clientSummary", method = RequestMethod.GET)
	public ModelAndView clientSummary(Model model) {
        return new ModelAndView("admin/clientSummary", "clientList", userRepo.findByRole(ROLE_CLIENT));
	}
	
	@RequestMapping(value = "/adminOfficers", method = RequestMethod.GET)
	public ModelAndView adminOfficers(Model model) {
        return new ModelAndView("admin/adminOfficers", "adminList", userRepo.findByRole(ROLE_ADMIN));
	}
	
	@RequestMapping(value = "/caseSummary", method = RequestMethod.GET )
	@ResponseBody 
	public ModelAndView caseSummary(Model model) {	
       return new ModelAndView("admin/caseSummary", "caseList", caseRepo.findAll());
	}
	
	@RequestMapping("/paymentPlan")
	  public String paymentPlan() {
		return "case/paymentPlan";
	}
	
	@RequestMapping(value="/debtorRegister", method = RequestMethod.GET )
	public ModelAndView debtorRegister(@ModelAttribute("user") User user) {
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

			userTmp.setRole(ROLE_DEBTOR);
			
			userServ.save(userTmp);
		}
        return new ModelAndView("admin/debtorRegister");
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
			
			userServ.save(userTmp);
		}
        return new ModelAndView("admin/clientRegister");
	}
	
	@RequestMapping(value="/adminRegister", method = RequestMethod.GET )
	public ModelAndView adminRegister(@ModelAttribute("user") User user) {
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

			userTmp.setRole(ROLE_ADMIN);
			
			userServ.save(userTmp);
		}
        return new ModelAndView("admin/adminRegister");
	}
	
	@RequestMapping(value = "/newCase", method = RequestMethod.GET)
	public ModelAndView newCase(@ModelAttribute("casee") Case casee, @ModelAttribute("user") User user) {
		//Get Case details
		int caseId = casee.getId();
		String reason = casee.getReason();
		String service = casee.getService();
//		String date = casee.getDate();
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
//			caseTmp.setDate(date);
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
		return new ModelAndView("admin/newCase");
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
        return new ModelAndView("admin/newCase");
	}
}
