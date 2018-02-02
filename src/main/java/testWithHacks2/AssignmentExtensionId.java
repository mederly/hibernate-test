package testWithHacks2;

import java.io.Serializable;
import java.util.Objects;

public class AssignmentExtensionId implements Serializable {

	private String ownerOwnerOid;
	private Integer ownerId;

	public AssignmentExtensionId() {
	}

	public String getOwnerOwnerOid() {
		return ownerOwnerOid;
	}

	public void setOwnerOwnerOid(String ownerOwnerOid) {
		this.ownerOwnerOid = ownerOwnerOid;
	}

	public Integer getOwnerId() {
		return ownerId;
	}

	public void setOwnerId(Integer ownerId) {
		this.ownerId = ownerId;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o)
			return true;
		if (!(o instanceof AssignmentExtensionId))
			return false;
		AssignmentExtensionId that = (AssignmentExtensionId) o;
		return Objects.equals(ownerOwnerOid, that.ownerOwnerOid) &&
				Objects.equals(ownerId, that.ownerId);
	}

	@Override
	public int hashCode() {

		return Objects.hash(ownerOwnerOid, ownerId);
	}
}
