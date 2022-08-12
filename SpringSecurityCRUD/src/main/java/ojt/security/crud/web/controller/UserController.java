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
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
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

    @RequestMapping(value = "/userList")
    public ModelAndView getUserList(ModelAndView model) throws IOException {
        List<User> UserList = userService.getUserList();
        model.addObject("UserList", UserList);
        model.setViewName("userList");
        return model;
    }

    @RequestMapping(value = "/createUser", method = RequestMethod.GET)
    public ModelAndView newUser(ModelAndView model) {
        User user = new User();
        ModelAndView createUser = new ModelAndView("createUser");
        createUser.setViewName("createUser");
        List<Authority> roleList = userService.getAuthorityList();
        createUser.addObject("AuthorityList", roleList);
        createUser.addObject("rollBackUserForm", user);
        return createUser;
    }

    @RequestMapping(value = "/insertUser", params = "addUser", method = RequestMethod.POST)
    public ModelAndView insertUser(@ModelAttribute("rollBackUserForm") @Valid UserForm userForm, BindingResult result, HttpServletRequest request,
            HttpServletResponse response) {

        Authority authoId=userService.doGetAuthorityById(userForm.getAuthority().getId());
        List<Authority> authoList=new ArrayList<Authority>();       
        authoList.add(authoId);
        userForm.setAuthorities(authoList);
        
        this.userService.doAddUser(userForm);
        ModelAndView createUserView = new ModelAndView("redirect:/userList");
        return createUserView;
    }
    
    @RequestMapping(value = "/deleteUser", method = RequestMethod.GET)
    public ModelAndView deleteUser(HttpServletRequest request) {
        int userId = Integer.parseInt(request.getParameter("id"));
        userService.deleteUser(userId);
        return new ModelAndView("redirect:/userList");
    }
    @RequestMapping(value = "/updateUser", method = RequestMethod.GET)
    public ModelAndView editUser(@RequestParam("id") Integer userId, HttpServletRequest request) {
        UserForm user = userService.doGetUserById(userId);
        ModelAndView model = new ModelAndView("updateUser");
        model.addObject("user", user);
        model.setViewName("updateUser");
        return model;
    }
    @RequestMapping(value = "/editUser", params = "update", method = RequestMethod.POST)
    public ModelAndView updateUser(@ModelAttribute("finalConfirmStudentForm") @Valid UserForm userForm,
            BindingResult result, HttpServletRequest request, HttpServletResponse response)
            throws ParseException, FileNotFoundException, IOException {
        this.userService.updateUser(userForm);
        ModelAndView updateUserView = new ModelAndView("redirect:/userList");
        return updateUserView;
    }

    @RequestMapping(value = "/editUser", params = "cancel", method = RequestMethod.POST)
    public ModelAndView cancelupdateUser(@ModelAttribute("finalConfirmUserForm") @Valid UserForm userForm,
            BindingResult result) throws ParseException {
        ModelAndView updateUserView = new ModelAndView("updateUser");
        updateUserView.addObject("user", userForm);
        return updateUserView;
    }

    /*
     * @RequestMapping(value = "/home") public String homePage() { return "home"; }
     * 
     * @RequestMapping(value = "/user") public String userPage() { return "user"; }
     * 
     * @RequestMapping(value = "/admin") public String adminPage() { return "admin";
     * }
     */

    @RequestMapping(value = "/error")
    public String error() {
        return "access-denied";
    }
}