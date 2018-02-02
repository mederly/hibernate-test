package simpleWithIdClass;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@IdClass(ChildId.class)
public class Child implements Serializable {

	private Parent parent;
	private String value;

	public Child() {
	}

	@Id
	@ManyToOne(fetch = FetchType.LAZY, optional = false)
	public Parent getParent() {
		return parent;
	}

	public void setParent(Parent parent) {
		this.parent = parent;
	}

	@Id
	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}
}
