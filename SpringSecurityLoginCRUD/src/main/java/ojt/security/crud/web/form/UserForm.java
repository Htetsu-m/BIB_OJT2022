package ojt.security.crud.web.form;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.validation.constraints.NotEmpty;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import ojt.security.crud.persistence.entity.Authority;
import ojt.security.crud.persistence.entity.User;

/**
 * <h2> UserForm Class</h2>
 * <p>
 * Process for Displaying UserForm
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
 * <h2> getPassword</h2>
 * <p>
 * 
 * </p>
 *
 * @return
 * @return String
 */
/**
 * <h2> getAuthorities</h2>
 * <p>
 * 
 * </p>
 *
 * @return
 * @return List<Authority>
 */
/**
 * <h2>getAuthority</h2>
 * <p>
 * 
 * </p>
 *
 * @return
 * @return Authority
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
 * <h2>setPassword</h2>
 * <p>
 * 
 * </p>
 *
 * @param password
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
/**
 * <h2>setAuthority</h2>
 * <p>
 * 
 * </p>
 *
 * @param authority
 * @return void
 */
@Setter
/**
 * <h2>Constructor for UserForm</h2>
 * <p>
 * Constructor for UserForm
 * </p>
 */
@NoArgsConstructor
/**
 * <h2>Constructor for UserForm</h2>
 * <p>
 * Constructor for UserForm
 * </p>
 * 
 * @param id
 * @param username
 * @param phone
 * @param email
 * @param password
 * @param authorities
 * @param authority
 */
@AllArgsConstructor
public class UserForm {
    /**
     * <h2>id</h2>
     * <p>
     * id
     * </p>
     */
    private int id;
    /**
     * <h2>username</h2>
     * <p>
     * username
     * </p>
     */
    @NotEmpty
    private String username;
    /**
     * <h2>phone</h2>
     * <p>
     * phone
     * </p>
     */
    @NotEmpty
    private String phone;
    /**
     * <h2>email</h2>
     * <p>
     * email
     * </p>
     */
    @NotEmpty
    private String email;
    /**
     * <h2>password</h2>
     * <p>
     * password
     * </p>
     */
    @NotEmpty
    private String password;
    /**
     * <h2> deletedAt</h2>
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
    private List<Authority> authorities = new ArrayList<Authority>();
    /**
     * <h2>authority</h2>
     * <p>
     * authority
     * </p>
     */
    private Authority authority;

    /**
     * <h2>Constructor for UserForm</h2>
     * <p>
     * Constructor for UserForm
     * </p>
     * 
     * @param user
     */
    public UserForm(User user) {
        super();
        this.id = user.getId();
        this.username = user.getUsername();
        this.phone = user.getPhone();
        this.email = user.getEmail();
        this.password = user.getPassword();
        this.authorities = user.getAuthorities();
        this.deletedAt=user.getDeletedAt();
    }
}