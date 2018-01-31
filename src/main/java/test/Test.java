package test;

import org.hibernate.Session;

public class Test {
    public static void main(String[] args) {
        Session session = HibernateUtil.getSessionFactory().openSession();

        session.beginTransaction();

        Assignment a1 = new Assignment();
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

        Assignment loaded = session.get(Assignment.class, new AssignmentId(10));
//		if (loaded.getExtension() != null) {
//			Set<ExtBoolean> booleans = loaded.getExtension().getBooleans();
//			if (booleans.size() != 1) {
//				throw new AssertionError("Unexpected size of booleans collection: " + booleans.size());
//			}
//			// temporary
//			for (ExtBoolean extBoolean : booleans) {
//				System.out.println("+++++++++++ deleting " + extBoolean);
//				session.delete(extBoolean);
//			}
//		}
        session.delete(loaded);
        session.getTransaction().commit();

        HibernateUtil.shutdown();
    }

}