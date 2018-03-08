package labMVC.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import labMVC.domain.InOut;
import labMVC.repository.InOutRepository;

@Service
public class InOutService {
	@Autowired
	private InOutRepository inOutRepo;
	
	public Object findAllInOut(){
		return inOutRepo.findAll();
	}
	
	public List<InOut> findAll(){
		return (List<InOut>) inOutRepo.findAll();
	}
	
	public InOut findById(Integer id){
		return inOutRepo.findOne(id);
	}
	
	public void save(InOut inOut){
		inOutRepo.save(inOut);
	}
	
	public void remove(InOut inOut){
		inOutRepo.delete(inOut);
	}
}
