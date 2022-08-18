package ojt.security.crud.bl.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import ojt.security.crud.bl.service.PasswordResetService;
import ojt.security.crud.persistence.dao.PasswordResetDao;
import ojt.security.crud.persistence.entity.PasswordReset;
import ojt.security.crud.web.form.PasswordResetForm;

/**
 * <h2>PasswordResetServiceImpl Class</h2>
 * <p>
 * Process for Displaying PasswordResetServiceImpl
 * </p>
 * 
 * @author User
 *
 */
@Transactional
@Service
public class PasswordResetServiceImpl implements PasswordResetService {
    /**
     * <h2>passwordResetDao</h2>
     * <p>
     * passwordResetDao
     * </p>
     */
    @Autowired
    private PasswordResetDao passwordResetDao;

    /**
     * <h2>doAddToken</h2>
     * <p>
     * 
     * </p>
     * 
     * @param reset
     */
    @Override
    public void doAddToken(PasswordReset reset) {
        this.passwordResetDao.dbAddToken(reset);
    }

    /**
     * <h2>doGetPasswordByToken</h2>
     * <p>
     * 
     * </p>
     * 
     * @param token
     * @return
     */
    @Override
    public PasswordResetForm doGetPasswordByToken(String token) {
        PasswordReset result = this.passwordResetDao.dbGetPasswordByToken(token);
        PasswordResetForm resultform = result != null ? new PasswordResetForm(result) : null;
        return resultform;
    }

    /**
     * <h2>doDeleteToken</h2>
     * <p>
     * 
     * </p>
     * 
     * @param token
     */
    @Override
    public void doDeleteToken(Integer reset_id) {
        this.passwordResetDao.dbDeleteToken(reset_id);
    }
}