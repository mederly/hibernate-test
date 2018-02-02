package testWithHacks;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@IdClass(ExtBooleanId.class)
public class ExtBoolean implements Serializable {

	private AssignmentExtension owner;
	private Boolean value;

	@Id
	@ManyToOne(fetch = FetchType.LAZY, optional = false)
	@JoinColumns(value = {
			@JoinColumn(name = "owner_owner_owner_oid", referencedColumnName = "owner_owner_oid"),
			@JoinColumn(name = "owner_owner_id", referencedColumnName = "owner_id")
	}, foreignKey = @ForeignKey(name = "fk_owner"))
	public AssignmentExtension getOwner() {
		return owner;
	}

	@Id
	public Boolean getValue() {
		return value;
	}

	public void setValue(Boolean value) {
		this.value = value;
	}

	public void setOwner(AssignmentExtension owner) {
		this.owner = owner;
	}
}
