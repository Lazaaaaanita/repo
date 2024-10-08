package web.service;

import org.springframework.stereotype.Service;
import web.model.User;

import java.util.List;

public interface UserService {
    List<User> getAllUsers();
    void save(User user);
    void remove(Long id);
    void update(User user);
    User getUserById(Long id);

}
