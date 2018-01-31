package com.javawebtutor;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import java.io.Serializable;
import java.util.Objects;

/**
 * @author mederly
 */
@Entity
public class ExtBoolean implements Serializable {

	private AssignmentExtension owner;
	boolean value;

	@Id
	@ManyToOne(fetch = FetchType.LAZY, optional = false)
	public AssignmentExtension getOwner() {
		return owner;
	}

	public void setOwner(AssignmentExtension owner) {
		this.owner = owner;
	}

	@Id
	public boolean isValue() {
		return value;
	}

	public void setValue(boolean value) {
		this.value = value;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o)
			return true;
		if (!(o instanceof ExtBoolean))
			return false;
		ExtBoolean that = (ExtBoolean) o;
		return value == that.value;
	}

	@Override
	public int hashCode() {
		return Objects.hash(value);
	}
}
