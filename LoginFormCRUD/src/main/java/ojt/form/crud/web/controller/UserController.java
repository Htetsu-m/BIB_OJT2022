package ojt.form.crud.web.controller;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.ParseException;
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

import ojt.form.crud.bl.service.UserService;
import ojt.form.crud.persistance.entity.User;
import ojt.form.crud.web.form.UserForm;

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
        List<User> UserList = userService.getUserList();
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
    public ModelAndView newUser(ModelAndView model) {
        User user = new User();
        ModelAndView createUser = new ModelAndView("createUser");
        createUser.addObject("rollBackUserForm", user);
        createUser.setViewName("createUser");
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
    public ModelAndView insertUser(@ModelAttribute("userForm") @Valid UserForm userForm, BindingResult result,
            HttpServletRequest request, HttpServletResponse response) {
        this.userService.addUser(userForm);
        ModelAndView createUserView = new ModelAndView("redirect:/userList");

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
        userService.deleteUser(userId);
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
        UserForm user = userService.getUser(userId);
        ModelAndView model = new ModelAndView("updateUser");
        model.addObject("user", user);
        model.setViewName("updateUser");
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
    public ModelAndView updateUser(@ModelAttribute("finalConfirmStudentForm") @Valid UserForm userForm,
            BindingResult result, HttpServletRequest request, HttpServletResponse response)
            throws ParseException, FileNotFoundException, IOException {

        this.userService.updateUser(userForm);
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
    public ModelAndView cancelupdateUser(@ModelAttribute("finalConfirmUserForm") @Valid UserForm userForm,
            BindingResult result) throws ParseException {
        ModelAndView updateUserView = new ModelAndView("updateUser");
        updateUserView.addObject("user", userForm);
        return updateUserView;
    }
}