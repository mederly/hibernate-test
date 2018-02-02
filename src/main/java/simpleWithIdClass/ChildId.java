package simpleWithIdClass;

import javax.persistence.Id;
import java.io.Serializable;
import java.util.Objects;

public class ChildId implements Serializable {
	private Parent parent;
	private String value;

	public ChildId() {
	}

	public ChildId(Parent parent, String value) {
		this.parent = parent;
		this.value = value;
	}

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

	@Override
	public boolean equals(Object o) {
		if (this == o)
			return true;
		if (!(o instanceof Id))
			return false;
		ChildId id = (ChildId) o;
		return Objects.equals(parent, id.parent) &&
				Objects.equals(value, id.value);
	}

	@Override
	public int hashCode() {
		return Objects.hash(parent, value);
	}
}
