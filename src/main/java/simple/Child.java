package simple;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Objects;

@Entity
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

	@Override
	public boolean equals(Object o) {
		if (this == o)
			return true;
		if (!(o instanceof Child))
			return false;
		Child child = (Child) o;
		return Objects.equals(parent, child.parent) &&
				Objects.equals(value, child.value);
	}

	@Override
	public int hashCode() {
		return Objects.hash(parent, value);
	}
}
