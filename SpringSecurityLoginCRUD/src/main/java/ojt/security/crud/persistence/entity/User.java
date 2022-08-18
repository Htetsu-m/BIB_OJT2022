package ojt.security.crud.persistence.entity;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import ojt.security.crud.web.form.UserForm;

/**
 * <h2> User Class</h2>
 * <p>
 * Process for Displaying User
 * </p>
 * 
 * @author User
 *
 */
/**
 * <h2> getId</h2>
 * <p>
 * 
 * </p>
 *
 * @return
 * @return int
 */
/**
 * <h2> getUsername</h2>
 * <p>
 * 
 * </p>
 *
 * @return
 * @return String
 */
/**
 * <h2> getPassword</h2>
 * <p>
 * 
 * </p>
 *
 * @return
 * @return String
 */
/**
 * <h2> getPhone</h2>
 * <p>
 * 
 * </p>
 *
 * @return
 * @return String
 */
/**
 * <h2> getEmail</h2>
 * <p>
 * 
 * </p>
 *
 * @return
 * @return String
 */
/**
 * <h2>getAuthorities</h2>
 * <p>
 * 
 * </p>
 *
 * @return
 * @return List<Authority>
 */
@Getter
/**
 * <h2>setId</h2>
 * <p>
 * 
 * </p>
 *
 * @param id
 * @return void
 */
/**
 * <h2>setUsername</h2>
 * <p>
 * 
 * </p>
 *
 * @param username
 * @return void
 */
/**
 * <h2>setPassword</h2>
 * <p>
 * 
 * </p>
 *
 * @param password
 * @return void
 */
/**
 * <h2>setPhone</h2>
 * <p>
 * 
 * </p>
 *
 * @param phone
 * @return void
 */
/**
 * <h2>setEmail</h2>
 * <p>
 * 
 * </p>
 *
 * @param email
 * @return void
 */
/**
 * <h2>setAuthorities</h2>
 * <p>
 * 
 * </p>
 *
 * @param authorities
 * @return void
 */
@Setter
/**
 * <h2>Constructor for User</h2>
 * <p>
 * Constructor for User
 * </p>
 */
@NoArgsConstructor
/**
 * <h2>Constructor for User</h2>
 * <p>
 * Constructor for User
 * </p>
 * 
 * @param id
 * @param username
 * @param password
 * @param phone
 * @param email
 * @param authorities
 */
@AllArgsConstructor
@Entity
@Table(name = "users")
public class User {
    /**
     * <h2>id</h2>
     * <p>
     * id
     * </p>
     */
    @Id
    @Column(name = "user_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    /**
     * <h2>username</h2>
     * <p>
     * username
     * </p>
     */
    private String username;
    /**
     * <h2>password</h2>
     * <p>
     * password
     * </p>
     */
    private String password;
    /**
     * <h2>phone</h2>
     * <p>
     * phone
     * </p>
     */
    private String phone;
    /**
     * <h2>email</h2>
     * <p>
     * email
     * </p>
     */
    private String email;
    /**
     * <h2>deletedAt</h2>
     * <p>
     * deletedAt
     * </p>
     */
    private Date deletedAt;
    /**
     * <h2>authorities</h2>
     * <p>
     * authorities
     * </p>
     */
    @ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinTable(name = "users_authorities", joinColumns = @JoinColumn(name = "user_id"), inverseJoinColumns = @JoinColumn(name = "authority_id"))
    private List<Authority> authorities = new ArrayList<Authority>();

    /**
     * <h2>Constructor for User</h2>
     * <p>
     * Constructor for User
     * </p>
     * 
     * @param userForm
     */
    public User(UserForm userForm) {
        super();
        this.id = userForm.getId();
        this.username = userForm.getUsername();
        this.phone = userForm.getPhone();
        this.email = userForm.getEmail();
        this.password = userForm.getPassword();
        this.authorities = userForm.getAuthorities();
        this.deletedAt = userForm.getDeletedAt();
    }
}