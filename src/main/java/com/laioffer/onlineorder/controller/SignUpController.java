package com.laioffer.onlineorder.controller;
import com.laioffer.onlineorder.entity.Customer;
import org.springframework.stereotype.Controller;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import com.laioffer.onlineorder.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;

@Controller
public class SignUpController {

    private CustomerService customerService;

    @Autowired
    public SignUpController(CustomerService customerService){
        this.customerService=customerService;
    }

    @RequestMapping(value = "/signup", method = RequestMethod.POST)
    //说明该method是用来处理这种request的
    @ResponseStatus(value = HttpStatus.CREATED)
    public void signUp(@RequestBody Customer customer){
        customerService.signUp(customer);
    }
}
