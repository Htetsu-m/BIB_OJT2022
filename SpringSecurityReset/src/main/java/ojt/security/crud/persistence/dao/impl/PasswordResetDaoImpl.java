package ojt.security.crud.persistence.dao.impl;

import javax.transaction.Transactional;

import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import ojt.security.crud.persistence.dao.PasswordResetDao;
import ojt.security.crud.persistence.entity.PasswordReset;

/**
 * <h2>PasswordResetDaoImpl Class</h2>
 * <p>
 * Process for Displaying PasswordResetDaoImpl
 * </p>
 * 
 * @author User
 *
 */
@Repository
@Transactional
public class PasswordResetDaoImpl implements PasswordResetDao {
    /**
     * <h2>sessionFactory</h2>
     * <p>
     * sessionFactory
     * </p>
     */
    @Autowired
    private SessionFactory sessionFactory;

    /**
     * <h2>dbAddToken</h2>
     * <p>
     * 
     * </p>
     * 
     * @param passwordReset
     */
    @Override
    public void dbAddToken(PasswordReset passwordReset) {
        this.sessionFactory.getCurrentSession().saveOrUpdate(passwordReset);
    }

    /**
     * <h2>dbGetPasswordByToken</h2>
     * <p>
     * 
     * </p>
     * 
     * @param token
     * @return
     */
    @SuppressWarnings({ "rawtypes", "deprecation" })
    @Override
    public PasswordReset dbGetPasswordByToken(String token) {
        Query query = this.sessionFactory.getCurrentSession()
                .createQuery("SELECT p FROM PasswordReset p WHERE p.token = :token");
        query.setParameter("token", token);
        return (PasswordReset) query.uniqueResult();
    }

    /**
     * <h2>dbDeleteToken</h2>
     * <p>
     * 
     * </p>
     * 
     * @param token
     */
    @Override
    public void dbDeleteToken(Integer reset_id) {
        PasswordReset passwordReset = this.sessionFactory.getCurrentSession().load(PasswordReset.class, reset_id);
        this.sessionFactory.getCurrentSession().delete(passwordReset);
    }
}