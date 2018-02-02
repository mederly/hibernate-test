package testEmbeddedId;

import javax.persistence.*;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

@Entity
public class AssignmentExtension implements Serializable {

	private AssignmentExtensionPK pk;
	private Set<ExtBoolean> booleans = new HashSet<>();

	@EmbeddedId
	public AssignmentExtensionPK getPk() {
		return pk;
	}

	public void setPk(AssignmentExtensionPK pk) {
		this.pk = pk;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "pk.owner", orphanRemoval = true, cascade = CascadeType.ALL)
	public Set<ExtBoolean> getBooleans() {
		return booleans;
	}

	public void setBooleans(Set<ExtBoolean> booleans) {
		this.booleans = booleans;
	}
}
