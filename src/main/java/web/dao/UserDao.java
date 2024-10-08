package web.dao;

import web.model.User;

import java.util.List;

public interface UserDao {
    List<User> getAllUsers();
    void save(User user);
    void remove(Long id);
    void update(User user);
    User getUserById(Long id);

}
