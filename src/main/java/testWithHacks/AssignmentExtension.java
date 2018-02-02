package testWithHacks;

import javax.persistence.*;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

@Entity
@IdClass(AssignmentExtensionId.class)
public class AssignmentExtension implements Serializable {

	private Assignment owner;
	private String ownerOwnerOid;
	private Integer ownerId;
	private Set<ExtBoolean> booleans = new HashSet<>();

	@Id
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

    @Column(name = "owner_owner_oid", insertable = false, updatable = false)
	public String getOwnerOwnerOid() {
		if (ownerOwnerOid == null && owner != null) {
			ownerOwnerOid = owner.getOwnerOid();
		}
		return ownerOwnerOid;
	}

	public void setOwnerOwnerOid(String ownerOwnerOid) {
		this.ownerOwnerOid = ownerOwnerOid;
	}

	@Column(name = "owner_id", insertable = false, updatable = false)
	public Integer getOwnerId() {
		if (ownerId == null && owner != null) {
			ownerId = owner.getId();
		}
		return ownerId;
	}

	public void setOwnerId(Integer ownerId) {
		this.ownerId = ownerId;
	}

//	@JoinColumns(value = {
//			@JoinColumn(name = "owner_owner_owner_oid", referencedColumnName = "owner_owner_oid"),
//			@JoinColumn(name = "owner_owner_id", referencedColumnName = "owner_id")
//	}, foreignKey = @ForeignKey(ConstraintMode.NO_CONSTRAINT))
//	@OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL, orphanRemoval = true)
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "owner", orphanRemoval = true, cascade = CascadeType.ALL)
	public Set<ExtBoolean> getBooleans() {
		return booleans;
	}

	public void setBooleans(Set<ExtBoolean> booleans) {
		this.booleans = booleans;
	}
}
