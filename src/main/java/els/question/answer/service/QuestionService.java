package els.question.answer.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import els.question.answer.dao.QuestionRepository;
import els.question.model.Question;

import java.util.List;

@Service
public class QuestionService {
    private final QuestionRepository questionRepository;

    @Autowired
    public QuestionService(QuestionRepository questionRepository) {
        this.questionRepository = questionRepository;
    }

    // Fetch all questions
    public List<Question> getAllQuestions() {
        return questionRepository.findAll();
    }
}
