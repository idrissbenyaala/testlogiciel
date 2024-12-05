package learnSpace.LearnSpace.CoucheService;

import learnSpace.LearnSpace.Entity.Answer;

import java.util.List;
import java.util.Optional;

public interface AnswerInterface {
    public Answer addAnswer(Answer answer);
    public List<Answer> getAllAnswers();
    public Optional<Answer> getAnswerById(Long id);
    public void deleteAnswer(Long id);
}
