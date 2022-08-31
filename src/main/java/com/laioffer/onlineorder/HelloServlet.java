package com.laioffer.onlineorder;

import java.io.*;

import org.apache.commons.io.IOUtils;
import org.json.JSONObject;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import com.laioffer.onlineorder.entity.Customer;
import com.fasterxml.jackson.databind.ObjectMapper;

@WebServlet(name = "helloServlet", value = "/hello-servlet")
public class HelloServlet extends HttpServlet {
    private String message;

    public void init() {
        message = "Hello World!";
    }



    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("application/json");


        JSONObject customer = new JSONObject();
        customer.put("email", "sun@laioffer.com");
        customer.put("first_name", "rick");
        customer.put("last_name", "sun");
        customer.put("age", 50);
        response.getWriter().print(customer);
    }


    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        // Read customer information from request body
        String str=IOUtils.toString(request.getReader());
        JSONObject jsonRequest = new JSONObject(str);
        String email = jsonRequest.getString("email");
        String firstName = jsonRequest.getString("first_name");
        String lastName = jsonRequest.getString("last_name");
        // Print customer information to IDE console
        System.out.println("Email is: " + email);
        System.out.println("First name is: " + firstName);
        System.out.println("Last name is: " + lastName);
        // Return status = ok as response body to the client
        response.setContentType("application/json");
        JSONObject jsonResponse = new JSONObject();
        jsonResponse.put("status", "ok");
        response.getWriter().print(jsonResponse);
    }

    public void destroy() {
    }
}