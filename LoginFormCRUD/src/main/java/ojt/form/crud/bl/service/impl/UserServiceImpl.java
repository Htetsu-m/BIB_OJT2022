package ojt.form.crud.bl.service.impl;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import ojt.form.crud.bl.service.UserService;
import ojt.form.crud.persistance.dao.UserDao;
import ojt.form.crud.persistance.entity.User;
import ojt.form.crud.web.form.UserForm;

@Transactional
@Service
public class UserServiceImpl implements UserService {
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
        // TODO Auto-generated method stub
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
    public void addUser(UserForm userForm) {
        // TODO Auto-generated method stub
        Date currentDate = new Date();
        User user = new User(userForm);
        this.userDao.addUser(user, currentDate);

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
        // TODO Auto-generated method stub
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
    public UserForm getUser(int userID) {
        // TODO Auto-generated method stub
        User resultPost = this.userDao.getUser(userID);
        UserForm resultPostform = resultPost != null ? new UserForm(resultPost) : null;

        return resultPostform;
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
        // TODO Auto-generated method stub
        User updateUser = this.userDao.getUser(userForm.getId());

        updateUser.setName(userForm.getName());
        updateUser.setPhone(userForm.getPhone());

        updateUser.setEmail(userForm.getEmail());
        updateUser.setPassword(userForm.getPassword());
        updateUser.setUpdatedAt(new Date());
        this.userDao.updateUser(updateUser);
    }

}