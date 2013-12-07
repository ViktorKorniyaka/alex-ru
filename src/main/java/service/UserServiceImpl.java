package service;

import dao.UserDAO;
import dao.UserDAOImpl;
import entity.User;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: User
 * Date: 24.09.13
 * Time: 16:55
 * To change this template use File | Settings | File Templates.
 */
@Service
public class UserServiceImpl implements UserService {
                                  // c нами рабоает  Controller
                                  // а мы обращаемся в базу через UserDAO
                                  //в получаем данные введенные в форму
  // @Autowired  /*(required=false) @Resource*/
  /*  private*/ UserDAO userDAO /*= new UserDAOImpl()*/;         // к

   /* @Override
    public void add2User(User user) {
        userDAO.add2User(user);              //NullPointerException
        //  userDAO.add2User(user);
    }*/

    @Override
    public void addUser(User user) {
        userDAO.addUser(user);
      //  userDAO.add2User(user);
    }

    @Override
    public List<User> userList() {
        return userDAO.userList();

    }

    @Override
    public void deleteUser(Long id) {
        userDAO.deleteUser(id);

    }

    @Override
    public User retriveUser(Integer id) {

        return userDAO.retriveUser(id);

    }
}
