package test;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Objects;

/**
 * @author mederly
 */
//@IdClass(ExtBooleanId.class)
@Entity
public class ExtBoolean implements Serializable, EntityState {

	private Boolean trans;

	private AssignmentExtension owner;
	private Boolean value;

	public ExtBoolean() {
		System.out.println("aaaaaaaaa");
	}

	@Id
	@ManyToOne(fetch = FetchType.LAZY, optional = false)
	public AssignmentExtension getOwner() {
		return owner;
	}

	@GeneratedValue(generator = "SimpleIdGenerator")
	@GenericGenerator(name = "SimpleIdGenerator", strategy = "test.SimpleIdGenerator")
	@Id
	public Boolean isValue() {
		return value;
	}

	public Boolean isTransient() {
		return trans;
	}

	public void setTransient(Boolean trans) {
		this.trans = trans;
	}

	public void setValue(Boolean value) {
		this.value = value;
	}

	public void setOwner(AssignmentExtension owner) {
		this.owner = owner;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o)
			return true;
		if (!(o instanceof ExtBoolean))
			return false;
		ExtBoolean that = (ExtBoolean) o;
		return value == that.value;
	}

	@Override
	public int hashCode() {
		return Objects.hash(value);
	}
}
