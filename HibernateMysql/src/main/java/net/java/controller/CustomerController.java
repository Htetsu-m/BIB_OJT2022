package net.java.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import net.java.entity.Customer;
import net.java.serrvice.CustomerService;

@Controller
public class CustomerController {
    // private static final Logger LOG =
    // LoggerFactory.getLogger(CustomerController.class);
    @Autowired
    private CustomerService customerService;

    // @RequestMapping(value="/",method=RequestMethod.GET)

    @RequestMapping(value="/post")
    public String init() {
        System.out.println("Controller");
        return null;
    }

    @RequestMapping(value = "/save")
    public String saveUser() {
        Customer customer = new Customer();
        this.customerService.saveCustomer(customer);
        return null;

    }

}
