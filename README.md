# Question Answers API - springboot_question_answer

## Overview
This project implements a simple RESTful API to manage questions and their answers. It provides endpoints to fetch all questions from a PostgreSQL database. The application is built using Spring Boot and utilizes Spring Data JPA for database interactions.

## Data Model

1. Java 11
2. Spring Boot
3. Spring Data JPA
4. PostgreSQL
5. Maven
   
## Dependencies

1. Spring Boot Starter Web
2. Spring Boot Starter Data JPA
3. PostgreSQL Driver
4. Spring Boot devtools

## Features
- Fetch all questions from the database.
- Fetch by categories from the database.
- Exposes a clean and structured REST API for easy integration.

## Future Improvements

- Add support for creating and updating questions.
- Implement user authentication and authorization for secure endpoints.
- Add error handling and validation for input data.

## Setup and Installation
1. Clone the repository: `git clone https://github.com/ericmaniraguha/springboot_question_answer.git`
2. Navigate to the project directory: `cd question-answers-api`
3. Make sure you have PostgreSQL installed and running.
4. Update the database configuration in `application.properties` with your PostgreSQL credentials.
5. Build the application: `mvn clean install`
6. Run the application: `java -jar target/question-answers-api-1.0.0.jar`

 ## API Endpoints
 
`GET /api/questions: Fetch all questions.`

## Create a table in the database
`
CREATE TABLE IF NOT EXISTS question(
    id SERIAL PRIMARY KEY,
    category VARCHAR(255),
    difficult_level VARCHAR(50),
    option_1 VARCHAR(255),
    option_2 VARCHAR(255),
    option_3 VARCHAR(255),
    option_4 VARCHAR(255),
    question_title VARCHAR(255)
);`

## Insert dummy data in the table

`INSERT INTO question (category, difficult_level, option_1, option_2, option_3, option_4, question_title)
VALUES
    ('Science', 'Easy', 'A', 'B', 'C', 'D', 'What is the capital of France?'),
    ('History', 'Medium', 'Berlin', 'London', 'Paris', 'Rome', 'Which city was the first capital of the United States?'),
    ('Mathematics', 'Hard', '5', '10', '15', '20', 'What is 5 + 15?');`


`INSERT INTO question (category, difficult_level, option_1, option_2, option_3, option_4, question_title)
VALUES
    ('Science', 'Easy', 'A', 'B', 'C', 'D', 'What is the capital of France?'),
    ('History', 'Medium', 'Berlin', 'London', 'Paris', 'Rome', 'Which city was the first capital of the United States?'),
    ('Mathematics', 'Hard', '5', '10', '15', '20', 'What is 5 + 15?');`
    
## Data Model

The application uses the following data model for the `Question` entity:

```java
@Entity
public class Question {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "category")
    private String category;

    @Column(name = "difficult_level")
    private String difficultLevel;

    @Column(name = "option1")
    private String option1;

    @Column(name = "option2")
    private String option2;

    @Column(name = "option3")
    private String option3;

    @Column(name = "option4")
    private String option4;

    @Column(name = "question_title")
    private String questionTitle;

    // Getters and Setters (Manually defined)

    // Constructors (Manually defined)
}

`Contributing`

`Contributions are welcome! If you find any issues or want to suggest improvements, feel free to create a pull request or submit an issue.`
