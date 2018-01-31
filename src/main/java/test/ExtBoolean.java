package test;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Objects;

/**
 * @author mederly
 */
@IdClass(ExtBooleanId.class)
@Entity
public class ExtBoolean implements Serializable {

	private AssignmentExtension owner;

	private Integer ownerId;
	private Boolean value;

	@MapsId("owner")
	@ManyToOne(fetch = FetchType.LAZY, optional = false)
	public AssignmentExtension getOwner() {
		return owner;
	}

	@Id
	@Column(name="owner_owner_id")
	public Integer getOwnerId() {
		if (owner != null && ownerId == null) {
			ownerId = owner.getId();
		}
		return ownerId;
	}

	@Id
	public boolean isValue() {
		return value;
	}

	public void setValue(boolean value) {
		this.value = value;
	}

	public void setOwnerId(Integer ownerId) {
		this.ownerId = ownerId;
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
