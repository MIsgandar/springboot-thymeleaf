package com.gg.springboot.tymeleafdemo.controller;


import com.gg.springboot.tymeleafdemo.model.Student;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class StudentController {

    @Value("${countries}")
    private List<String> countries;
    @Value("${languages}")
    private List<String> languages;
    @Value("${systems}")
    private List<String> systems;

    @GetMapping("/showStudentForm")
    public String showFrom(Model model) {

        // Create a new studnetn object
        Student theStudent = new Student();

        // Add student object to the model
        model.addAttribute("student", theStudent);

        // Add list of countries to the model
        model.addAttribute("countries", countries);

        // Add programming languages to the model
        model.addAttribute("languages", languages);

        // Add programming systems to the model
        model.addAttribute("systems", systems);


        return "student-form";
    }

    @PostMapping("/processStudentForm")
    public String processForm(@ModelAttribute("student") Student theStudent) {

        // log the input data
        System.out.println("theStudent: " + theStudent.getFirstName() + " " + theStudent.getLastName());

        return "student-confirmation";

    }

}
