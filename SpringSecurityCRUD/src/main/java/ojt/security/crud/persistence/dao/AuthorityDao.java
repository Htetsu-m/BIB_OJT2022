package ojt.security.crud.persistence.dao;

import java.util.List;

import ojt.security.crud.persistence.entity.Authority;
import ojt.security.crud.persistence.entity.User;

public interface AuthorityDao {
    /**
     * <h2>dbSaveAuthority</h2>
     * <p>
     * 
     * </p>
     *
     * @param authority
     * @return void
     */
    public void dbSaveAuthority(Authority authority);

    /**
     * <h2>dbGetAuthorityList</h2>
     * <p>
     * 
     * </p>
     *
     * @return
     * @return List<Authority>
     */
    public List<Authority> dbGetAuthorityList();

    /**
     * <h2>dbGetAuthorityCount</h2>
     * <p>
     * 
     * </p>
     *
     * @return
     * @return long
     */
    public long dbGetAuthorityCount();
    public Authority dbGetAuthorityById(int authoId);
}