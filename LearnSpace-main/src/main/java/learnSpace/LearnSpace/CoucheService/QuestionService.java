package learnSpace.LearnSpace.CoucheService;

import jakarta.transaction.Transactional;
import learnSpace.LearnSpace.CoucheDAO.QuestionDao;
import learnSpace.LearnSpace.Entity.Question;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@AllArgsConstructor
@Transactional
@Service
public class QuestionService implements QuestionInterface {
    @Autowired
    private QuestionDao questionDao;
    @Override
    public Question addQuestion(Question question) {
        return questionDao.save(question);
    }
    @Override
    public List<Question> getAllQuestions() {
        return questionDao.findAll();
    }
    @Override
    public Optional<Question> getQuestionById(Long id) {
        return questionDao.findById(id);
    }
    @Override
    public void deleteQuestion(Long id) {
        questionDao.deleteById(id);
    }
}
