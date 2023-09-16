package entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

import lombok.Data;

@Data
@Entity
public class Faculty {
	@Id
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	private int facultyId;
	private String facultyName;
	@OneToOne
	private Subjects subject;
	
	
	public Faculty() {
		super();
		// TODO Auto-generated constructor stub
	}
}