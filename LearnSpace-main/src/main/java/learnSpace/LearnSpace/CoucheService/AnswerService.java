package learnSpace.LearnSpace.CoucheService;

import jakarta.transaction.Transactional;
import learnSpace.LearnSpace.CoucheDAO.AnswerDao;
import learnSpace.LearnSpace.Entity.Answer;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@AllArgsConstructor
@Transactional
@Service
public class AnswerService implements AnswerInterface{
    @Autowired
    private AnswerDao answerDao;
    @Override
    public Answer addAnswer(Answer answer) {
        return answerDao.save(answer);
    }
    @Override
    public List<Answer> getAllAnswers() {
        return answerDao.findAll();
    }
    @Override
    public Optional<Answer> getAnswerById(Long id) {
        return answerDao.findById(id);
    }
    @Override
    public void deleteAnswer(Long id) {
        answerDao.deleteById(id);
    }
}
