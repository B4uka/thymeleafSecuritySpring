package pl.chessWebApp.springsecurity.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.StringTrimmerEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;
import pl.chessWebApp.springsecurity.demo.entity.User;
import pl.chessWebApp.springsecurity.demo.service.UserService;
import pl.chessWebApp.springsecurity.demo.user.CrmUser;

import javax.validation.Valid;
import java.util.logging.Logger;

@Controller
@RequestMapping("/register")
public class RegistrationController {

    @Autowired
    private UserService userService;

    private Logger logger = Logger.getLogger(getClass().getName());

    @InitBinder
    public void initBinder (WebDataBinder dataBinder) {

        StringTrimmerEditor stringTrimmerEditor = new StringTrimmerEditor(true);

        dataBinder.registerCustomEditor(String.class, stringTrimmerEditor);
    }

    @GetMapping("/showRegistrationForm")
    public String showMyLoginPage (Model theModel) {

        theModel.addAttribute("crmUser", new CrmUser());

        return "registration-form";
    }

    @PostMapping("/processRegistrationForm")
    public String processRegistrationForm (
            @Valid @ModelAttribute("crmUser") CrmUser theCrmUser,
            BindingResult theBindingResult,
            Model theModel) {

        String userName = theCrmUser.getUserName();
        String userEmail = theCrmUser.getEmail();

        logger.info("Processing registration form for: " + userName + " and " + userEmail);

        // form validation
        if (theBindingResult.hasErrors()) {
            return "registration-form";
        }

        // check the database if user or email already exists
        User existing = userService.findByUserName(userName);
        User existing2 = userService.findByUserEmail(userEmail);

        if (existing != null || existing2 != null) {
            theModel.addAttribute("crmUser", new CrmUser());
            theModel.addAttribute("registrationError", "User name or email already exists.");

            logger.warning("User name or email already exists.");
            return "registration-form";
        } else {// create user account
            userService.save(theCrmUser);

            logger.info("Successfully created user: " + userName);
        }
        return "registration-confirmation";
    }
}
