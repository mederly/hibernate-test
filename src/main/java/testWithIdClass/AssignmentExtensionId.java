package testWithIdClass;

import java.io.Serializable;
import java.util.Objects;

public class AssignmentExtensionId implements Serializable {
	
	private Assignment owner;

	public AssignmentExtensionId() {
	}

	public Assignment getOwner() {
		return owner;
	}

	public void setOwner(Assignment owner) {
		this.owner = owner;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o)
			return true;
		if (!(o instanceof AssignmentExtensionId))
			return false;
		AssignmentExtensionId id = (AssignmentExtensionId) o;
		return Objects.equals(owner, id.owner);
	}

	@Override
	public int hashCode() {
		return Objects.hash(owner);
	}
}
