package els.question.model;



import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

@Data
@Entity
public class Question {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "category")
    private String category;
    
    @Column(name = "difficult_level")
    private String difficultLevel;
    
    @Column(name = "option_1")
    private String option1;
    
    @Column(name = "option_2")
    private String option2;
    
    @Column(name = "option_3")
    private String option3;
    
    @Column(name = "option_4")
    private String option4;
    
    @Column(name = "question_title")
    private String questionTitle;
    
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	public String getDifficultLevel() {
		return difficultLevel;
	}
	public void setDifficultLevel(String difficultLevel) {
		this.difficultLevel = difficultLevel;
	}
	public String getOption1() {
		return option1;
	}
	public void setOption1(String option1) {
		this.option1 = option1;
	}
	public String getOption2() {
		return option2;
	}
	public void setOption2(String option2) {
		this.option2 = option2;
	}
	public String getOption3() {
		return option3;
	}
	public void setOption3(String option3) {
		this.option3 = option3;
	}
	public String getOption4() {
		return option4;
	}
	public void setOption4(String option4) {
		this.option4 = option4;
	}
	public String getQuestionTitle() {
		return questionTitle;
	}
	public void setQuestionTitle(String questionTitle) {
		this.questionTitle = questionTitle;
	}
	/**
	 * @param id
	 * @param category
	 * @param difficultLevel
	 * @param option1
	 * @param option2
	 * @param option3
	 * @param option4
	 * @param questionTitle
	 */
	public Question(Long id, String category, String difficultLevel, String option1, String option2, String option3,
			String option4, String questionTitle) {
		super();
		this.id = id;
		this.category = category;
		this.difficultLevel = difficultLevel;
		this.option1 = option1;
		this.option2 = option2;
		this.option3 = option3;
		this.option4 = option4;
		this.questionTitle = questionTitle;
	}
	/**
	 * 
	 */
	public Question() {
		super();
		// TODO Auto-generated constructor stub
	}

    
    
    
}
