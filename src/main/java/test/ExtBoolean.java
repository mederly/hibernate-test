package test;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Objects;

/**
 * @author mederly
 */
//@IdClass(ExtBooleanId.class)
@Entity
public class ExtBoolean implements Serializable {

	private AssignmentExtension owner;
	private Boolean value;

	@Id
	@ManyToOne(fetch = FetchType.LAZY, optional = false)
	public AssignmentExtension getOwner() {
		return owner;
	}

	@Id
	public Boolean isValue() {
		return value;
	}

	public void setValue(Boolean value) {
		this.value = value;
	}

	public void setOwner(AssignmentExtension owner) {
		this.owner = owner;
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
