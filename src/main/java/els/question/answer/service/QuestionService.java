package els.question.answer.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import els.question.answer.dao.QuestionRepository;
import els.question.model.Question;

import java.util.List;
import java.util.Optional;

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

    // Fetch questions by category
	public List<Question> getQuestionsByCategory(String category) {
		
		 return questionRepository.findByCategory(category);
	}

//	 // Add single question
//    public Question addQuestion(Question question) {
//        return questionRepository.save(question);
//    }
    // Add multiple questions
    public List<Question> addQuestions(List<Question> questions) {
        return questionRepository.saveAll(questions);
    }

 // Delete a question by ID
    public boolean deleteQuestion(Long id) {
        if (questionRepository.existsById(id)) {
            questionRepository.deleteById(id);
            return true;
        } else {
            return false;
        }
    }

 // Update a question by ID
    public Question updateQuestion(Long id, Question updatedQuestion) {
        Optional<Question> optionalQuestion = questionRepository.findById(id);
        if (optionalQuestion.isPresent()) {
            Question existingQuestion = optionalQuestion.get();
            // Update fields if provided in the updatedQuestion object
            if (updatedQuestion.getCategory() != null) {
                existingQuestion.setCategory(updatedQuestion.getCategory());
            }
            if (updatedQuestion.getDifficultLevel() != null) {
                existingQuestion.setDifficultLevel(updatedQuestion.getDifficultLevel());
            }
            if (updatedQuestion.getOption1() != null) {
                existingQuestion.setOption1(updatedQuestion.getOption1());
            }
            if (updatedQuestion.getOption2() != null) {
                existingQuestion.setOption2(updatedQuestion.getOption2());
            }
            if (updatedQuestion.getOption3() != null) {
                existingQuestion.setOption3(updatedQuestion.getOption3());
            }
            if (updatedQuestion.getOption4() != null) {
                existingQuestion.setOption4(updatedQuestion.getOption4());
            }
            if (updatedQuestion.getQuestionTitle() != null) {
                existingQuestion.setQuestionTitle(updatedQuestion.getQuestionTitle());
            }

            return questionRepository.save(existingQuestion);
        } else {
            return null;
        }
    }
}