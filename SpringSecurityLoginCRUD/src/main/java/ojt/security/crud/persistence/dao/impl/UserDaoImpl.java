package ojt.security.crud.persistence.dao.impl;

import java.util.Date;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import ojt.security.crud.persistence.dao.UserDao;
import ojt.security.crud.persistence.entity.User;

@Repository
@Transactional
public class UserDaoImpl implements UserDao {
    /**
     * <h2>sessionFactory</h2>
     * <p>
     * sessionFactory
     * </p>
     */
    @Autowired
    private SessionFactory sessionFactory;

    /**
     * <h2>getUserList</h2>
     * <p>
     * 
     * </p>
     * 
     * @return
     */
    @SuppressWarnings("unchecked")
    public List<User> getUserList() {
        return sessionFactory.getCurrentSession().createQuery("from User").list();
    }

    /**
     * <h2>addUser</h2>
     * <p>
     * 
     * </p>
     * 
     * @param user
     * @param currentDate
     */
    @Override
    public void dbAddUser(User user, Date currentDate) {
        sessionFactory.getCurrentSession().saveOrUpdate(user);
    }

    /**
     * <h2>deleteUser</h2>
     * <p>
     * 
     * </p>
     * 
     * @param userId
     */
    @Override
    public void deleteUser(Integer userId) {
        User user = (User) sessionFactory.getCurrentSession().load(User.class, userId);
        if (null != user) {
            this.sessionFactory.getCurrentSession().delete(user);
        }
    }

    /**
     * <h2>getUser</h2>
     * <p>
     * 
     * </p>
     * 
     * @param userId
     * @return
     */
    @SuppressWarnings("deprecation")
    @Override
    public User dbGetUserById(int userId) {
        System.out.println(userId);
        String userHqlQuery = "SELECT u FROM User u where u.id = :id";
        Query queryUserById = this.sessionFactory.getCurrentSession().createQuery(userHqlQuery);
        queryUserById.setParameter("id", userId);
        User resultUser = (User) queryUserById.uniqueResult();
        return resultUser;

    }
  //@SuppressWarnings("rawtypes")
    /**
     * <h2> dbGetUserByName </h2>
     * <p>
     * 
     * </p>
     * 
     * @param username
     * @return
     */
    @Override
    public User dbGetUserByName(String username) {
        Query queryUserByName = this.sessionFactory.getCurrentSession().createQuery("SELECT u FROM User u WHERE u.username = :username");
        queryUserByName.setParameter("username", username);
        return (User) queryUserByName.uniqueResult();
    }
    /**
     * <h2>updateUser</h2>
     * <p>
     * 
     * </p>
     * 
     * @param user
     */
    @Override
    public void updateUser(User user) {
        this.sessionFactory.getCurrentSession().update(user);
    }

    /**
     * <h2>dbGetUserCount</h2>
     * <p>
     * 
     * </p>
     * 
     * @return
     */
    @Override
    public long dbGetUserCount() {
        Query query = this.sessionFactory.getCurrentSession().createQuery("SELECT COUNT(u) FROM User u");
        return (long) query.getSingleResult();
    }
    /**
     * <h2>dbSaveUser</h2>
     * <p>
     * 
     * </p>
     * 
     * @param user
     */
    @Override
    public void dbSaveUser(User user) {
        this.sessionFactory.getCurrentSession().save(user);

    }

}