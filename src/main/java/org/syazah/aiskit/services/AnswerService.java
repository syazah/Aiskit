package org.syazah.aiskit.services;

import org.springframework.stereotype.Service;
import org.syazah.aiskit.models.Answer;
import org.syazah.aiskit.models.Question;
import org.syazah.aiskit.models.User;
import org.syazah.aiskit.repositories.AnswerRepository;
import org.syazah.aiskit.repositories.QuestionRepository;
import org.syazah.aiskit.repositories.UserRepository;

import java.util.Optional;

@Service
public class AnswerService {

    private AnswerRepository answerRepository;
    private QuestionRepository questionRepository;
    private UserRepository userRepository;

    public AnswerService(AnswerRepository answerRepository, UserRepository userRepository, QuestionRepository questionRepository) {
        this.answerRepository = answerRepository;
        this.questionRepository = questionRepository;
        this.userRepository = userRepository;
    }

    public Answer createAnswer(Answer answer, String questionId, String userId) {
        Optional<Question> question = questionRepository.findById(questionId);
        Optional<User> user = userRepository.findById(userId);
        if (question.isPresent() && user.isPresent()) {
            Question questionAct = question.get();
            User userAct = user.get();
            answer.setQuestion(question.get());
            answer.setUser(user.get());
            questionAct.getAnswers().add(answer);
            questionRepository.save(questionAct);
            userAct.getAnswers().add(answer);
            userRepository.save(userAct);
            return answerRepository.save(answer);
        } else {
            throw new IllegalArgumentException("Question with ID " + questionId + " does not exist.");
        }
    }
}
