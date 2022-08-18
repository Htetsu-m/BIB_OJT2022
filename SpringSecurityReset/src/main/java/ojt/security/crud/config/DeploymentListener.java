package ojt.security.crud.config;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;

import ojt.security.crud.persistence.dao.AuthorityDao;
import ojt.security.crud.persistence.dao.UserDao;
import ojt.security.crud.persistence.entity.Authority;
import ojt.security.crud.persistence.entity.User;

/**
 * <h2>DeploymentListener Class</h2>
 * <p>
 * Process for Displaying DeploymentListener
 * </p>
 * 
 * @author User
 *
 */
@Component
public class DeploymentListener {
    /**
     * <h2>passwordEncoder</h2>
     * <p>
     * passwordEncoder
     * </p>
     */
    @Autowired
    private BCryptPasswordEncoder passwordEncoder;
    /**
     * <h2>authorityDao</h2>
     * <p>
     * authorityDao
     * </p>
     */
    @Autowired
    private AuthorityDao authorityDao;
    /**
     * <h2>userDao</h2>
     * <p>
     * userDao
     * </p>
     */
    @Autowired
    private UserDao userDao;

    /**
     * <h2>addInitialData</h2>
     * <p>
     * 
     * </p>
     *
     * @return void
     */
    @PostConstruct
    public void addInitialData() {
        if (this.authorityDao.dbGetAuthorityCount() <= 0 && this.userDao.dbGetUserCount() <= 0) {
            List<Authority> adminAuthorities = new ArrayList<Authority>();
            Authority adminAuthority = new Authority(null, "ROLE_ADMIN");
            this.authorityDao.dbSaveAuthority(adminAuthority);
            adminAuthorities.add(adminAuthority);
            User admin = new User(1, "admin", passwordEncoder.encode("123"), "1134", "admin@gmail.com", null,
                    adminAuthorities);
            this.userDao.dbSaveUser(admin);
            for (Authority authority : adminAuthorities) {
                System.out.println(authority.getId());
                System.out.println(authority.getName());
            }

            List<Authority> userAuthorities = new ArrayList<Authority>();
            Authority userAuthority = new Authority(null, "ROLE_USER");
            this.authorityDao.dbSaveAuthority(userAuthority);
            userAuthorities.add(userAuthority);
            User user = new User(2, "user", passwordEncoder.encode("123"), "5678", "user@gmail.com", null,
                    userAuthorities);
            this.userDao.dbSaveUser(user);
        }
    }
}