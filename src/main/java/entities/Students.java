package entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import lombok.Data;

@Data
@Entity
public class Students {
	@Id
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	private Long studentId;
	private String studentName;
	@ManyToOne
	private Subjects subject;
	public Students(String studentName, Subjects subject) {
		super();
		this.studentName = studentName;
		this.subject = subject;
	}
	public Students() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	

}