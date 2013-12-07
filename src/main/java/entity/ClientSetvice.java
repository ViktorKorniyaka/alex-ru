package entity;

import dao.HibernateSession;
import org.hibernate.Session;

/**
 * Created with IntelliJ IDEA.
 * User: User
 * Date: 06.09.13
 * Time: 19:54
 * To change this template use File | Settings | File Templates.
 */
public class ClientSetvice {

    public int getIdClientFromDb(){
        Session session = HibernateSession.getSession();  //  new session whis threadLocal
        session.beginTransaction();




        return 1;
    }
}
