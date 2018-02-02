package testEmbeddedId;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Objects;

@Embeddable
public class ExtBooleanPK implements Serializable {

	private AssignmentExtensionPK owner;
	private Boolean value;

	public ExtBooleanPK() {
	}

	@SuppressWarnings("JpaAttributeTypeInspection")
	@ManyToOne(fetch = FetchType.LAZY, optional = false)
	@JoinColumns(value = {
			@JoinColumn(name = "owner_owner_owner_oid", referencedColumnName = "owner_owner_oid"),
			@JoinColumn(name = "owner_owner_id", referencedColumnName = "owner_id")
	}, foreignKey = @ForeignKey(name = "fk_owner"))
	public AssignmentExtensionPK getOwner() {
		return owner;
	}

	public Boolean isValue() {
		return value;
	}

	public void setValue(Boolean value) {
		this.value = value;
	}

	public void setOwner(AssignmentExtensionPK owner) {
		this.owner = owner;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o)
			return true;
		if (!(o instanceof ExtBooleanPK))
			return false;
		ExtBooleanPK that = (ExtBooleanPK) o;
		return Objects.equals(owner, that.owner) &&
				Objects.equals(value, that.value);
	}

	@Override
	public int hashCode() {

		return Objects.hash(owner, value);
	}
}
