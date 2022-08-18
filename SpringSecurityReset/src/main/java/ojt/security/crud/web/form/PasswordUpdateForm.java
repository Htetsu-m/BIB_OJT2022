package ojt.security.crud.web.form;

import javax.validation.constraints.NotEmpty;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * <h2> PasswordUpdateForm Class</h2>
 * <p>
 * Process for Displaying PasswordUpdateForm
 * </p>
 * 
 * @author User
 *
 */
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class PasswordUpdateForm {
    
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
    private String token;
}