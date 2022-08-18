package ojt.security.crud.persistence.entity;

import java.util.Calendar;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

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
@Table(name = "PasswordReset")
public class PasswordReset {
    /**
     * <h2>id</h2>
     * <p>
     * id
     * </p>
     */
    @Id
    @Column(name = "reset_id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    /**
     * <h2>token</h2>
     * <p>
     * token
     * </p>
     */
    @Column(name = "token")
    private String token;
    /**
     * <h2>user</h2>
     * <p>
     * user
     * </p>
     */
    @OneToOne(targetEntity = User.class, fetch = FetchType.EAGER)
    @JoinColumn(name = "u_id")
    private User user;
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
    public Long getId() {
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
    public void setId(Long id) {
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
     * <h2>getUser</h2>
     * <p>
     * 
     * </p>
     *
     * @return
     * @return User
     */
    public User getUser() {
        return user;
    }

    /**
     * <h2>setUser</h2>
     * <p>
     * 
     * </p>
     *
     * @param user
     * @return void
     */
    public void setUser(User user) {
        this.user = user;
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
}