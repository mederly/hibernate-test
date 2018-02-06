package testWithHacks;

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

        AssignmentExtension ae1 = new AssignmentExtension();
        ae1.setOwner(a1);
        a1.setExtension(ae1);

        ExtBoolean eb = new ExtBoolean();
        eb.setValue(true);
        eb.setOwner(ae1);
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

        AssignmentExtension ae1 = new AssignmentExtension();
        ae1.setOwner(a1);
        a1.setExtension(ae1);

        ExtBoolean eb = new ExtBoolean();
        eb.setValue(false);
        eb.setOwner(ae1);
        ae1.getBooleans().add(eb);

        session.merge(a1);
        session.getTransaction().commit();
    }
}