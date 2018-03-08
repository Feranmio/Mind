package labMVC;

import org.hibernate.SessionFactory;
import org.hibernate.jpa.HibernateEntityManagerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
//import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

//import labMVC.domain.User;
import labMVC.repository.UserRepository;
import labMVC.service.UserService;


@SpringBootApplication
public class LabMvcApplication implements CommandLineRunner {
	
	@Autowired
	UserRepository userRepo;
	
	@Autowired
	UserService userServ;
	

	public static final int ROLE_ADMIN = 1;
	public static final int ROLE_CLIENT = 2;
	public static final int ROLE_DEBTOR = 3;
	
	
    public static void main(String[] args) {
        SpringApplication.run(LabMvcApplication.class, args);
    }
    
    @Bean  
    public static SessionFactory sessionFactory(HibernateEntityManagerFactory hemf){  
        return hemf.getSessionFactory();  
    }  

	@Override
	public void run(String... args) throws Exception {
		
//		//Password Encryption
//		BCryptPasswordEncoder pe = new  BCryptPasswordEncoder();
//
//		//Create Default Users and set parameters
//		User admin = new User();
//		admin.setTitle("Mr");
//		admin.setFirstname("Admin");
//		admin.setLastname("Administrator");
//		admin.setEmail("admin@yahoo.com");
//		admin.setCompanyName("CoCollect");
//		admin.setCompanyType("Individual");
//		admin.setAddress("2 Jones street");
//		admin.setPhone("07990454343");
//		admin.setPassword(pe.encode("admin"));
//		admin.setRole(ROLE_ADMIN);
//		userServ.save(admin);
//
//		User client = new User();
//		client.setTitle("Mr");
//		client.setFirstname("Client");
//		client.setLastname("Client-1");
//		client.setEmail("client@yahoo.com");
//		client.setCompanyName("OZ Cleaning");
//		client.setCompanyType("Sole Trader");
//		client.setAddress("34 wlanut street");
//		client.setPhone("07999023234");
//		client.setPassword(pe.encode("client"));
//		client.setRole(ROLE_CLIENT);
//		userServ.save(client);
//
//		User debtor = new User();
//		debtor.setTitle("Mr");
//		debtor.setFirstname("Debtor");
//		debtor.setLastname("Debtor");
//		debtor.setEmail("debtor@yahoo.com");
//		debtor.setCompanyName("none");
//		debtor.setCompanyType("Partnership");
//		debtor.setAddress("54 lake road");
//		debtor.setPhone("098797990893");
//		debtor.setPassword(pe.encode("debtor"));
//		debtor.setRole(ROLE_DEBTOR);
//		userServ.save(debtor);
	}
     
}
