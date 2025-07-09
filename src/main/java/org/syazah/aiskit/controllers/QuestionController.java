package org.syazah.aiskit.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.syazah.aiskit.models.Question;
import org.syazah.aiskit.services.QuestionService;

import java.util.List;
import java.util.Map;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1/questions")
public class QuestionController {

    private QuestionService questionService;

    public QuestionController(QuestionService questionService) {
        this.questionService = questionService;
    }

    @PostMapping
    public ResponseEntity<Question> save(@RequestBody Map<String, String> payload) {
        Question question = Question.builder()
                .title(payload.get("title"))
                .body(payload.get("body")).build();
        Question response = questionService.createQuestion(question, payload.get("user"));
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

    @GetMapping("/search")
    public ResponseEntity<List<Question>> search(@RequestParam Optional<String> text, @RequestParam Optional<String> tag) {
        List<Question> questions = questionService.searchQuestions(text, tag);
        if (questions.isEmpty()) {
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.ok(questions);
        }

    }
}
