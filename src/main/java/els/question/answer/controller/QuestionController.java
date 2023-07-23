package els.question.answer.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import els.question.answer.service.QuestionService;
import els.question.model.Question;

import java.util.List;

@RestController
@RequestMapping("/api")
public class QuestionController {

    @Autowired
    private QuestionService questionService;

    @GetMapping("/allQuestions")
    public ResponseEntity<List<Question>> getAllQuestions() {
        try {
            List<Question> questions = questionService.getAllQuestions();
            if (!questions.isEmpty()) {
                return ResponseEntity.ok(questions);
            } else {
                return ResponseEntity.noContent().build();
            }
        } catch (Exception ex) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
        }
    }

    @GetMapping("/questionsByCategory/{category}")
    public ResponseEntity<List<Question>> getQuestionsByCategory(@PathVariable String category) {
        try {
            List<Question> questions = questionService.getQuestionsByCategory(category);
            if (!questions.isEmpty()) {
                return ResponseEntity.ok(questions);
            } else {
                return ResponseEntity.noContent().build();
            }
        } catch (Exception ex) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
        }
    }

    @PostMapping("/addQuestions")
    public ResponseEntity<List<Question>> addQuestions(@RequestBody List<Question> questions) {
        try {
            List<Question> addedQuestions = questionService.addQuestions(questions);
            if (!addedQuestions.isEmpty()) {
                return ResponseEntity.status(HttpStatus.CREATED).body(addedQuestions);
            } else {
                return ResponseEntity.badRequest().body(null);
            }
        } catch (IllegalArgumentException ex) {
            return ResponseEntity.badRequest().body(null);
        } catch (Exception ex) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
        }
    }

    @PutMapping("/updateQuestion/{id}")
    public ResponseEntity<Question> updateQuestion(@PathVariable Long id, @RequestBody Question updatedQuestion) {
        try {
            Question question = questionService.updateQuestion(id, updatedQuestion);
            if (question != null) {
                return ResponseEntity.ok(question);
            } else {
                return ResponseEntity.notFound().build();
            }
        } catch (IllegalArgumentException ex) {
            return ResponseEntity.badRequest().body(null);
        } catch (Exception ex) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
        }
    }


    @DeleteMapping("/deleteQuestion/{id}")
    public ResponseEntity<String> deleteQuestion(@PathVariable Long id) {
        try {
            boolean isDeleted = questionService.deleteQuestion(id);
            if (isDeleted) {
                return ResponseEntity.ok("Question with ID " + id + " deleted successfully.");
            } else {
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Question with ID " + id + " not found.");
            }
        } catch (IllegalArgumentException ex) {
            return ResponseEntity.badRequest().body("Invalid question ID.");
        } catch (Exception ex) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("An error occurred while deleting the question.");
        }
    }

}
