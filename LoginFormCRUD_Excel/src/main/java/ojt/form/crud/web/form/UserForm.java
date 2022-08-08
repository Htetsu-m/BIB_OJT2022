package ojt.form.crud.web.form;

import java.util.Date;

import javax.validation.constraints.NotEmpty;

import ojt.form.crud.persistance.entity.User;

/**
 * <h2> UserForm Class</h2>
 * <p>
 * Process for Displaying UserForm
 * </p>
 * 
 * @author User
 *
 */
public class UserForm {
    private int id;
    @NotEmpty
    private String name;
    private int phone;
    @NotEmpty
    private String email;
    @NotEmpty
    private String password;
    private Date createdAt;
    private Date updatedAt;
    private Date deletedAt;

    /**
     * <h2>getId</h2>
     * <p>
     * Getter Method For Id of User
     * </p>
     *
     * @return
     * @return int
     */

    public int getId() {
        return id;
    }

    /**
     * <h2>setId</h2>
     * <p>
     * 
     * </p>
     *
     * @param id
     * @return void
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * <h2>getName</h2>
     * <p>
     * 
     * </p>
     *
     * @return
     * @return String
     */

    public String getName() {
        return name;
    }

    /**
     * <h2>setName</h2>
     * <p>
     * 
     * </p>
     *
     * @param name
     * @return void
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * <h2>getPhone</h2>
     * <p>
     * 
     * </p>
     *
     * @return
     * @return int
     */

    public int getPhone() {
        return phone;
    }

    /**
     * <h2>setPhone</h2>
     * <p>
     * 
     * </p>
     *
     * @param phone
     * @return void
     */
    public void setPhone(int phone) {
        this.phone = phone;
    }

    /**
     * <h2>getEmail</h2>
     * <p>
     * 
     * </p>
     *
     * @return
     * @return String
     */

    public String getEmail() {
        return email;
    }

    /**
     * <h2>setEmail</h2>
     * <p>
     * 
     * </p>
     *
     * @param email
     * @return void
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * <h2>getCreatedAt</h2>
     * <p>
     * 
     * </p>
     *
     * @return
     * @return Date
     */

    public Date getCreatedAt() {
        return createdAt;
    }

    /**
     * <h2>getPassword</h2>
     * <p>
     * 
     * </p>
     *
     * @return
     * @return String
     */
    public String getPassword() {
        return password;
    }

    /**
     * <h2>setPassword</h2>
     * <p>
     * 
     * </p>
     *
     * @param password
     * @return void
     */
    public void setPassword(String password) {
        this.password = password;
    }

    /**
     * <h2>setCreatedAt</h2>
     * <p>
     * 
     * </p>
     *
     * @param createdAt
     * @return void
     */
    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    /**
     * <h2>getUpdatedAt</h2>
     * <p>
     * 
     * </p>
     *
     * @return
     * @return Date
     */

    public Date getUpdatedAt() {
        return updatedAt;
    }

    /**
     * <h2>setUpdatedAt</h2>
     * <p>
     * 
     * </p>
     *
     * @param updatedAt
     * @return void
     */
    public void setUpdatedAt(Date updatedAt) {
        this.updatedAt = updatedAt;
    }

    /**
     * <h2>getDeletedAt</h2>
     * <p>
     * 
     * </p>
     *
     * @return
     * @return Date
     */

    public Date getDeletedAt() {
        return deletedAt;
    }

    /**
     * <h2>setDeletedAt</h2>
     * <p>
     * 
     * </p>
     *
     * @param deletedAt
     * @return void
     */
    public void setDeletedAt(Date deletedAt) {
        this.deletedAt = deletedAt;
    }

    /**
     * <h2>Constructor for User</h2>
     * <p>
     * Constructor for User
     * </p>
     */
    public UserForm() {
        super();
        // TODO Auto-generated constructor stub
    }

    public UserForm(User user) {
        super();
        this.id = user.getId();
        this.name = user.getName();
        this.phone = user.getPhone();
        this.email = user.getEmail();
        this.password = user.getPassword();
        this.createdAt = user.getCreatedAt();
        this.updatedAt = user.getDeletedAt();
        this.deletedAt = user.getDeletedAt();
    }

}
