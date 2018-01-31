package test;

import org.hibernate.annotations.Cascade;

import javax.persistence.*;
import java.io.Serializable;

@IdClass(AssignmentId.class)
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

	@Cascade(org.hibernate.annotations.CascadeType.ALL)
	@JoinColumns(value = {
			@JoinColumn(name = "id", referencedColumnName = "owner_id")
	}, foreignKey = @ForeignKey(ConstraintMode.NO_CONSTRAINT))
	@OneToOne(cascade = CascadeType.ALL, orphanRemoval = true)
	public AssignmentExtension getExtension() {
		return extension;
	}

	public void setExtension(AssignmentExtension extension) {
		this.extension = extension;
	}
}