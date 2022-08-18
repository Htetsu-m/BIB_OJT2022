package ojt.security.crud.persistence.entity;

import java.util.Calendar;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import ojt.security.crud.web.form.PasswordResetForm;

/**
 * <h2>PasswordReset Class</h2>
 * <p>
 * Process for Displaying PasswordReset
 * </p>
 * 
 * @author User
 *
 */
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "passwordreset")
public class PasswordReset {

    /**
     * <h2>user_email</h2>
     * <p>
     * user_email
     * </p>
     */
    @Column(name = "user_email")
    private String user_email;

    /**
     * <h2> id</h2>
     * <p>
     * id
     * </p>
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "reset_id")
    private Integer id;

    /**
     * <h2>token</h2>
     * <p>
     * token
     * </p>
     */
    @Column(name = "token")
    private String token;
    
    /**
     * <h2>expiryAt</h2>
     * <p>
     * expiryAt
     * </p>
     */
    @Column(name = "expiryAt")
    private Date expiryAt;

    /**
     * <h2>getId</h2>
     * <p>
     * 
     * </p>
     *
     * @return
     * @return Long
     */
    public Integer getId() {
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
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * <h2>getToken</h2>
     * <p>
     * 
     * </p>
     *
     * @return
     * @return String
     */
    public String getToken() {
        return token;
    }

    /**
     * <h2>setToken</h2>
     * <p>
     * 
     * </p>
     *
     * @param token
     * @return void
     */
    public void setToken(String token) {
        this.token = token;
    }

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
     * <h2>setExpiryAt</h2>
     * <p>
     * 
     * </p>
     *
     * @param minutes
     * @return void
     */
    public void setExpiryAt(int minutes) {
        Calendar now = Calendar.getInstance();
        now.add(Calendar.MINUTE, minutes);
        this.expiryAt = now.getTime();
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
     * <h2>getUser_email</h2>
     * <p>
     * 
     * </p>
     *
     * @return
     * @return String
     */
    public String getUser_email() {
        return user_email;
    }

    /**
     * <h2>setUser_email</h2>
     * <p>
     * 
     * </p>
     *
     * @param user_email
     * @return void
     */
    public void setUser_email(String user_email) {
        this.user_email = user_email;
    }

    /**
     * <h2> Constructor for PasswordReset </h2>
     * <p>
     * Constructor for PasswordReset
     * </p>
     * @param passwordResetForm
     */
    public PasswordReset(PasswordResetForm passwordResetForm) {
        super();
        this.id=passwordResetForm.getId();
        this.user_email = passwordResetForm.getUser_email();
        this.token = passwordResetForm.getToken();
        this.expiryAt = passwordResetForm.getExpiryAt();
    }
}