package els.question.answer.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import els.question.model.Question;

@Repository
public interface QuestionRepository extends JpaRepository<Question, Long> {

}
