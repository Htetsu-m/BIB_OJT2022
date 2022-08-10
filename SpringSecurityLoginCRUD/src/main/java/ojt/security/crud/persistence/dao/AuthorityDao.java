package ojt.security.crud.persistence.dao;

import ojt.security.crud.persistence.entity.Authority;

public interface AuthorityDao {
    public void dbSaveAuthority(Authority authority);

    public long dbGetAuthorityCount();
}
