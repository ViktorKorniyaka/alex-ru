package dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.context.internal.ThreadLocalSessionContext;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;
import java.lang.ThreadLocal;

public class HibernateUtil {
  // private static Session session;
  // private static ThreadLocalSessionContext threadLocalSession;
 // private   static          Session sessionHb = HibernateUtil.sessionFactory.openSession();
    private static final ThreadLocal<Session> sessionThreadLocal =  new ThreadLocal<Session>(){
        @Override
        protected Session initialValue() {
            Session session = HibernateUtil.sessionFactory.openSession();
           // session.beginTransaction();   // org.hibernate.TransactionException: nested transactions not supported
            return session;
        }
    };


    private static final SessionFactory sessionFactory = buildSessionFactory();
    private static ServiceRegistry serviceRegistry;

    private static SessionFactory buildSessionFactory() {
        try {
            // Создает сессию с hibernate.cfg.xml
            Configuration configuration = new Configuration();
            configuration.configure();
            serviceRegistry = new ServiceRegistryBuilder().applySettings(configuration.getProperties()).buildServiceRegistry();

            return configuration.buildSessionFactory(serviceRegistry);
        }
        catch (Throwable ex) {
            System.err.println("Initial SessionFactory creation failed." + ex);
            throw new ExceptionInInitializerError(ex);
        }
    }

    public static SessionFactory getSessionFactory() {
        return sessionFactory;
    }

    public static void shutdown() {
        // Чистит кеш и закрывает соединение с БД
        getSessionFactory().close();
    }


//------------------ *** новое дополнение *** -----------------------------

    public static Session getSession() {
        Session sessionHib = sessionThreadLocal.get();


        return sessionHib;
        }



     public static void saveSession (Object obg){
      //  sessionThreadLocal.get().beginTransaction();
        // session.beginTransaction();
         sessionThreadLocal.get().beginTransaction();
         sessionThreadLocal.get().saveOrUpdate(obg);
       //  sessionThreadLocal.get().save(obg);                // если       //    HibernateUtil.saveSession(client);
                                              //ERROE two session         //      HibernateUtil.saveSession(user);
         sessionThreadLocal.get().getTransaction().commit();
        // session.save(obg);
       //  session.getTransaction().commit();

     }
    public static void beginTransaction (){
        sessionThreadLocal.get().beginTransaction();
    }
    public static void commitTransaction (){
        sessionThreadLocal.get().getTransaction().commit();
    }

    public static void saveSession (Object product ,Object client, Object user){
        if(sessionThreadLocal.get()== null) {
            System.out.println("sessionThreadLocal.get()== null - "+sessionThreadLocal.get());
        }
        System.out.println("sessionThreadLocal.get() - "+sessionThreadLocal.get());
        sessionThreadLocal.get().beginTransaction();
        // session.beginTransaction();
        sessionThreadLocal.get().save(product);
        sessionThreadLocal.get().save(client);
        sessionThreadLocal.get().save(user);           // если сохранять два раза подряд тут ошибуа  with two open sessions
        sessionThreadLocal.get().getTransaction().commit();
        // session.save(obg);
        //  session.getTransaction().commit();
        //sessionThreadLocal.get().close();

    }
    public static void saveSession (Object obj1 ,Object obj2){
        if(sessionThreadLocal.get()== null) {
            System.out.println("sessionThreadLocal.get()== null - "+sessionThreadLocal.get());
        }
        System.out.println("sessionThreadLocal.get() - "+sessionThreadLocal.get());
        sessionThreadLocal.get().beginTransaction();
        // session.beginTransaction();
        sessionThreadLocal.get().save(obj1);
        sessionThreadLocal.get().save(obj2); // если сохранять два раза подряд тут ошибуа  with two open sessions

        sessionThreadLocal.get().getTransaction().commit();


    }





    public void сloseSession(){
        HibernateUtil.getSession().close();
    }
}

