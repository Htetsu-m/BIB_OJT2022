package ojt.security.crud.web.form;

import java.util.Date;

import javax.validation.constraints.NotEmpty;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import ojt.security.crud.persistence.entity.PasswordReset;

/**
 * <h2> PasswordResetForm Class</h2>
 * <p>
 * Process for Displaying PasswordResetForm
 * </p>
 * 
 * @author User
 *
 */
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class PasswordResetForm {
    /**
     * <h2> user_email</h2>
     * <p>
     * user_email
     * </p>
     */
    @NotEmpty
    private String user_email;
    /**
     * <h2>id</h2>
     * <p>
     * id
     * </p>
     */
     private Integer id;
    /**
     * <h2>password</h2>
     * <p>
     * password
     * </p>
     */
    @NotEmpty
    private String password;
    /**
     * <h2>token</h2>
     * <p>
     * token
     * </p>
     */
    @NotEmpty
    private String token;

    /**
     * <h2>expiryAt</h2>
     * <p>
     * expiryAt
     * </p>
     */
    private Date expiryAt;

    /**
     * <h2>getExpiryAt</h2>
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
     * <h2>setExpiryAt</h2>
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
     * <h2>isExpired</h2>
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
     * <h2>Constructor for PasswordResetForm</h2>
     * <p>
     * Constructor for PasswordResetForm
     * </p>
     * 
     * @param passwordReset
     */
    public PasswordResetForm(PasswordReset passwordReset) {
        super();
        this.id=passwordReset.getId();
        this.user_email = passwordReset.getUser_email();
        this.token = passwordReset.getToken();
        this.expiryAt = passwordReset.getExpiryAt();
    }
}