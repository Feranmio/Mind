package labMVC.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import labMVC.domain.PaymentPlan;
import labMVC.repository.PlanRepository;

@Service
public class PlanService {
	@Autowired
	private PlanRepository planRepo;
	
	public Object findAllPlans(){
		return planRepo.findAll();
	}
	
	public List<PaymentPlan> findAll(){
		return (List<PaymentPlan>) planRepo.findAll();
	}
	
	public PaymentPlan findById(Integer id){
		return planRepo.findOne(id);
	}
	
	public void save(PaymentPlan plan){
		planRepo.save(plan);
	}
	
	public void remove(PaymentPlan plan){
		planRepo.delete(plan);
	}
}
