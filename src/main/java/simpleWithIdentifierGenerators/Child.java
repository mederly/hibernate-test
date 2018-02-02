package simpleWithIdentifierGenerators;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Persister;

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
	@GenericGenerator(
			name = "parent",
			strategy = "simpleWithIdentifierGenerators.ParentIdentifierGenerator"
	)
	@GeneratedValue(
			generator = "parent",
			strategy = GenerationType.AUTO
	)
	@ManyToOne(fetch = FetchType.LAZY, optional = false)
	public Parent getParent() {
		return parent;
	}

	public void setParent(Parent parent) {
		this.parent = parent;
	}

	@Id
	@GenericGenerator(
			name = "value",
			strategy = "simpleWithIdentifierGenerators.ValueIdentifierGenerator"
	)
	@GeneratedValue(
			generator = "value",
			strategy = GenerationType.AUTO
	)
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
