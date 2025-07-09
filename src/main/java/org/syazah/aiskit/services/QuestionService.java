package org.syazah.aiskit.services;

import org.springframework.stereotype.Service;
import org.syazah.aiskit.models.Question;
import org.syazah.aiskit.models.User;
import org.syazah.aiskit.repositories.QuestionRepository;
import org.syazah.aiskit.repositories.UserRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class QuestionService {

    private QuestionRepository questionRepository;
    private UserRepository userRepository;

    public QuestionService(QuestionRepository questionRepository, UserRepository userRepository) {
        this.questionRepository = questionRepository;
        this.userRepository = userRepository;
    }

    public Question createQuestion(Question question, String userId) {
        Optional<User> user = userRepository.findById(userId);
        if (user.isPresent()) {
            question.setUser(user.get());
            return questionRepository.save(question);
        } else {
            return null;
        }
    }

    public List<Question> searchQuestions(Optional<String> text, Optional<String> tag) {
        List<Question> result = new ArrayList<>();
        result.addAll(questionRepository.rawFindByTextPattern(text.orElse(null)));
        result.addAll(questionRepository.rawFindByTagPattern(tag.orElse(null)));

        return result.stream().distinct().collect(Collectors.toList());
    }
}
