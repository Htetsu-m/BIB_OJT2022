package ojt.security.crud.bl.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import ojt.security.crud.bl.dto.CustomUserDetail;
import ojt.security.crud.bl.service.UserService;
import ojt.security.crud.persistence.dao.AuthorityDao;
import ojt.security.crud.persistence.dao.UserDao;
import ojt.security.crud.persistence.entity.Authority;
import ojt.security.crud.persistence.entity.User;
import ojt.security.crud.web.form.UserForm;

/**
 * <h2>UserServiceImpl Class</h2>
 * <p>
 * Process for Displaying UserServiceImpl
 * </p>
 * 
 * @author User
 *
 */
@Transactional
@Service
public class UserServiceImpl implements UserService, UserDetailsService {
    /**
     * <h2>userDao</h2>
     * <p>
     * userDao
     * </p>
     */
    @Autowired
    private UserDao userDao;
    /**
     * <h2>authorityDao</h2>
     * <p>
     * authorityDao
     * </p>
     */
    @Autowired
    private AuthorityDao authorityDao;

    /**
     * <h2>getUserList</h2>
     * <p>
     * 
     * </p>
     * 
     * @return
     */
    @Override
    @Transactional
    public List<User> doGetUserList() {
        return userDao.dbGetUserList();
    }

    /**
     * <h2>getAuthorityList</h2>
     * <p>
     * 
     * </p>
     * 
     * @return
     */
    @Override
    @Transactional
    public List<Authority> doGetAuthorityList() {
        return authorityDao.dbGetAuthorityList();
    }

    /**
     * <h2>addUser</h2>
     * <p>
     * 
     * </p>
     * 
     * @param userForm
     */
    @Override
    public void doAddUser(UserForm userForm) {
        User user = new User(userForm);
        List<Authority> authorities = new ArrayList<Authority>();
        System.out.println(user.getAuthorities());
        this.userDao.dbAddUser(user);
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
    @Transactional
    public void deleteUser(Integer userId) {
        userDao.dbDeleteUser(userId);
    }

    /**
     * <h2>getUser</h2>
     * <p>
     * 
     * </p>
     * 
     * @param userID
     * @return
     */
    @Override
    public UserForm doGetUserById(int userID) {
        User resultPost = this.userDao.dbGetUserById(userID);
        UserForm resultPostform = resultPost != null ? new UserForm(resultPost) : null;
        return resultPostform;
    }

    /**
     * <h2>doGetUserByName</h2>
     * <p>
     * 
     * </p>
     * 
     * @param username
     * @return
     */
    @Override
    public UserForm doGetUserByName(String username) {
        User result = this.userDao.dbGetUserByName(username);
        UserForm resultform = result != null ? new UserForm(result) : null;
        return resultform;
    }

    /**
     * <h2>updateUser</h2>
     * <p>
     * 
     * </p>
     * 
     * @param userForm
     */
    @Override
    public void doUpdateUser(UserForm userForm) {
        User updateUser = this.userDao.dbGetUserById(userForm.getId());
        updateUser.setUsername(userForm.getUsername());
        updateUser.setPhone(userForm.getPhone());
        updateUser.setEmail(userForm.getEmail());
        updateUser.setPassword(userForm.getPassword());

        List<Authority> authoList = new ArrayList<Authority>();
        Authority authoId = authorityDao.dbGetAuthorityById(userForm.getAuthority().getId());
        authoList.add(authoId);
        updateUser.setAuthorities(authoList);
        this.userDao.dbUpdateUser(updateUser);

        // updateUser.setAuthorities(userForm.getAuthority());
        // updateUser.setAuthorities(userForm.getAuthorities());
        // updateUser.setAuthorities((List<Authority>) userForm.getAuthority());
        // this.userDao.updateUser(updateUser);
        // Authority updateRole =
        // this.authorityDao.dbGetAuthorityById(userForm.getId());
        // updateRole.setName(userForm.getAuthority());
        // this.userDao.updateUser(updateRole);

    }

    /**
     * <h2>doGetUserCount</h2>
     * <p>
     * 
     * </p>
     * 
     * @return
     */
    @Override
    public long doGetUserCount() {
        return this.userDao.dbGetUserCount();
    }

    /**
     * <h2>loadUserByUsername</h2>
     * <p>
     * 
     * </p>
     * 
     * @param username
     * @return
     * @throws UsernameNotFoundException
     */
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User userInfo = this.userDao.dbGetUserByName(username);
        if (userInfo == null) {
            throw new UsernameNotFoundException("Invalid Username or Password!");
        }
        UserDetails user = new CustomUserDetail(userInfo.getUsername(), userInfo.getPassword(),
                userInfo.getAuthorities());
        return user;
    }

    @Override
    public Authority doGetAuthorityById(int authoId) {
        return this.authorityDao.dbGetAuthorityById(authoId);

    }
}