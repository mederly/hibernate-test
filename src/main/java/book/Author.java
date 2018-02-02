package book;

import javax.persistence.*;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

@Entity(name = "Author")
public class Author implements Serializable {

	@Id
	private String name;

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "author", orphanRemoval = true, cascade = CascadeType.ALL)
	private Set<Book> books = new HashSet<>();

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Set<Book> getBooks() {
		return books;
	}

	public void setBooks(Set<Book> books) {
		this.books = books;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) {
			return true;
		}
		if (o == null || getClass() != o.getClass()) {
			return false;
		}
		Author author = (Author) o;
		return Objects.equals(name, author.name);
	}

	@Override
	public int hashCode() {
		return Objects.hash(name);
	}
}
