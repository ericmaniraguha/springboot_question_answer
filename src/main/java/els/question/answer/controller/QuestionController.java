package els.question.answer.controller;

import org.springframework.beans.factory.annotation.Autowired;
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
        List<Question> questions = questionService.getAllQuestions();
        return ResponseEntity.ok(questions);
    }
    
    @GetMapping("/questionsByCategory/{category}") // Removed unnecessary curly braces from the path
    public ResponseEntity<List<Question>> getQuestionsByCategory(@PathVariable String category) {
        List<Question> questions = questionService.getQuestionsByCategory(category);
        return ResponseEntity.ok(questions);
    }
    
//    //method for adding single question
//    @PostMapping("/addQuestion")
//    public ResponseEntity<Question> addQuestion(@RequestBody Question question) {
//        Question addedQuestion = questionService.addQuestion(question);
//        return ResponseEntity.ok(addedQuestion);
//    }
    
    // method for adding multiple questions
    @PostMapping("/addQuestions")
    public ResponseEntity<List<Question>> addQuestions(@RequestBody List<Question> questions) {
        List<Question> addedQuestions = questionService.addQuestions(questions);
        return ResponseEntity.ok(addedQuestions);
    }
    
    @PutMapping("/updateQuestion/{id}")
    public ResponseEntity<Question> updateQuestion(@PathVariable Long id, @RequestBody Question updatedQuestion) {
        Question question = questionService.updateQuestion(id, updatedQuestion);
        if (question != null) {
            return ResponseEntity.ok(question);
        } else {
            return ResponseEntity.notFound().build();
        }
    }
    
    @DeleteMapping("/deleteQuestion/{id}")
    public ResponseEntity<String> deleteQuestion(@PathVariable Long id) {
        boolean isDeleted = questionService.deleteQuestion(id);
        if (isDeleted) {
            return ResponseEntity.ok("Question with ID " + id + " deleted successfully.");
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
