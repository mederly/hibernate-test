package test;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Objects;

@Entity
public class Assignment implements Serializable {

	private String ownerOid;
	private Integer id;
	private AssignmentExtension extension;

	public Assignment() {
	}

	public Assignment(String ownerOid, Integer id) {
		this.ownerOid = ownerOid;
		this.id = id;
	}

	@Id
	@Column(name = "owner_oid")
	public String getOwnerOid() {
		return ownerOid;
	}

	public void setOwnerOid(String ownerOid) {
		this.ownerOid = ownerOid;
	}

	@Id
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	@JoinColumns(value = {
			@JoinColumn(name = "owner_oid", referencedColumnName = "owner_owner_oid"),
			@JoinColumn(name = "id", referencedColumnName = "owner_id")
	}, foreignKey = @ForeignKey(ConstraintMode.NO_CONSTRAINT))
	@OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL, orphanRemoval = true)
//	@OneToOne(fetch = FetchType.LAZY, mappedBy = "owner", cascade = CascadeType.ALL)        // this does not work!
	public AssignmentExtension getExtension() {
		return extension;
	}

	public void setExtension(AssignmentExtension extension) {
		this.extension = extension;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o)
			return true;
		if (!(o instanceof Assignment))
			return false;
		Assignment that = (Assignment) o;
		return Objects.equals(ownerOid, that.ownerOid) &&
				Objects.equals(id, that.id);
	}

	@Override
	public int hashCode() {
		return Objects.hash(ownerOid, id);
	}
}