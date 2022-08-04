package ojt.form.crud.persistance.entity;

import static javax.persistence.GenerationType.IDENTITY;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import ojt.form.crud.web.form.UserForm;

/**
 * <h2>User Class</h2>
 * <p>
 * Process for Displaying User
 * </p>
 * 
 * @author User
 *
 */
@Entity
@Table(name = "user")
public class User implements Serializable {
    private static final long serialVersionUID = 1L;
    private int id;
    private String name;
    private int phone;
    private String email;
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
    @Id
    @GeneratedValue(strategy = IDENTITY)
    @Column(name = "id")
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
    @Column(name = "name")
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
    @Column(name = "phone_number")
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
    @Column(name = "email")
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
     * <h2>getPassword</h2>
     * <p>
     * 
     * </p>
     *
     * @return
     * @return String
     */
    @Column(name = "password")
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
     * <h2>getCreatedAt</h2>
     * <p>
     * 
     * </p>
     *
     * @return
     * @return Date
     */
    @Column(name = "created_at")
    public Date getCreatedAt() {
        return createdAt;
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
    @Column(name = "updated_at")
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
    @Column(name = "deleted_at")
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
    public User() {
        super();
        // TODO Auto-generated constructor stub
    }

    public User(UserForm userForm) {
        super();
        this.id = userForm.getId();
        this.name = userForm.getName();
        this.phone = userForm.getPhone();
        this.email = userForm.getEmail();
        this.password = userForm.getPassword();
        this.createdAt = userForm.getCreatedAt();
        this.updatedAt = userForm.getDeletedAt();
        this.deletedAt = userForm.getDeletedAt();
    }

}