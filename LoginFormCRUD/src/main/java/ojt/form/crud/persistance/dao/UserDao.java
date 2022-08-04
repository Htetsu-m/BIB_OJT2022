package ojt.form.crud.persistance.dao;

import java.util.Date;
import java.util.List;

import ojt.form.crud.persistance.entity.User;

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
    public List<User> getUserList();

    /**
     * <h2>addUser</h2>
     * <p>
     * 
     * </p>
     *
     * @param userForm
     * @return void
     */
    public void addUser(User user, Date currentDate);

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
    public User getUser(int userId);

    /**
     * <h2>updateUser</h2>
     * <p>
     * 
     * </p>
     *
     * @param userForm
     * @return void
     */
    public void updateUser(User user);

}