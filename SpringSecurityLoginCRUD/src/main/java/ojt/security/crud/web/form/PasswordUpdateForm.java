package ojt.security.crud.web.form;

import javax.validation.constraints.NotEmpty;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

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
@Getter
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
@Setter
/**
 * <h2> Constructor for PasswordUpdateForm </h2>
 * <p>
 * Constructor for PasswordUpdateForm
 * </p>
 */
@NoArgsConstructor
/**
 * <h2> Constructor for PasswordUpdateForm </h2>
 * <p>
 * Constructor for PasswordUpdateForm
 * </p>
 * @param password
 * @param token
 */
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
    @NotEmpty
    private String token;
}