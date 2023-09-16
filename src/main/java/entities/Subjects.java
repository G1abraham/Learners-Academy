package entities;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import lombok.Data;

@Data
@Entity
public class Subjects {
	@Id
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	private int subjectId;
    @Column(unique = true)
	private String subjectName;
    @OneToMany(mappedBy = "subject", cascade = CascadeType.ALL)
    private List<Students> studentsList;

    @OneToOne(mappedBy = "subject", cascade = CascadeType.ALL)
    private Faculty faculty;

    @OneToOne(mappedBy = "subject", cascade = CascadeType.ALL)
    private ClassRoom classroom;

	public Subjects(String studentSubject) {
		super();
		this.subjectName = studentSubject;
	}
	public Subjects() {
		super();
	}
	
	

}