package learnSpace.LearnSpace.CoucheService;

import learnSpace.LearnSpace.CoucheDAO.QuizCompletionRepository;
import learnSpace.LearnSpace.Entity.QuizCompletion;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class QuizCompletionService {

    @Autowired
    private QuizCompletionRepository quizCompletionRepository;

    // Mark a quiz as completed
    public void markQuizAsCompleted(Long userId, Integer quizId) {
        QuizCompletion quizCompletion = quizCompletionRepository.findByUserIdAndQuizId(userId, quizId);

        if (quizCompletion == null) {
            quizCompletion = new QuizCompletion();
            quizCompletion.setUserId(userId);
            quizCompletion.setQuizId(quizId);
        }

        quizCompletion.setCompleted(true);
        quizCompletionRepository.save(quizCompletion);
    }

    // Fetch completed quizzes for a user
    public List<QuizCompletion> getCompletedQuizzes(Long userId) {
        return quizCompletionRepository.findByUserIdAndCompletedTrue(userId);
    }
}
