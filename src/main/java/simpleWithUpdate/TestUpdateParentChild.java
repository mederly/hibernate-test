package simpleWithUpdate;

import org.hibernate.Session;

public class TestUpdateParentChild {
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

        Parent parent = new Parent();
        parent.setId(10);

        Child child = new Child();
        child.setParent(parent);
        parent.getChildren().add(child);
        child.setValue("old");

        session.save(parent);
        session.getTransaction().commit();

        session.close();
    }

    private static void update() {
        Session session = HibernateUtil.getSessionFactory().openSession();

        session.beginTransaction();

        Parent parent = session.find(Parent.class, 10);

        Child child = new Child();
        child.setParent(parent);
        parent.getChildren().add(child);
        child.setValue("new");

        session.getTransaction().commit();

        session.close();
    }
}