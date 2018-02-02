package testEmbeddedId;

import org.hibernate.Session;

public class TestMerge {
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

        Assignment a1 = new Assignment();
        a1.setOwnerOid("123");
        a1.setId(10);

        AssignmentExtensionPK ae1pk = new AssignmentExtensionPK();
        ae1pk.setOwner(a1);
        AssignmentExtension ae1 = new AssignmentExtension();
        ae1.setPk(ae1pk);
        a1.setExtension(ae1);

        ExtBooleanPK ebPK = new ExtBooleanPK();
        ebPK.setOwner(ae1pk);
        ebPK.setValue(true);
        ExtBoolean eb = new ExtBoolean();
        eb.setPk(ebPK);
        ae1.getBooleans().add(eb);

        session.save(a1);
        session.getTransaction().commit();

        session.close();
    }

    private static void update() {
        Session session = HibernateUtil.getSessionFactory().openSession();

        session.beginTransaction();

        Assignment a1 = new Assignment();
        a1.setOwnerOid("123");
        a1.setId(10);

        AssignmentExtensionPK ae1pk = new AssignmentExtensionPK();
        ae1pk.setOwner(a1);
        AssignmentExtension ae1 = new AssignmentExtension();
        ae1.setPk(ae1pk);
        a1.setExtension(ae1);

        ExtBooleanPK ebPK = new ExtBooleanPK();
        ebPK.setOwner(ae1pk);
        ebPK.setValue(true);
        ExtBoolean eb = new ExtBoolean();
        eb.setPk(ebPK);
        ae1.getBooleans().add(eb);

        session.merge(a1);
        session.getTransaction().commit();
    }
}