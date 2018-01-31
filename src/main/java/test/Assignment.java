package test;

import javax.persistence.*;
import java.io.Serializable;

@Entity
public class Assignment implements Serializable {

	private Integer id;
	private AssignmentExtension extension;

	public Assignment() {
	}

	@Id
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	@OneToOne(mappedBy = "owner", cascade = CascadeType.ALL)
	public AssignmentExtension getExtension() {
		return extension;
	}

	public void setExtension(AssignmentExtension extension) {
		this.extension = extension;
	}
}