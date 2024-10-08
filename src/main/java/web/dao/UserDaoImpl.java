package web.dao;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import web.model.User;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.util.List;

@Component
@Transactional
public class UserDaoImpl implements UserDao{
    @PersistenceContext
    private EntityManager entityManager;
    @Override
    public void save(User user) {
        entityManager.persist(user);
    }

    @Override
    @SuppressWarnings("unchecked")
    public List<User> getAllUsers() {
        return entityManager.createQuery("from User",User.class).getResultList();
    }

    @Override
    public void remove(Long id) {
        User user1= getUserById(id);
        if(user1!=null)
    entityManager.remove(user1);
    }

    @Override
    public void update(User user) {
    entityManager.merge(user);
    }

    @Override
    public User getUserById(Long id) {
      return entityManager.find(User.class, id);
    }
}
