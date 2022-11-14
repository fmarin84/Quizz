package com.example.quizz.controller.Admin;

import com.example.quizz.UserDTO;
import com.example.quizz.entity.Answer;
import com.example.quizz.entity.Question;
import com.example.quizz.entity.Quizz;
import com.example.quizz.entity.User;
import com.example.quizz.service.AnswerService;
import com.example.quizz.service.QuestionService;
import com.example.quizz.service.QuizzService;
import com.example.quizz.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class AdminController {
    
    @Autowired
    private QuizzService quizzService;
    @Autowired
    private QuestionService questionService;

    @Autowired
    private UserService userService;

    @Autowired
    private AnswerService answerService;

    /*  Quizz */
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

    @GetMapping("updatequizz/{id}")
    public String getUpdateQuizzView(@PathVariable("id") int id, Model model){
        model.addAttribute("quizz", quizzService.getQuizz(id).get());

        return "updateQuizz.html";
    }

    @PostMapping("updatequizz")
    public String update(Quizz quizz, Model model) throws Exception {
        quizzService.update(quizz.getId(), quizz);
        model.addAttribute("quizz", quizzService.getAll());

        return "quizz.html";
    }

    @PostMapping("deleteQuizz/{id}")
    public String deleteQuizz(@PathVariable("id") int id, Model model){
        quizzService.deleteQuizz(id);
        model.addAttribute("quizz", quizzService.getAll());

        return "quizz.html";
    }


    /*  Question */
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

    @GetMapping("updateQuestion/{id}")
    public String getUpdateQuestionView(@PathVariable("id") int id, Model model){
        model.addAttribute("question", questionService.getQuestion(id).get());
        model.addAttribute("quizz", quizzService.getAll());

        return "updateQuestion.html";
    }

    @PostMapping("updateQuestion")
    public String updateQuestion(Question question, Model model) throws Exception {
        questionService.update(question.getId(), question);
        model.addAttribute("questions", questionService.getAll());

        return "question.html";
    }

    @PostMapping("deleteQuestion/{id}")
    public String deleteQuestion(@PathVariable("id") int id, Model model){
        questionService.deleteQuestion(id);
        model.addAttribute("questions", questionService.getAll());

        return "question.html";
    }

    /* User */
    @GetMapping("user")
    public String getUserView(Model model){
        model.addAttribute("users", userService.getAll());

        return "user.html";
    }

    @GetMapping("updateUser/{id}")
    public String getUpdateUserView(@PathVariable("id") int id, Model model){
        model.addAttribute("user", userService.getUser(id).get());

        return "updateUser.html";
    }

    @PostMapping("updateUser")
    public String updateUser(User user, Model model) throws Exception {
        userService.update(user.getId(), user);
        model.addAttribute("users", userService.getAll());

        return "user.html";
    }

    @PostMapping("deleteUser/{id}")
    public String deleteUser(@PathVariable("id") int id, Model model){
        userService.deleteUser(id);
        model.addAttribute("users", userService.getAll());
        model.addAttribute("questions", questionService.getAll());

        return "user.html";
    }

    /* Answer */
    @GetMapping("answer")
    public String getAnswerView(Model model){
        model.addAttribute("answers", answerService.getAll());
        model.addAttribute("questions", questionService.getAll());

        return "answer.html";
    }

    @PostMapping("newAnswer")
    public String addAnswer(Answer answer, Model model){
        answerService.add(answer);
        model.addAttribute("answers", answerService.getAll());
        model.addAttribute("questions", questionService.getAll());

        return "answer.html";
    }

    @GetMapping("updateAnswer/{id}")
    public String getUpdateAnswerView(@PathVariable("id") int id, Model model){
        model.addAttribute("answer", answerService.getAnswer(id).get());
        model.addAttribute("questions", questionService.getAll());

        return "updateAnswer.html";
    }

    @PostMapping("updateAnswer")
    public String updateAnswer(Answer answer, Model model) throws Exception {
        answerService.update(answer.getId(), answer);
        model.addAttribute("answers", answerService.getAll());

        return "answer.html";
    }

    @PostMapping("deleteAnswer/{id}")
    public String deleteAnswer(@PathVariable("id") int id, Model model){
        answerService.deleteAnswer(id);
        model.addAttribute("answers", answerService.getAll());
        model.addAttribute("questions", questionService.getAll());

        return "answer.html";
    }
}
