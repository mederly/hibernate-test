package test;

import javax.persistence.*;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

@Entity
public class Assignment implements Serializable {

	private Integer id;
	private Set<AssignmentExtension> extensions = new HashSet<>();

	public Assignment() {
	}

	@Id
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "owner", cascade = CascadeType.ALL)
	public Set<AssignmentExtension> getExtensions() {
		return extensions;
	}

	public void setExtensions(Set<AssignmentExtension> extensions) {
		this.extensions = extensions;
	}
}