package service;

import entity.User;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: User
 * Date: 24.09.13
 * Time: 16:53
 * To change this template use File | Settings | File Templates.
 */
public interface UserService {

    public void addUser(User user);
   /* public void add2User(User user);*/
    public List<User> userList();

    public void deleteUser(Long id);

    public User retriveUser(Integer id);
}
