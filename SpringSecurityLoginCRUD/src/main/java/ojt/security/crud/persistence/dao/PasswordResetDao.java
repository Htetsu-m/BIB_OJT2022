package ojt.security.crud.persistence.dao;

import ojt.security.crud.persistence.entity.PasswordReset;

/**
 * <h2>PasswordResetDao Class</h2>
 * <p>
 * Process for Displaying PasswordResetDao
 * </p>
 * 
 * @author User
 *
 */
public interface PasswordResetDao {
    /**
     * <h2>dbAddToken</h2>
     * <p>
     * 
     * </p>
     *
     * @param passwordReset
     * @return void
     */
    public void dbAddToken(PasswordReset passwordReset);

    /**
     * <h2>dbGetPasswordByToken</h2>
     * <p>
     * 
     * </p>
     *
     * @param token
     * @return
     * @return PasswordReset
     */
    public PasswordReset dbGetPasswordByToken(String token);
}