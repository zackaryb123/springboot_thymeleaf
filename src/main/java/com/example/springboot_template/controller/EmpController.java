package com.example.springboot_template.controller;

import com.example.springboot_template.dao.EmpDao;
import com.example.springboot_template.model.Emp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class EmpController {

    @Autowired
    EmpDao dao;

    @GetMapping("/emp")
    public String display(@RequestParam(name="name", required = false, defaultValue = "admin")
                                  String name, Model model){
        model.addAttribute("name", name);
        return "emp";
    }

    @GetMapping("/listemp")
    public String listEmpDetails (Model model) {

        model.addAttribute("listemp", dao.empFetch());
        return "emplist";
    }

    @GetMapping("/empform")
    public String empForm(Model model) {
        model.addAttribute("emp", new Emp());
        return "empForm";
    }

    @PostMapping("/empform")
    public String empSubmit(@ModelAttribute Emp emp) {
        System.out.println(emp.toString());
        dao.addEmp(emp);
        return "result";
    }
}
