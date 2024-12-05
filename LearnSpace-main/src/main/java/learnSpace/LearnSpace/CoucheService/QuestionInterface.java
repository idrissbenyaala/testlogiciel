package learnSpace.LearnSpace.CoucheService;

import learnSpace.LearnSpace.Entity.Question;

import java.util.List;
import java.util.Optional;

public interface QuestionInterface {
    public Question addQuestion(Question question);
    public List<Question> getAllQuestions();
    public Optional<Question> getQuestionById(Long id);
    public void deleteQuestion(Long id);
}
