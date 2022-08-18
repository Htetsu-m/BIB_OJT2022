package ojt.security.crud.bl.service;

import ojt.security.crud.persistence.entity.PasswordReset;
import ojt.security.crud.web.form.PasswordResetForm;

/**
 * <h2>PasswordResetService Class</h2>
 * <p>
 * Process for Displaying PasswordResetService
 * </p>
 * 
 * @author User
 *
 */
public interface PasswordResetService {
    /**
     * <h2>doAddToken</h2>
     * <p>
     * 
     * </p>
     *
     * @param reset
     * @return void
     */
    public void doAddToken(PasswordReset reset);

    /**
     * <h2>doGetPasswordByToken</h2>
     * <p>
     * 
     * </p>
     *
     * @param token
     * @return
     * @return PasswordResetForm
     */
    public PasswordResetForm doGetPasswordByToken(String token);

    /**
     * <h2> doDeleteToken</h2>
     * <p>
     * 
     * </p>
     *
     * @param token
     * @return void
     */
    public void doDeleteToken(Integer reset_id);
}