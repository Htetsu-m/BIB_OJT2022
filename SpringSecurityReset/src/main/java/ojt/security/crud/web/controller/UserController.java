package ojt.security.crud.web.controller;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import ojt.security.crud.bl.service.UserService;
import ojt.security.crud.persistence.entity.Authority;
import ojt.security.crud.persistence.entity.User;
import ojt.security.crud.web.form.UserForm;

/**
 * <h2>UserController Class</h2>
 * <p>
 * Process for Displaying UserController
 * </p>
 * 
 * @author User
 *
 */
@Controller
public class UserController {
    /**
     * <h2>userService</h2>
     * <p>
     * userService
     * </p>
     */
    @Autowired
    private UserService userService;

    /**
     * <h2>messageSource</h2>
     * <p>
     * messageSource
     * </p>
     */
    @Autowired
    private MessageSource messageSource;

    /**
     * <h2>getUserList</h2>
     * <p>
     * 
     * </p>
     *
     * @param model
     * @return
     * @throws IOException
     * @return ModelAndView
     */
    @RequestMapping(value = "/userList")
    public ModelAndView getUserList(ModelAndView model) throws IOException {
        List<User> UserList = userService.doGetUserList();
        model.addObject("UserList", UserList);
        model.setViewName("userList");
        return model;
    }

    /**
     * <h2>newUser</h2>
     * <p>
     * 
     * </p>
     *
     * @param model
     * @return
     * @return ModelAndView
     */
    @RequestMapping(value = "/createUser", method = RequestMethod.GET)
    public ModelAndView newUser(ModelAndView model, BindingResult result) {
        ModelAndView createUser = new ModelAndView("createUser");
        UserForm user = new UserForm();
        createUser.setViewName("createUser");
        List<Authority> roleList = userService.doGetAuthorityList();
        createUser.addObject("AuthorityList", roleList);
        createUser.addObject("rollBackUserForm", user);
        return createUser;
    }

    /**
     * <h2>insertUser</h2>
     * <p>
     * 
     * </p>
     *
     * @param userForm
     * @param result
     * @param request
     * @param response
     * @return
     * @return ModelAndView
     */
    @RequestMapping(value = "/insertUser", params = "addUser", method = RequestMethod.POST)
    public ModelAndView insertUser(@ModelAttribute("rollBackUserForm") @Valid UserForm userForm, BindingResult result,
            HttpServletRequest request, HttpServletResponse response) {
        ModelAndView createUserView = new ModelAndView("redirect:/userList");
        List<Authority> roleList = userService.doGetAuthorityList();
        List<Authority> authoList = new ArrayList<Authority>();
        Authority authoId = userService.doGetAuthorityById(userForm.getAuthority().getId());
        authoList.add(authoId);
        userForm.setAuthorities(authoList);
        if (result.hasErrors()) {
            ModelAndView errorView = new ModelAndView("createUser");
            errorView.addObject("AuthorityList", roleList);
            errorView.addObject("rollBackUserForm", userForm);
            errorView.addObject("errorMsg", messageSource.getMessage("M_SC_0007", null, null));
            return errorView;
        }
        this.userService.doAddUser(userForm);
        return createUserView;
    }

    /**
     * <h2>deleteUser</h2>
     * <p>
     * 
     * </p>
     *
     * @param request
     * @return
     * @return ModelAndView
     */
    @RequestMapping(value = "/deleteUser", method = RequestMethod.GET)
    public ModelAndView deleteUser(HttpServletRequest request) {
        int userId = Integer.parseInt(request.getParameter("id"));
        userService.doDeleteUser(userId);
        return new ModelAndView("redirect:/userList");
    }

    /**
     * <h2>editUser</h2>
     * <p>
     * 
     * </p>
     *
     * @param userId
     * @param request
     * @return
     * @return ModelAndView
     */
    @RequestMapping(value = "/updateUser", method = RequestMethod.GET)
    public ModelAndView editUser(@RequestParam("id") Integer userId, HttpServletRequest request) {
        UserForm user = userService.doGetUserById(userId);
        for (Authority authority : user.getAuthorities()) {
            System.out.println(authority.getId());
            System.out.println(authority.getName());
            user.setAuthority(authority);
        }
        ModelAndView model = new ModelAndView("updateUser");
        model.setViewName("updateUser");
        List<Authority> roleList = userService.doGetAuthorityList();
        model.addObject("AuthorityList", roleList);
        model.addObject("editedUserForm", user);
        return model;
    }

    /**
     * <h2>updateUser</h2>
     * <p>
     * 
     * </p>
     *
     * @param userForm
     * @param result
     * @param request
     * @param response
     * @return
     * @throws ParseException
     * @throws FileNotFoundException
     * @throws IOException
     * @return ModelAndView
     */
    @RequestMapping(value = "/editUser", params = "update", method = RequestMethod.POST)
    public ModelAndView updateUser(@ModelAttribute("editedUserForm") @Valid UserForm userForm, BindingResult result,
            HttpServletRequest request, HttpServletResponse response)
            throws ParseException, FileNotFoundException, IOException {
        this.userService.doUpdateUser(userForm);
        ModelAndView updateUserView = new ModelAndView("redirect:/userList");
        return updateUserView;
    }

    /**
     * <h2>cancelupdateUser</h2>
     * <p>
     * 
     * </p>
     *
     * @param userForm
     * @param result
     * @return
     * @throws ParseException
     * @return ModelAndView
     */
    @RequestMapping(value = "/editUser", params = "cancel", method = RequestMethod.POST)
    public ModelAndView cancelupdateUser(@ModelAttribute("editedUserForm") @Valid UserForm userForm,
            BindingResult result) throws ParseException {
        ModelAndView updateUserView = new ModelAndView("updateUser");
        updateUserView.addObject("editedUserForm", userForm);
        return updateUserView;
    }

    /**
     * <h2>error</h2>
     * <p>
     * 
     * </p>
     *
     * @return
     * @return String
     */
    @RequestMapping(value = "/error")
    public String error() {
        return "access-denied";
    }
}