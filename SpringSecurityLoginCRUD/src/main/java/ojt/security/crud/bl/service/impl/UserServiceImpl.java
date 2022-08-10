package ojt.security.crud.bl.service.impl;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import ojt.security.crud.bl.dto.CustomUserDetail;
import ojt.security.crud.bl.service.UserService;
import ojt.security.crud.persistence.dao.UserDao;
import ojt.security.crud.persistence.entity.User;
import ojt.security.crud.web.form.UserForm;

/**
 * <h2> UserServiceImpl Class</h2>
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
     * <h2>getUserList</h2>
     * <p>
     * 
     * </p>
     * 
     * @return
     */
    @Override
    @Transactional
    public List<User> getUserList() {
        return userDao.getUserList();
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
    @Transactional
    public void doAddUser(UserForm userForm) {
        Date currentDate = new Date();
        User user = new User(userForm);
        this.userDao.dbAddUser(user, currentDate);

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
        userDao.deleteUser(userId);
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
     * <h2> doGetUserByName </h2>
     * <p>
     * 
     * </p>
     * 
     * @param username
     * @return
     */
    @Override
    public UserForm doGetUserByName(String username) {
        User result=this.userDao.dbGetUserByName(username);
        UserForm resultform=result != null ? new UserForm(result) : null;
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
    public void updateUser(UserForm userForm) {
        User updateUser = this.userDao.dbGetUserById(userForm.getId());
        updateUser.setUsername(userForm.getUsername());
        //updateUser.setPhone(userForm.getPhone());
        //updateUser.setEmail(userForm.getEmail());
        this.userDao.updateUser(updateUser);
    }

    @Override
    public long doGetUserCount() { 
        return this.userDao.dbGetUserCount();
    }

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
}