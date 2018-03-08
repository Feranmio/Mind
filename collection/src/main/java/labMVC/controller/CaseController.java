package labMVC.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;


import labMVC.domain.Case;
import labMVC.domain.InOut;
import labMVC.domain.PaymentPlan;
import labMVC.repository.CaseRepository;
import labMVC.service.CaseService;
import labMVC.service.InOutService;
import labMVC.service.PlanService;

@Controller
@RequestMapping("/case")
public class CaseController {
	@Autowired
	CaseRepository caseRepo;
	
	@Autowired
	CaseService caseServ;
	
	@Autowired
	PlanService planServ;
	
	@Autowired
	InOutService inOutServ;

	@RequestMapping("/pay")
	public String pay() {
        return "case/pay";
	}
	
	@RequestMapping("/")
    public String caseLogin() {
        return "case/caseLogin";
	}
	
	@RequestMapping("/caseLogin")
    public String caseSummaryLogin() {
        return "case/caseLogin";
	}
	
	@RequestMapping(value= "/login", method = RequestMethod.GET)
	public String caseVerification(@RequestParam("caseId") int caseId, HttpSession session){
		String view = "not changed";
		Case caseTmp = caseRepo.findOneByCaseId(caseId);

		if (caseTmp.getId() == caseId){
			view ="redirect:/case/caseSummary?caseId="+caseId;
//			view ="redirect:/case/caseSummary";
		}else{
			view ="case/caseLogin";
		}
		session.setAttribute("Case", caseTmp);
		return view;
	}
	
	@RequestMapping("/caseDashboard")
	public String caseDashboard() {
        return "case/caseDashboard";
	}
	
	@RequestMapping(value = "/caseSummary", method = RequestMethod.GET) 
	public String caseSummary(@ModelAttribute("caseTmp")Case caseTmp,@RequestParam("caseId") int caseId, ModelMap model) {
		caseTmp = caseRepo.findOneByCaseId(caseId);

		model.addAttribute("id", caseTmp.getId());
		model.addAttribute("reason", caseTmp.getReason());
		model.addAttribute("service", caseTmp.getService());
		model.addAttribute("date", caseTmp.getDate());
		model.addAttribute("amount", caseTmp.getAmount());
		model.addAttribute("info", caseTmp.getInfo());
		model.addAttribute("debtorName", caseTmp.getDebtorName());
		model.addAttribute("creditorName", caseTmp.getCreditorName());
		model.addAttribute("paid", caseTmp.getPaid());

       return "case/caseSummary";
	}
	
	@RequestMapping(value = "/paymentPlan", method = RequestMethod.GET)
	  public ModelAndView paymentPlan(@ModelAttribute("plan") PaymentPlan plan) {
		
		int planId = plan.getId();
		String tPeriod = plan.getTimePeriod();
		String pDebtor = plan.getDebtorName();
		Double pAmount = plan.getAmount();
		String pReason = plan.getReason();
		
		if(pDebtor != null){
			
			PaymentPlan planB = new PaymentPlan();
			
			planB.setId(planId);
			planB.setTimePeriod(tPeriod);
			planB.setDebtorName(pDebtor);;
			planB.setAmount(pAmount);
			planB.setReason(pReason);
			
			planServ.save(planB);
		
		}
		return new ModelAndView("case/paymentPlan");
	}
	
	@RequestMapping(value = "/inOut", method = RequestMethod.GET)
	  public ModelAndView inOut(@ModelAttribute("inOut") InOut inOut) {
		
		int id = inOut.getId();
		int caseId = inOut.getCaseId();
		String name = inOut.getName();
		String date = inOut.getDate();
		String employment = inOut.getEmployment();
		String dependents = inOut.getDependents();
		String housing = inOut.getHousing();
		int income = inOut.getIncome();
		int outgoing = inOut.getOutgoing();
		int debts = inOut.getDebts();
		int available = inOut.getAvailable();
		String info = inOut.getInfo();
		
		if(name != null){
			InOut inOutgoing = new InOut();
			
			inOutgoing.setId(id);
			inOutgoing.setCaseId(caseId);
			inOutgoing.setName(name);
			inOutgoing.setDate(date);
			inOutgoing.setEmployment(employment);
			inOutgoing.setDependents(dependents);
			inOutgoing.setHousing(housing);
			inOutgoing.setIncome(income);
			inOutgoing.setOutgoing(outgoing);
			inOutgoing.setDebts(debts);
			inOutgoing.setAvailable(available);
			inOutgoing.setInfo(info);
			
			inOutServ.save(inOutgoing);		
		}
		return new ModelAndView("case/inOut");
	}

}
