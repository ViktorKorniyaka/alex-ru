package dao;

import entity.User;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: User
 * Date: 24.09.13
 * Time: 15:46
 * To change this template use File | Settings | File Templates.
 */
public interface UserDAO extends BaseDAO<User,Long> {

    public void addUser(User user);
    /*public void add2User(User user);*/
    public List<User> userList();

    public void deleteUser(Long id);
    public void editUser(Long id);
    public User retriveUser(Integer id);
}
