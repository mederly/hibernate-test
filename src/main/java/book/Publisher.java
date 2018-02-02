package book;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import java.io.Serializable;
import java.util.Objects;

@Entity(name = "Publisher")
public class Publisher implements Serializable {

	@Id
	private String name;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) {
			return true;
		}
		if (o == null || getClass() != o.getClass()) {
			return false;
		}
		Publisher publisher = (Publisher) o;
		return Objects.equals(name, publisher.name);
	}

	@Override
	public int hashCode() {
		return Objects.hash(name);
	}
}

