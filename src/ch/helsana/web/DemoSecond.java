package ch.helsana.web;

import ch.helsana.web.hib.entities.Books;
import ch.helsana.web.hib.init.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import java.util.List;

/**
 * Created by hkfq4 on 07.02.2017.
 */
public class DemoSecond {

    public static void main(String[] args) {

        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        Session session = sessionFactory.openSession();

        List<Books> books = session.createQuery("from Books ").list();

        session.close();

        for (Books st : books) {
            System.out.println(st.getId() + " / " + st.getIsbn() + " / " + st.getTitle() + " / " + st.getYear());
        }
    }
}
