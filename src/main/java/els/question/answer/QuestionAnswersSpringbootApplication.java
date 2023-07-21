package els.question.answer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;

@SpringBootApplication
@EntityScan(basePackages = "els.question.model")
public class QuestionAnswersSpringbootApplication {

	public static void main(String[] args) {
		SpringApplication.run(QuestionAnswersSpringbootApplication.class, args);
	}

}
