package ojt.security.crud.web.form;

import java.util.Date;

import javax.validation.constraints.NotEmpty;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import ojt.security.crud.persistence.entity.User;

/**
 * <h2>UserForm Class</h2>
 * <p>
 * Process for Displaying UserForm
 * </p>
 * 
 * @author User
 *
 */
@NoArgsConstructor
@AllArgsConstructor
public class UserForm {
    private int id;
    @NotEmpty
    private String username;
    @NotEmpty
    private String phone;
    @NotEmpty
    private String email;
    @NotEmpty
    private String password;
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

    public String getUsername() {
        return username;
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
    public void setUsername(String username) {
        this.username = username;
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
    
    public UserForm(User user) {
        super();
        this.id = user.getId();
        this.username = user.getUsername();
        this.phone = user.getPhone();
        this.email = user.getEmail();
        this.password = user.getPassword();
    }


    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    

}
