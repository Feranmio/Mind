package labMVC.domain;

import java.util.Collection;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.TableGenerator;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

@Entity
@Table(name = "users")
public class User implements UserDetails{

/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
@Id
@TableGenerator(name = "gen1", initialValue = 4)
@GeneratedValue(generator="gen1")
private int id;
@Column
private String title;
@Column
private String firstname;
@Column
private String lastname;
@Column
private String email;
@Column
private String companyName;
@Column
private String companyType;
@Column
private String address;
@Column
private String phone;
@Column
private String password;
@Column
private int role;

public User(){}

public User(int id, String title, String firstname, String lastname, String email, String companyName,
		String companyType, String address, String phone, String password, int role) {
	super();
	this.id = id;
	this.title = title;
	this.firstname = firstname;
	this.lastname = lastname;
	this.email = email;
	this.companyName = companyName;
	this.companyType = companyType;
	this.address = address;
	this.phone = phone;
	this.password = password;
	this.role = role;
}

public int getId() {
	return id;
}
public void setId(int id) {
	this.id = id;
}
public String getTitle() {
	return title;
}
public void setTitle(String title) {
	this.title = title;
}
public String getFirstname() {
	return firstname;
}
public void setFirstname(String firstname) {
	this.firstname = firstname;
}
public String getLastname() {
	return lastname;
}
public void setLastname(String lastname) {
	this.lastname = lastname;
}
public String getEmail() {
	return email;
}
public void setEmail(String email) {
	this.email = email;
}
public String getCompanyName() {
	return companyName;
}
public void setCompanyName(String companyName) {
	this.companyName = companyName;
}
public String getCompanyType() {
	return companyType;
}
public void setCompanyType(String companyType) {
	this.companyType = companyType;
}
public String getAddress() {
	return address;
}
public void setAddress(String address) {
	this.address = address;
}
public String getPhone() {
	return phone;
}
public void setPhone(String phone) {
	this.phone = phone;
}
public String getPassword() {
	return password;
}
public void setPassword(String password) {
	this.password = password;
}
public int getRole() {
	return role;
}
public void setRole(int role) {
	this.role = role;
}

@Override
public Collection<? extends GrantedAuthority> getAuthorities() {
	// TODO Auto-generated method stub
	return null;
}

@Override
public String getUsername() {
	// TODO Auto-generated method stub
	return null;
}

@Override
public boolean isAccountNonExpired() {
	// TODO Auto-generated method stub
	return false;
}

@Override
public boolean isAccountNonLocked() {
	// TODO Auto-generated method stub
	return false;
}

@Override
public boolean isCredentialsNonExpired() {
	// TODO Auto-generated method stub
	return false;
}

@Override
public boolean isEnabled() {
	// TODO Auto-generated method stub
	return false;
}

}
