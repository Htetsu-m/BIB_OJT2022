package ojt.security.crud.web.controller;

import java.util.UUID;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.mail.javamail.MimeMessagePreparator;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import ojt.security.crud.bl.service.PasswordResetService;
import ojt.security.crud.bl.service.UserService;
import ojt.security.crud.persistence.entity.PasswordReset;
import ojt.security.crud.persistence.entity.User;
import ojt.security.crud.web.form.PasswordForgotForm;
import ojt.security.crud.web.form.PasswordResetForm;
import ojt.security.crud.web.form.PasswordUpdateForm;

/**
 * <h2>PasswordForgotController Class</h2>
 * <p>
 * Process for Displaying PasswordForgotController
 * </p>
 * 
 * @author User
 *
 */
@Controller
public class PasswordForgotController {
    /**
     * <h2>mailSenderObj</h2>
     * <p>
     * mailSenderObj
     * </p>
     */
    @Autowired
    private JavaMailSender mailSenderObj;
    /**
     * <h2>passwordResetService</h2>
     * <p>
     * passwordResetService
     * </p>
     */
    @Autowired
    private PasswordResetService passwordResetService;
    /**
     * <h2>userService</h2>
     * <p>
     * userService
     * </p>
     */
    @Autowired
    private UserService userService;

    /**
     * <h2>showEmailForm</h2>
     * <p>
     * 
     * </p>
     *
     * @return
     * @return ModelAndView
     */
    @RequestMapping(value = "/forgotPassword", method = RequestMethod.GET)
    public ModelAndView showEmailForm() {
        PasswordForgotForm forgotForm = new PasswordForgotForm();
        ModelAndView mailBox = new ModelAndView("forgot_password_form");
        mailBox.addObject("rollBackEmailForm", forgotForm);
        mailBox.setViewName("forgot_password_form");
        return mailBox;
    }

    // This Method Is Used To Prepare The Email Message And Send It To The Client
    /**
     * <h2>sendEmailToClient</h2>
     * <p>
     * 
     * </p>
     *
     * @param forgotForm
     * @param result
     * @param request
     * @param response
     * @return
     * @throws MessagingException
     * @return ModelAndView
     */
    @RequestMapping(value = "/sendEmail", method = RequestMethod.POST)
    public ModelAndView sendEmailToClient(@ModelAttribute("rollBackEmailForm") @Valid PasswordForgotForm forgotForm,
            BindingResult result, HttpServletRequest request, HttpServletResponse response) throws MessagingException {
        ModelAndView modelViewObj = new ModelAndView("forgot_password_form");
        User user_email = userService.findByEmail(forgotForm.getEmail());
        System.out.println(forgotForm.getEmail());
        if (user_email == null) {
            result.rejectValue("email", null, "We could not find an account for that e-mail address.");
            ModelAndView forgot = new ModelAndView("forgot_password_form");
            forgot.setViewName("forgot_password_form");
            return forgot;
        }
        System.out.println(user_email.getId());
        PasswordReset token = new PasswordReset();
        token.setToken(UUID.randomUUID().toString());
        token.setUser(user_email);
        System.out.println(token.getUser().getId());
        token.setExpiryAt(30);
        passwordResetService.doAddToken(token);
        mailSenderObj.send(new MimeMessagePreparator() {

            @Override
            public void prepare(MimeMessage mimeMessage) throws Exception {
                MimeMessageHelper mimeMsgHelperObj = new MimeMessageHelper(mimeMessage);
                mimeMsgHelperObj.setTo(user_email.getEmail());
                mimeMsgHelperObj.setFrom("htetsumoeisreal@gmail.com");
                String url = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
                        + request.getContextPath();
                mimeMsgHelperObj.setText(url + "/resetPassword?token=" + token.getToken());
                mimeMsgHelperObj.setSubject("Password reset request");
            }
        });
        System.out.println("\nMessage Send Successfully....\n");
        return modelViewObj;
    }

    /**
     * <h2>showResetForm</h2>
     * <p>
     * 
     * </p>
     *
     * @param model
     * @param token
     * @return
     * @return ModelAndView
     */
    @RequestMapping(value = "/resetPassword/sendMail", method = RequestMethod.GET)
    public ModelAndView showResetForm(Model model, @RequestParam("token") String token) {
        ModelAndView resetForm = new ModelAndView("reset_password_form");
        PasswordUpdateForm passwordUpdate = new PasswordUpdateForm();
        PasswordResetForm resetToken = this.passwordResetService.doGetPasswordByToken(token);
        System.out.println(resetToken);
        if (resetToken == null) {
            model.addAttribute("error", "Could not find password reset token.");
        } else if (resetToken.isExpired()) {
            model.addAttribute("error", "Token has expired, please request a new password reset.");
        }
        passwordUpdate.setToken(resetToken.getToken());
        resetForm.addObject("rollBackResetForm", passwordUpdate);
        resetForm.setViewName("reset_password_form");
        return resetForm;
    }

    /**
     * <h2>resetPassword</h2>
     * <p>
     * 
     * </p>
     *
     * @param passwordResetForm
     * @param result
     * @return
     * @return ModelAndView
     */
    @RequestMapping(value = "/changePassword", method = RequestMethod.POST)
    public ModelAndView resetPassword(@Valid @ModelAttribute("rollBackResetForm") PasswordResetForm passwordResetForm,
            BindingResult result) {
        if (result.hasErrors()) {
            return new ModelAndView("rollBackResetForm");
        }
        Long userId = passwordResetService.doGetPasswordByToken(passwordResetForm.getToken()).getId();
        return null;
    }
}