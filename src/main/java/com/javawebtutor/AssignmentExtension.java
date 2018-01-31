package com.javawebtutor;

import javax.persistence.*;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

/**
 * @author mederly
 */
@Entity
public class AssignmentExtension implements Serializable {

	private Assignment owner;
	private Set<ExtBoolean> booleans;

	@Id
	@OneToOne(fetch = FetchType.LAZY, optional = true)
	public Assignment getOwner() {
		return owner;
	}

	public void setOwner(Assignment owner) {
		this.owner = owner;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "owner", orphanRemoval = true, cascade = CascadeType.ALL)
	public Set<ExtBoolean> getBooleans() {
		if (booleans == null) {
			booleans = new HashSet<>();
		}
		return booleans;
	}

	public void setBooleans(Set<ExtBoolean> booleans) {
		this.booleans = booleans;
	}
}
