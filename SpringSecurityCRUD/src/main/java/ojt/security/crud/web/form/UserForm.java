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
 * <h2>UserForm Class</h2>
 * <p>
 * Process for Displaying UserForm
 * </p>
 * 
 * @author User
 *
 */
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class UserForm {
    private int id;
    @NotEmpty
    private String username;
    //@NotEmpty
    private String phone;
    //@NotEmpty
    private String email;
    @NotEmpty
    private String password;
    private List<Authority> authorities = new ArrayList<Authority>();
    private Authority authority;
    
    public UserForm(User user) {
        super();
        this.id = user.getId();
        this.username = user.getUsername();
        this.phone = user.getPhone();
        this.email = user.getEmail();
        this.password = user.getPassword();
        this.authorities=user.getAuthorities();
    }

}
