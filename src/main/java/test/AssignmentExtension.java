package test;

import org.hibernate.annotations.Cascade;

import javax.persistence.*;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

/**
 * @author mederly
 */
@IdClass(AssignmentId.class)
@Entity
public class AssignmentExtension implements Serializable {

    private Assignment owner;

    private Integer id;

	private Set<ExtBoolean> booleans;

    @MapsId("owner")
    @OneToOne(fetch = FetchType.LAZY, optional = false)
    public Assignment getOwner() {
        return owner;
    }

    @Id
    @Column(name = "owner_id")
    public Integer getId() {
        if (owner != null && id == null) {
            id = owner.getId();
        }
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setOwner(Assignment owner) {
        this.owner = owner;
    }

    @Cascade(org.hibernate.annotations.CascadeType.ALL)
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "owner", orphanRemoval = true, cascade = CascadeType.ALL)
	public Set<ExtBoolean> getBooleans() {
		if (booleans == null) {
			booleans = new HashSet<>();
		}
		return booleans;
	}

	public void setBooleans(Set<ExtBoolean> booleans) {
		this.booleans = booleans;
	}
}
