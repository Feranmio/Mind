package labMVC.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import labMVC.domain.User;

public interface UserRepository extends CrudRepository <User, Integer> {
	User findById(int id);
	User findByEmail(String email);
	List<User> findByRole(int role);
	List<User> findByFirstname(String firstname);
	List<User> findByLastname(String lastname);
	List<User> findByCompanyName(String companyName);
	List<User> findByAddress(String address);
	List<User> findByPhone(String phone);

	@Modifying(clearAutomatically=true)
	@Transactional
	@Query(value = "INSERT into users(id, title, firstname, lastname, email, company_name, company_type, address, phone, password) "
			+ "VALUES (:id, :title, :firstname, :lastname, :email, :companyName, :companyType, :address, :phone, :password)" 
			, nativeQuery = true)
	void registerUser(@Param("id") int id, @Param("title") String title, @Param("firstname") String firstname, @Param("lastname") String lastname, 
			@Param("email") String email, @Param("companyName") String companyName, @Param("companyType") String companyType, @Param("address") String address, 
			@Param("phone") String phone, @Param("password") String password);
	
	@Query(value = "SELECT * from users where id like :id%", nativeQuery = true)
	User findOneByUserId(@Param("id") int id);
}

