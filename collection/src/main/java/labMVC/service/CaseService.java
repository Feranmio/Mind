package labMVC.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import labMVC.domain.Case;
import labMVC.repository.CaseRepository;

@Service
public class CaseService {

	@Autowired
	private CaseRepository caseRepo;
	
	public Object findAllCases(){
		return caseRepo.findAll();
	}
	
	public List<Case> findAll(){
		return (List<Case>) caseRepo.findAll();
	}
	
	public Case findById(Integer id){
		return caseRepo.findOne(id);
	}
	
	public void save(Case cas){
		caseRepo.save(cas);
	}
	
	public void remove(Case cas){
		caseRepo.delete(cas);
	}
}
