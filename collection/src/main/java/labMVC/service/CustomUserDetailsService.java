package labMVC.service;

import static labMVC.LabMvcApplication.ROLE_ADMIN;
import static labMVC.LabMvcApplication.ROLE_CLIENT;
import static labMVC.LabMvcApplication.ROLE_DEBTOR;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import labMVC.repository.UserRepository;

@Service
@Transactional(readOnly=true)
public class CustomUserDetailsService implements UserDetailsService {

	@Autowired
	private UserRepository userRepo;

	public UserDetails loadUserByUsername(String email)
			throws UsernameNotFoundException {
		
		labMVC.domain.User domainUser = userRepo.findByEmail(email);
		
		boolean enabled = true;
		boolean accountNonExpired = true;
		boolean credentialsNonExpired = true;
		boolean accountNonLocked = true;

		return new User(
				domainUser.getEmail(), 
				domainUser.getPassword(), 
				enabled, 
				accountNonExpired, 
				credentialsNonExpired, 
				accountNonLocked,
				getAuthorities(domainUser.getRole())
		);
	}
	
	private Collection<? extends GrantedAuthority> getAuthorities(Integer role) {
		List<GrantedAuthority> authList = getGrantedAuthorities(getRoles(role));
		return authList;
	}
	
	public List<String> getRoles(Integer role) {

		List<String> roles = new ArrayList<String>();

		if (role.intValue() == ROLE_ADMIN) {
			roles.add("ROLE_ADMIN");
		} else if (role.intValue() == ROLE_CLIENT) {
			roles.add("ROLE_CLIENT");
		} else if (role.intValue() == ROLE_DEBTOR) {
			roles.add("ROLE_DEBTOR");
		}
		return roles;
	}
	
	private static List<GrantedAuthority> getGrantedAuthorities(List<String> roles) {
		List<GrantedAuthority> authorities = new ArrayList<GrantedAuthority>();
		
		for (String role : roles) {
			authorities.add(new SimpleGrantedAuthority(role));
		}
		return authorities;
	}
}