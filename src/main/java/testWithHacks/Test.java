package testWithHacks;

import org.hibernate.Session;

import java.util.Set;

public class Test {
    public static void main(String[] args) {
        Session session = HibernateUtil.getSessionFactory().openSession();

        session.beginTransaction();

        Assignment a1 = new Assignment();
        a1.setOwnerOid("123");
        a1.setId(10);

        AssignmentExtension ae1 = new AssignmentExtension();
        ae1.setOwner(a1);
        a1.setExtension(ae1);

        ExtBoolean eb = new ExtBoolean();
        eb.setOwner(ae1);
        ae1.getBooleans().add(eb);
        eb.setValue(true);

        session.save(a1);
        session.getTransaction().commit();

        session.close();

        System.out.println("**********************************************************************************");
        session = HibernateUtil.getSessionFactory().openSession();

        session.beginTransaction();

        Assignment loaded = session.get(Assignment.class, new Assignment("123", 10));
	    Set<ExtBoolean> booleans = loaded.getExtension().getBooleans();
	    if (booleans.size() != 1) {
		    throw new AssertionError("Unexpected size of booleans collection: " + booleans.size());
	    }
        session.delete(loaded);
        session.getTransaction().commit();

        HibernateUtil.shutdown();
    }

}