package testEmbeddedId;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Objects;

@Embeddable
public class AssignmentExtensionPK implements Serializable {
	
	private Assignment owner;

	public AssignmentExtensionPK() {
	}

	@SuppressWarnings("JpaAttributeTypeInspection")
	@JoinColumns(value = {
			@JoinColumn(name = "owner_owner_oid", referencedColumnName = "owner_oid"),
			@JoinColumn(name = "owner_id", referencedColumnName = "id")
	}, foreignKey = @ForeignKey(name = "fk_assignment_extension_owner"))
	@OneToOne(fetch = FetchType.LAZY, optional = false)
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
		if (!(o instanceof AssignmentExtensionPK))
			return false;
		AssignmentExtensionPK id = (AssignmentExtensionPK) o;
		return Objects.equals(owner, id.owner);
	}

	@Override
	public int hashCode() {
		return Objects.hash(owner);
	}
}
