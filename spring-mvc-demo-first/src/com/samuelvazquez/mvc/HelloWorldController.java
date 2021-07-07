package com.samuelvazquez.mvc;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;

@Controller
public class HelloWorldController {
    //need a controller method to show the initial HTML form
    @RequestMapping("/showForm")
    public String showForm() {
        return "helloworld-form";
    }

    //need a controller method to process the HTML form
    @RequestMapping("/processForm")
    public String processForm() {
        return "helloworld";
    }

    // new a controller method to read form data and
    // add data to the model
    @RequestMapping("/processFormV2")
    public String capitalizeSmth(HttpServletRequest request, Model model) {
        //read the request parameter from the HTML form
        String name = request.getParameter("studentName");
        //convert the data to all caps
        name = name.toUpperCase();
        //create the message
        String result = "Hey " + name;
        //add message to the model
        model.addAttribute("message", result);
        return "helloworld";
    }

    @RequestMapping("/processFormV3")
    public String capitalizeUsingRequestParam(
            @RequestParam ("studentName") String theName,
            Model model) {
        theName = theName.toUpperCase().replaceAll("[J]","X");
        String result = "I don't like to use the letter 'J': " + theName;
        model.addAttribute("message",result);
        return "helloworld";
    }

}
