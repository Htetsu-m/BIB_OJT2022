package ojt.security.crud.persistence.dao.impl;

import java.util.List;

import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import ojt.security.crud.persistence.dao.AuthorityDao;
import ojt.security.crud.persistence.entity.Authority;

/**
 * <h2>AuthorityDaoImpl Class</h2>
 * <p>
 * Process for Displaying AuthorityDaoImpl
 * </p>
 * 
 * @author User
 *
 */
@Repository
@Transactional
public class AuthorityDaoImpl implements AuthorityDao {
    /**
     * <h2>sessionFactory</h2>
     * <p>
     * sessionFactory
     * </p>
     */
    @Autowired
    private SessionFactory sessionFactory;

    /**
     * <h2>dbSaveAuthority</h2>
     * <p>
     * 
     * </p>
     * 
     * @param authority
     */
    @Override
    public void dbSaveAuthority(Authority authority) {
        this.sessionFactory.getCurrentSession().save(authority);
    }

    /**
     * <h2>dbGetAuthorityCount</h2>
     * <p>
     * 
     * </p>
     * 
     * @return
     */
    @SuppressWarnings("rawtypes")
    @Override
    public long dbGetAuthorityCount() {
        Query query = this.sessionFactory.getCurrentSession().createQuery("SELECT COUNT(a) FROM Authority a");
        return (long) query.getSingleResult();
    }

    /**
     * <h2>dbGetAuthorityList</h2>
     * <p>
     * 
     * </p>
     * 
     * @return
     */
    @Override
    public List<Authority> dbGetAuthorityList() {
        return this.sessionFactory.getCurrentSession().createQuery("from Authority").list();
    }

    @Override
    public Authority dbGetAuthorityById(int id) {
        Query query = this.sessionFactory.getCurrentSession().createQuery("SELECT a FROM Authority a WHERE a.id = :id");
        query.setParameter("id",id);
        Authority resultRole = (Authority) query.uniqueResult();
        return resultRole;
    }
}