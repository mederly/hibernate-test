package test;

import java.io.Serializable;
import java.util.Objects;

public class ExtBooleanId implements Serializable {

	private AssignmentExtension owner;
	private Boolean value;

	public ExtBooleanId() {
	}

	public AssignmentExtension getOwner() {
		return owner;
	}

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
		if (!(o instanceof ExtBooleanId))
			return false;
		ExtBooleanId that = (ExtBooleanId) o;
		return Objects.equals(owner, that.owner) &&
				Objects.equals(value, that.value);
	}

	@Override
	public int hashCode() {
		return Objects.hash(owner, value);
	}
}
