package ojt.security.crud.persistence.dao.impl;

import java.util.Date;
import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import ojt.security.crud.persistence.dao.UserDao;
import ojt.security.crud.persistence.entity.User;

/**
 * <h2>UserDaoImpl Class</h2>
 * <p>
 * Process for Displaying UserDaoImpl
 * </p>
 * 
 * @author User
 *
 */
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
    @Override
    public List<User> dbGetUserList() {
        return sessionFactory.getCurrentSession().createQuery("select u from User u where deletedAt is null").list();
    }

    /**
     * <h2>dbAddUser</h2>
     * <p>
     * 
     * </p>
     * 
     * @param user
     */
    @Override
    public void dbAddUser(User user) {
        sessionFactory.getCurrentSession().saveOrUpdate(user);
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

    /**
     * <h2>dbGetUserById</h2>
     * <p>
     * 
     * </p>
     * 
     * @param userId
     * @return
     */
    @SuppressWarnings({ "deprecation", "rawtypes" })
    @Override
    public User dbGetUserById(int userId) {
        System.out.println(userId);
        String userHqlQuery = "SELECT u FROM User u where u.id = :id";
        Query queryUserById = this.sessionFactory.getCurrentSession().createQuery(userHqlQuery);
        queryUserById.setParameter("id", userId);
        User resultUser = (User) queryUserById.uniqueResult();
        return resultUser;
    }

    /**
     * <h2>dbGetUserByName</h2>
     * <p>
     * 
     * </p>
     * 
     * @param username
     * @return
     */
    @SuppressWarnings({ "rawtypes", "deprecation" })
    @Override
    public User dbGetUserByName(String username) {
        Query query = this.sessionFactory.getCurrentSession()
                .createQuery("SELECT u FROM User u WHERE u.username = :username");
        query.setParameter("username", username);
        return (User) query.uniqueResult();
    }

    /**
     * <h2>dbGetUserCount</h2>
     * <p>
     * 
     * </p>
     * 
     * @return
     */
    @SuppressWarnings({ "deprecation", "rawtypes" })
    @Override
    public long dbGetUserCount() {
        Query query = this.sessionFactory.getCurrentSession().createQuery("SELECT COUNT(u) FROM User u");
        return (long) query.getSingleResult();
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
    public void dbDeleteUser(Integer userId, Date currentDate) {
        User user = (User) sessionFactory.getCurrentSession().load(User.class, userId);
        if (null != user) {
            user.setDeletedAt(new Date());
            this.sessionFactory.getCurrentSession().update(user);
        }
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
    public void dbUpdateUser(User user) {
        this.sessionFactory.getCurrentSession().update(user);
    }

    /**
     * <h2>dbGetFindByEmail</h2>
     * <p>
     * 
     * </p>
     * 
     * @param email
     * @return
     */
    @SuppressWarnings({ "rawtypes", "deprecation" })
    @Override
    public User dbGetFindByEmail(String email) {
        Query query = this.sessionFactory.getCurrentSession()
                .createQuery("SELECT u FROM User u WHERE u.email = :email");
        query.setParameter("email", email);
        return (User) query.uniqueResult();
    }

    /**
     * <h2>dbUpdateUserPassword</h2>
     * <p>
     * 
     * </p>
     * 
     * @param user
     */
    @Override
    public void dbUpdateUserPassword(User user) {
        this.sessionFactory.getCurrentSession().update(user);
    }
}