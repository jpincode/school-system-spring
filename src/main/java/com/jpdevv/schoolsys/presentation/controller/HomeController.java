package com.jpdevv.schoolsys.presentation.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class HomeController {
    @GetMapping("/discipline/create")
    public ModelAndView createDiscipline() {
        ModelAndView mv = new ModelAndView("create-discipline");
        return mv;
    }

    @GetMapping("/student/create")
    public ModelAndView createStudent() {
        ModelAndView mv = new ModelAndView("create-student");
        return mv;
    }

    @GetMapping("/discipline")
    public ModelAndView readDiscipline() {
        ModelAndView mv = new ModelAndView("read-discipline");
        return mv;
    }

    @GetMapping("/student")
    public ModelAndView readStudent() {
        ModelAndView mv = new ModelAndView("read-student");
        return mv;
    }
}
