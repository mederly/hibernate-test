package testWithManualMerge;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Objects;

@Entity
public class ExtBoolean implements Serializable /*, EntityState */ {

	private AssignmentExtension owner;
	private Boolean value;

	@Id
	@ManyToOne(fetch = FetchType.LAZY, optional = false)
//	@JoinColumns(value = {
//			@JoinColumn(name = "owner_owner_owner_oid", referencedColumnName = "owner_owner_oid"),
//			@JoinColumn(name = "owner_owner_id", referencedColumnName = "owner_id")
//	}, foreignKey = @ForeignKey(name = "fk_owner"))
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
		return Objects.equals(owner, that.owner) &&
				Objects.equals(value, that.value);
	}

	@Override
	public int hashCode() {
		return Objects.hash(owner, value);
	}
}
