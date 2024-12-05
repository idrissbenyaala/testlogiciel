package learnSpace.LearnSpace.CoucheService;

import learnSpace.LearnSpace.Entity.Quiz;
import java.util.List;
import java.util.Optional;

public interface QuizInterface {
    public Quiz addQuiz(Quiz quiz);
    public List<Quiz> getAllQuizzes();
    public Optional<Quiz> getQuizById(Long id);
    public void deleteQuiz(Long id);
}
