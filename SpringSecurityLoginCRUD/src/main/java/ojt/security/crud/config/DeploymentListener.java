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

@Component
public class DeploymentListener {
    @Autowired
    private BCryptPasswordEncoder passwordEncoder;
    @Autowired
    private AuthorityDao authorityDao;
    @Autowired
    private UserDao userDao;

    @PostConstruct
    public void addInitialData() {
        if (this.authorityDao.dbGetAuthorityCount() <= 0 && this.userDao.dbGetUserCount() <= 0) {
            List<Authority> adminAuthorities = new ArrayList<Authority>();
            Authority adminAuthority = new Authority(null, "ROLE_ADMIN");
            this.authorityDao.dbSaveAuthority(adminAuthority);
            User admin = new User(1, "admin", passwordEncoder.encode("123"),"1134","admin@gmail.com", adminAuthorities);
            this.userDao.dbSaveUser(admin);

            List<Authority> userAuthorities = new ArrayList<Authority>();
            Authority userAuthority = new Authority(null, "ROLE_USER");
            this.authorityDao.dbSaveAuthority(userAuthority);
            userAuthorities.add(userAuthority);
            User user = new User(2, "user", passwordEncoder.encode("123"),"5678","user@gmail.com", adminAuthorities);
            this.userDao.dbSaveUser(user);
        }
    }
}
