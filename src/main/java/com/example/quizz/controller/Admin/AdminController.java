package com.example.quizz.controller.Admin;

import com.example.quizz.entity.Question;
import com.example.quizz.entity.Quizz;
import com.example.quizz.service.QuestionService;
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
    @Autowired
    private QuestionService questionService;


    @GetMapping("quizz")
    public String getQuizzView(Model model){

        model.addAttribute("quizz", quizzService.getAll());
        return "quizz.html";
    }

    @PostMapping("newquizz")
    public String add(Quizz quizz, Model model){

        quizzService.add(quizz);

        model.addAttribute("quizz", quizzService.getAll());
        return "quizz.html";
    }

    @GetMapping("question")
    public String getQuestionView(Model model){

        model.addAttribute("questions", questionService.getAll());
        model.addAttribute("quizz", quizzService.getAll());

        return "question.html";
    }

    @PostMapping("newquestion")
    public String addQuestion(Question question, Model model){

        questionService.add(question);

        model.addAttribute("questions", questionService.getAll());
        model.addAttribute("quizz", quizzService.getAll());
        return "question.html";
    }


}
