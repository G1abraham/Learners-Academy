package entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Data;

@Data
@Entity
public class Admin {
	@Id
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	private int adminId;
	private String userName, emailId;
 private String password;
public Admin(String userName, String emailId, String password) {
	super();
	this.userName = userName;
	this.emailId = emailId;
	this.password = password;
}
public Admin() {
	super();
	// TODO Auto-generated constructor stub
}
 

}