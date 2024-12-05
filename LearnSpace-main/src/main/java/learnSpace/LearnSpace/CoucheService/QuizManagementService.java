package learnSpace.LearnSpace.CoucheService;

import jakarta.transaction.Transactional;
import learnSpace.LearnSpace.CoucheDAO.AnswerDao;
import learnSpace.LearnSpace.CoucheDAO.QuestionDao;
import learnSpace.LearnSpace.CoucheDAO.QuizDao;
import learnSpace.LearnSpace.Entity.Answer;
import learnSpace.LearnSpace.Entity.Question;
import learnSpace.LearnSpace.Entity.Quiz;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@AllArgsConstructor
@Transactional
@Service
public class QuizManagementService {
    @Autowired
    private QuizDao quizDao;
    @Autowired
    private QuestionDao questionDao;
    @Autowired
    private AnswerDao answerDao;
    public Quiz createQuizWithQuestionsAndAnswers(Quiz quiz) {
        // Sauvegarde du quiz
        if (quiz.getQuestions() != null) {
            quiz.getQuestions().forEach(question -> {
                question.setQuiz(quiz); // Associer le quiz
                if (question.getAnswers() != null) {
                    question.getAnswers().forEach(answer -> answer.setQuestion(question));
                }
            });
        }
        return quizDao.save(quiz);
    }

}
