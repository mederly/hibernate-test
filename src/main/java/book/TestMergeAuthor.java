package book;

import org.hibernate.Session;

public class TestMergeAuthor {
    public static void main(String[] args) {
        try {
            create();
            System.out.println("**********************************************************************************");
            update();
        } finally {
            HibernateUtil.shutdown();
        }
    }

    private static void create() {
        Session session = HibernateUtil.getSessionFactory().openSession();

        session.beginTransaction();

        Publisher publisher = new Publisher();
        publisher.setName("Addison-Wesley");
        session.persist(publisher);

        Author author = new Author();
        author.setName("Joshua Bloch");

        Book book = new Book(author, publisher, "Effective Java");
        author.getBooks().add(book);

        session.persist(author);
        session.getTransaction().commit();

        session.close();
    }

    private static void update() {
        Session session = HibernateUtil.getSessionFactory().openSession();

        session.beginTransaction();

        Publisher publisher = session.load(Publisher.class, "Addison-Wesley");

        Author author = new Author();
        author.setName("Joshua Bloch");

        Book book = new Book(author, publisher, "Effective Java 2nd Ed");
        author.getBooks().add(book);

        session.merge(author);
        session.getTransaction().commit();

        session.close();
    }
}