package simple;

import javax.persistence.*;
import java.io.Serializable;

@Entity
public class Child implements Serializable {

	@Id
	@ManyToOne(fetch = FetchType.LAZY, optional = false)
	private Parent parent;

	@Id
	private String value;

	public Parent getParent() {
		return parent;
	}

	public void setParent(Parent parent) {
		this.parent = parent;
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}
}
