package ojt.security.crud.web.form;

import java.util.Date;

import javax.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import ojt.security.crud.persistence.entity.PasswordReset;
import ojt.security.crud.persistence.entity.User;
/**
 * <h2> PasswordResetForm Class</h2>
 * <p>
 * Process for Displaying PasswordResetForm
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
 * @return Long
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
 * <h2> getToken</h2>
 * <p>
 * 
 * </p>
 *
 * @return
 * @return String
 */
/**
 * <h2> getUser</h2>
 * <p>
 * 
 * </p>
 *
 * @return
 * @return User
 */
@Getter
/**
 * <h2> setId</h2>
 * <p>
 * 
 * </p>
 *
 * @param id
 * @return void
 */
/**
 * <h2> setPassword</h2>
 * <p>
 * 
 * </p>
 *
 * @param password
 * @return void
 */
/**
 * <h2> setToken</h2>
 * <p>
 * 
 * </p>
 *
 * @param token
 * @return void
 */
/**
 * <h2> setUser</h2>
 * <p>
 * 
 * </p>
 *
 * @param user
 * @return void
 */
@Setter
/**
 * <h2> Constructor for PasswordResetForm </h2>
 * <p>
 * Constructor for PasswordResetForm
 * </p>
 */
@NoArgsConstructor
/**
 * <h2> Constructor for PasswordResetForm </h2>
 * <p>
 * Constructor for PasswordResetForm
 * </p>
 * @param id
 * @param password
 * @param token
 * @param user
 * @param expiryAt
 */
@AllArgsConstructor
public class PasswordResetForm {
    /**
     * <h2> id</h2>
     * <p>
     * id
     * </p>
     */
    /**
     * <h2> id</h2>
     * <p>
     * id
     * </p>
     */
    private Long id;
    /**
     * <h2> password</h2>
     * <p>
     * password
     * </p>
     */
    @NotEmpty
    private String password;
    /**
     * <h2> token</h2>
     * <p>
     * token
     * </p>
     */
    @NotEmpty
    private String token;
    /**
     * <h2> user</h2>
     * <p>
     * user
     * </p>
     */
    private User user;
    /**
     * <h2> expiryAt</h2>
     * <p>
     * expiryAt
     * </p>
     */
    private Date expiryAt;
    /**
     * <h2> getExpiryAt</h2>
     * <p>
     * 
     * </p>
     *
     * @return
     * @return Date
     */
    public Date getExpiryAt() {
        return expiryAt;
    }

    /**
     * <h2> setExpiryAt</h2>
     * <p>
     * 
     * </p>
     *
     * @param expiryAt
     * @return void
     */
    public void setExpiryAt(Date expiryAt) {
        this.expiryAt = expiryAt;
    }

    /**
     * <h2> isExpired</h2>
     * <p>
     * 
     * </p>
     *
     * @return
     * @return boolean
     */
    public boolean isExpired() {
        return new Date().after(this.expiryAt);
    }
    /**
     * <h2> Constructor for PasswordResetForm </h2>
     * <p>
     * Constructor for PasswordResetForm
     * </p>
     * @param passwordReset
     */
    public PasswordResetForm(PasswordReset passwordReset) {
        super();
        this.id=passwordReset.getId();
        this.token = passwordReset.getToken(); 
        this.user=passwordReset.getUser();
    }
}