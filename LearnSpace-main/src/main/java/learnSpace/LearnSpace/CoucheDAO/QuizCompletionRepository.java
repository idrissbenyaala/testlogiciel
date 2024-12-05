package learnSpace.LearnSpace.CoucheDAO;

import learnSpace.LearnSpace.Entity.QuizCompletion;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface QuizCompletionRepository extends JpaRepository<QuizCompletion, Long> {
    QuizCompletion findByUserIdAndQuizId(Long userId, Integer quizId);

    List<QuizCompletion> findByUserIdAndCompletedTrue(Long userId);
    // New method
}
