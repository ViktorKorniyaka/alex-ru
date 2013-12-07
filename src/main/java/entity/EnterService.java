package entity;

import dao.AbstractDAO;
import dao.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: User
 * Date: 04.08.13
 * Time: 16:34
 * To change this template use File | Settings | File Templates.
 */
@Component
public class EnterService extends AbstractDAO<User,Long> {
    int id = -1 ;
   /* @Autowired
    private SessionFactory sessionFactory;*/
    public int autenticate(String login, String password){

           /* Session session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();*/
//!!!!    List<User> us =   AbstractDAO.getSession().createSQLQuery("select * from my_users").addEntity(User.class).list();
//!!!!     List<User> us = sessionFactory.getCurrentSession().createSQLQuery("select * from my_users").addEntity(User.class).list();
            List<User> us =  HibernateUtil.getSession().createSQLQuery("select * from my_users").addEntity(User.class).list();
      //  List<User> us =  getSession().createSQLQuery("select * from my_users").addEntity(User.class).list();
            for(User u: us){
                boolean l =  login.equals(u.getLogin());
                boolean p =  password.equals(u.getPassword());
                System.out.println("bool Login = " + l);
                System.out.println("bool Password = " + p);


                if( l == true ||/*&&*/ p ==true) {
                 id = u.getUserId();
                    System.out.println("id2 = " + id);
                }
            }

        System.out.println("login = " + login);
        System.out.println("password = " + password);

           if(id == -1){
               // если ничено не нашло - подумать как решить перекидываем на страничку enter.jsp
           }

        return id;

    }

    public static void main (String []args){

        Date aDate = new Date();
        SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
        String formattedDate = formatter.format(aDate);
        System.out.println("MM/dd/yyyy- "+formattedDate);
       //-----------------------------------------------------


    }

    @Override
    public List<User> findAll() {
        return null;  //To change body of implemented methods use File | Settings | File Templates.
    }
}
