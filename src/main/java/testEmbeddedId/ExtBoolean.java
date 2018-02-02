package testEmbeddedId;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import java.io.Serializable;

@Entity
public class ExtBoolean implements Serializable /*, EntityState */ {

	@EmbeddedId
	private ExtBooleanPK pk;

	public ExtBooleanPK getPk() {
		return pk;
	}

	public void setPk(ExtBooleanPK pk) {
		this.pk = pk;
	}
}
