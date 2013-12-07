package dao;

import entity.User;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: User
 * Date: 24.09.13
 * Time: 15:49
 * To change this template use File | Settings | File Templates.
 */
@Repository
public class UserDAOImpl extends AbstractDAO<User, Long> implements UserDAO {

 /*   @Autowired
    private SessionFactory sessionFactory;*/

    @Override
    public void deleteUser(Long id) {
        //To change body of implemented methods use File | Settings | File Templates.

    }
   /* public void add2User(User user)  {
    sessionFactory.getCurrentSession().saveOrUpdate(user);
    }*/
    @Override
    public void addUser(User user)  {
      //  sessionFactory.getCurrentSession().beginTransaction();
        //--------------------------------------------
       /* Session session = sessionFactory.openSession();
        session.beginTransaction();
        //to do something
        session.save(user);*/
 //       Session session = HibernateUtil.getSession();  //   session whis threadLocal

       HibernateUtil.getSession();                                              //      session whis threadLocal
//        session.beginTransaction();
        HibernateUtil.saveSession(user);

//        session.save(user);
//        session.getTransaction().commit();
       /* Session session2 = sessionFactory.getCurrentSession();
        session2.save(user);*/

       // sessionFactory.getCurrentSession().createQuery(...);

       // sessionFactory.getCurrentSession().getTransaction().commit();

        //sessionFactory.getCurrentSession().saveOrUpdate(user);

        //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public List<User> userList() {
        return null;  //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public User retriveUser(Integer id) {      // вызвать юзера
        User user = (User) HibernateUtil.getSession().get(User.class,id);
        return user;
    }

    @Override
    public void editUser(Long id) {
        //To change body of implemented methods use File | Settings | File Templates.
    }
  //------------------------------------------
    @Override
    public List<User> findAll() {
        return null;  //To change body of implemented methods use File | Settings | File Templates.
    }
}
