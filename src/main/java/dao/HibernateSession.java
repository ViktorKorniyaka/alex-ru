package dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;


public class HibernateSession {
    /*private */static final ThreadLocal session = new ThreadLocal();
    private static final ThreadLocal transaction = new ThreadLocal();
    private static final SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();



   /* public static Session getSession() {
        Session session = (Session) HibernateSession.session.get();
        if (session == null) {
            session = sessionFactory.openSession();
            HibernateSession.session.set(session);
        }
        return session;
    }*/
    public static Session getSession() {
        System.out.println("session1 - "+session);
        Session session = (Session) HibernateSession.session.get();
        System.out.println("session2 - "+session);
        if (session == null) {
            session = sessionFactory.openSession();
            HibernateSession.session.set(session);
        }  System.out.println("session3 - "+session);
        return session;
    }

   /* public static Session getOldSession(){
          Session ses;
        if (session == null){
            getSession();
        } else {
           ses = HibernateSession.session;
        }return ses;
    }*/

    public void CloseSession(){
        HibernateSession.getSession().close();
    }




}

