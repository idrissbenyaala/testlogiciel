package learnSpace.LearnSpace.CoucheService;

import jakarta.transaction.Transactional;
import learnSpace.LearnSpace.CoucheDAO.QuizDao;
import learnSpace.LearnSpace.Entity.Quiz;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@AllArgsConstructor
@Transactional
@Service
public class QuizService implements QuizInterface{
    @Autowired
    private QuizDao quizDao;
    @Override
    public Quiz addQuiz(Quiz quiz) {
        return quizDao.save(quiz);
    }
    @Override
    public List<Quiz> getAllQuizzes() {
        return quizDao.findAll();
    }
    @Override
    public Optional<Quiz> getQuizById(Long id) {
        return quizDao.findById(id);
    }
    @Override
    public void deleteQuiz(Long id) {
        quizDao.deleteById(id);
    }
}
