package testWithManualMerge;

import javax.persistence.*;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

@Entity
public class AssignmentExtension implements Serializable {

	private Assignment owner;
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

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "owner", orphanRemoval = true, cascade = CascadeType.ALL)
	public Set<ExtBoolean> getBooleans() {
		return booleans;
	}

	public void setBooleans(Set<ExtBoolean> booleans) {
		this.booleans = booleans;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o)
			return true;
		if (!(o instanceof AssignmentExtension))
			return false;
		AssignmentExtension that = (AssignmentExtension) o;
		return Objects.equals(owner, that.owner);
	}

	@Override
	public int hashCode() {
		return Objects.hash(owner);
	}
}
