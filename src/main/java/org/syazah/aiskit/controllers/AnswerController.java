package org.syazah.aiskit.controllers;

import org.springframework.web.bind.annotation.*;
import org.syazah.aiskit.models.Answer;
import org.syazah.aiskit.services.AnswerService;

import java.util.Map;

@RestController
@RequestMapping("/api/v1/answers")
public class AnswerController {

    private AnswerService answerService;

    public AnswerController(AnswerService answerService) {
        this.answerService = answerService;
    }

    @PostMapping("/{questionId}")
    public Answer createAnswer(@PathVariable String questionId, @RequestBody Map<String, String> request) {
        Answer answer = Answer.builder().text(request.get("text")).build();
        String userId = request.get("userId");
        return answerService.createAnswer(answer, questionId, userId);
    }
}
