package com.gg.springboot.tymeleafdemo.controller;

import org.springframework.ui.Model;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class HelloWorldController {

    // need a controller method to show initial HTML form
    @GetMapping("/showform")
    public String showFrom() {
        return "helloworld-form";
    }

    // need a controller method to process the HTML form
    @RequestMapping("/processform")
    public String processFrom(){
        return "helloworld";
    }

    // Need controller method to read from data and
    // Add adata to the model
    @RequestMapping("/processFormVersionTwo")
    public String upperCase(HttpServletRequest request, Model model){

        // Read the request parameter from HTML form
        String theName = request.getParameter("studentName");

        // Convert the data to all caps
        theName = theName.toUpperCase();

        // Create the message
        String result = "Hey" + theName;

        String degree = "Master degree";

        // Add message to the model
        model.addAttribute("message", result);
        model.addAttribute("degree1", degree);

        return "helloworld";
    }

    @PostMapping("/processFormVersionThree")
    public String upperCaseThree(@RequestParam ("studentName") String theName, Model model){

        // Convert the data to all caps
        theName = theName.toUpperCase();

        // Create the message
        String result = "Hey" + theName;

        String degree = "Master degree";

        // Add message to the model
        model.addAttribute("message", result);
        model.addAttribute("degree1", degree);

        return "helloworld";
    }
}
