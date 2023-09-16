package entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

import lombok.Data;

@Data
@Entity
public class ClassRoom {
	@Id
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	private int classId;
	private String className;
	@OneToOne
	private Subjects subject;

	
	public ClassRoom(){
		super();
	}
}