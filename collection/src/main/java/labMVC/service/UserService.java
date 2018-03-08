package labMVC.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import labMVC.domain.User;
import labMVC.repository.UserRepository;

@Service
public class UserService {
	@Autowired
	private UserRepository userRepo;
	
	public Object findAllUsers(){
		return userRepo.findAll();
	}
	
	public List<User> findAll(){
		return (List<User>) userRepo.findAll();
	}
	
	public User findById(Integer id){
		return userRepo.findOne(id);
	}
	
	public void save(User user){
		userRepo.save(user);
	}
	
	public void remove(User user){
		userRepo.delete(user);
	}
}
