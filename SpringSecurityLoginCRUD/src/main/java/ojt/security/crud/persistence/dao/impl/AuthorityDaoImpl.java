package ojt.security.crud.persistence.dao.impl;

import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;

import ojt.security.crud.persistence.dao.AuthorityDao;
import ojt.security.crud.persistence.entity.Authority;

public class AuthorityDaoImpl implements AuthorityDao {
    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public void dbSaveAuthority(Authority authority) {
        this.sessionFactory.getCurrentSession().save(authority);
    }

    @SuppressWarnings("rawtypes")
    @Override
    public long dbGetAuthorityCount() {
        Query query = this.sessionFactory.getCurrentSession().createQuery("SELECT COUNT(a) FROM Authority a");
        return (long) query.getSingleResult();
    }

}
