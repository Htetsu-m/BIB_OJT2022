package ojt.security.crud.bl.service;

import java.util.List;

import ojt.security.crud.persistence.entity.Authority;
import ojt.security.crud.persistence.entity.User;
import ojt.security.crud.web.form.UserForm;

/**
 * <h2>UserService Class</h2>
 * <p>
 * Process for Displaying UserService
 * </p>
 * 
 * @author User
 *
 */
public interface UserService {
    /**
     * <h2>getUserList</h2>
     * <p>
     * 
     * </p>
     *
     * @return
     * @return List<User>
     */
    public List<User> getUserList();

    public List<Authority> getAuthorityList();

    /**
     * <h2>addUser</h2>
     * <p>
     * 
     * </p>
     *
     * @param userForm
     * @return void
     */
    public void doAddUser(UserForm userForm);

    /**
     * <h2>deleteUser</h2>
     * <p>
     * 
     * </p>
     *
     * @param userId
     * @return void
     */
    public void deleteUser(Integer userId);

    /**
     * <h2>getUser</h2>
     * <p>
     * 
     * </p>
     *
     * @param empid
     * @return
     * @return UserForm
     */
    public UserForm doGetUserById(int id);

    /**
     * <h2>updateUser</h2>
     * <p>
     * 
     * </p>
     *
     * @param userForm
     * @return void
     */
    public void updateUser(UserForm userForm);

    /**
     * <h2>doGetUserByName</h2>
     * <p>
     * 
     * </p>
     *
     * @param name
     * @return
     * @return UserForm
     */
    public UserForm doGetUserByName(String name);

    /**
     * <h2>doGetUserCount</h2>
     * <p>
     * 
     * </p>
     *
     * @return
     * @return long
     */
    public long doGetUserCount();

    public Authority doGetAuthorityById(int authoId);

}