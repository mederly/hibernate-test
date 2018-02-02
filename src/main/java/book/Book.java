package book;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import java.io.Serializable;
import java.util.Objects;

@Entity(name = "Book")
public class Book implements Serializable {

	@Id
	@ManyToOne(fetch = FetchType.LAZY)
	private Author author;

	@Id
	@ManyToOne(fetch = FetchType.LAZY)
	private Publisher publisher;

	@Id
	private String title;

	public Book(Author author, Publisher publisher, String title) {
		this.author = author;
		this.publisher = publisher;
		this.title = title;
	}

	private Book() {
	}

	public Author getAuthor() {
		return author;
	}

	public void setAuthor(Author author) {
		this.author = author;
	}

	public Publisher getPublisher() {
		return publisher;
	}

	public void setPublisher(Publisher publisher) {
		this.publisher = publisher;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) {
			return true;
		}
		if (o == null || getClass() != o.getClass()) {
			return false;
		}
		Book book = (Book) o;
		return Objects.equals(author, book.author) &&
				Objects.equals(publisher, book.publisher) &&
				Objects.equals(title, book.title);
	}

	@Override
	public int hashCode() {
		return Objects.hash(author, publisher, title);
	}
}
