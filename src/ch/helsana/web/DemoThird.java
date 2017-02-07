package ch.helsana.web;

import ch.helsana.web.hib.entities.Books;
import ch.helsana.web.hib.init.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

/**
 * Created by hkfq4 on 07.02.2017.
 */
public class DemoThird {

    public static void main(String[] args) {

        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        Session session = sessionFactory.openSession();
        session.beginTransaction();

        Books book = (Books) session.get(Books.class, 3);
        book.setIsbn("N 123456");
        book.setTitle("NEU Der zame Hai.");
        book.setYear(2018);

        session.update(book);
        session.getTransaction().commit();

        session.close();

    }
}
