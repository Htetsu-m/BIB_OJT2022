package ojt.security.crud.web.form;

import javax.validation.constraints.NotEmpty;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * <h2> PasswordForgotForm Class</h2>
 * <p>
 * Process for Displaying PasswordForgotForm
 * </p>
 * 
 * @author User
 *
 */
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class PasswordForgotForm {
    /**
     * <h2> email</h2>
     * <p>
     * email
     * </p>
     */
    @NotEmpty
    private String email;
}