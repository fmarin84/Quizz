package com.example.quizz.controller.Admin;

import com.example.quizz.entity.Quizz;
import com.example.quizz.service.QuizzService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class AdminController {
    
    @Autowired
    private QuizzService quizzService;


    @GetMapping("quizz")
    public String getQuizzView(Model model){

        model.addAttribute("quizz", quizzService.getAllQuizz());
        return "quizz.html";
    }

    @PostMapping("newquizz")
    public String addPersonne(Quizz quizz, Model model){

        quizzService.addQuizz(quizz);

        model.addAttribute("quizz", quizzService.getAllQuizz());
        return "quizz.html";
    }
}
