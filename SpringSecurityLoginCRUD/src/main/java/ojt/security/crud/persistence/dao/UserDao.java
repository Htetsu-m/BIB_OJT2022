package ojt.security.crud.persistence.dao;

import java.util.List;

import ojt.security.crud.persistence.entity.User;

public interface UserDao {
    /**
     * <h2>getUserList</h2>
     * <p>
     * 
     * </p>
     *
     * @return
     * @return List<User>
     */
    public List<User> dbGetUserList();

    /**
     * <h2>addUser</h2>
     * <p>
     * 
     * </p>
     *
     * @param userForm
     * @return void
     */
    public void dbAddUser(User user);

    /**
     * <h2>deleteUser</h2>
     * <p>
     * 
     * </p>
     *
     * @param userId
     * @return void
     */
    public void dbDeleteUser(Integer userId);

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
    public User dbGetUserById(int userId);

    /**
     * <h2>updateUser</h2>
     * <p>
     * 
     * </p>
     *
     * @param userForm
     * @return void
     */
    public void dbUpdateUser(User user);

    /**
     * <h2>dbSaveUser</h2>
     * <p>
     * 
     * </p>
     *
     * @param user
     * @return void
     */
    public void dbSaveUser(User user);

    /**
     * <h2>dbGetUserCount</h2>
     * <p>
     * 
     * </p>
     *
     * @return
     * @return long
     */
    public long dbGetUserCount();

    /**
     * <h2>dbGetUserByName</h2>
     * <p>
     * 
     * </p>
     *
     * @param username
     * @return
     * @return User
     */
    public User dbGetUserByName(String username);
}