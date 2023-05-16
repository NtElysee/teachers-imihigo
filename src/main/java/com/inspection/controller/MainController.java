package com.inspection.controller;



import com.inspection.model.Teacher;
import com.inspection.serviceLayer.TeacherService;

import com.inspection.serviceLayer.UserNotFoundExcpetion;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.*;

import static org.springframework.data.jpa.domain.AbstractPersistable_.id;

@Controller
public class MainController {
    @Autowired
    private TeacherService service;

    @GetMapping("/teachers")
    public String ShowTeacherList(Model model) {

        List<Teacher> listTeachers= service.listAll();
        model.addAttribute("listTeachers",  listTeachers);

        return "teachers";
    }

    @GetMapping("/teachers/new")
    public String ShowTeacherForm( Model model){

        model.addAttribute("teacher", new Teacher());
        return "teacher_form";
    }

    @PostMapping("/teachers/new")
    public String saveTeacher(@ModelAttribute Teacher teacher, RedirectAttributes ra){
        service.save(teacher);
        ra.addAttribute("message", "Data has been saved successfully");
        return "redirect:/teachers";

    }

    @GetMapping("/teachers/edit/{id}")
    public  String showEditForm(@PathVariable("id") Integer id, Model model, RedirectAttributes ra){

        try {
            Teacher teacher= service.get(id);
            model.addAttribute("teacher", teacher);
            model.addAttribute("pageTitle", "Edit Teacher (ID "+ id +")");
            return "teacher_form";
        }
         catch (UserNotFoundExcpetion e) {
            ra.addAttribute("message", e.getMessage());

        }
        return "redirect:/teachers";

    }

    @GetMapping("/teachers/delete/{id}")
    public  String DeleteTeacher(@PathVariable("id") Integer id, RedirectAttributes ra){

        try {
                service.delete(id);

        }
        catch (UserNotFoundExcpetion e) {
            ra.addAttribute("message", e.getMessage());

        }
        return "redirect:/teachers";

    }

}
