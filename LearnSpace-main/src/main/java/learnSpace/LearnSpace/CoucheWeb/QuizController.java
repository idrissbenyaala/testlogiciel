package learnSpace.LearnSpace.CoucheWeb;

import learnSpace.LearnSpace.CoucheService.QuizInterface;
import learnSpace.LearnSpace.CoucheService.QuizManagementService;
import learnSpace.LearnSpace.CoucheService.QuizService;
import learnSpace.LearnSpace.Entity.Quiz;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "Quiz")
@AllArgsConstructor
@CrossOrigin("*")
public class QuizController {
    private QuizService quizService;
    private QuizManagementService quizManagementService;
    @GetMapping(path = "GetAllQuizzes")
    public ResponseEntity<List<Quiz>> getAllQuizzes() {
        return ResponseEntity.ok(quizService.getAllQuizzes());
    }

    @GetMapping(path="GetQuizById/{id}")
    public ResponseEntity<Quiz> getQuizById(@PathVariable Long id) {
        return quizService.getQuizById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }
    @PostMapping(path="AddQuiz")
    public ResponseEntity<Quiz> createQuiz(@RequestBody Quiz quiz) {
        return ResponseEntity.ok(quizManagementService.createQuizWithQuestionsAndAnswers(quiz));
    }

    // Supprimer un quiz
    @DeleteMapping(path="DeleteQuiz/{id}")
    public ResponseEntity<Void> deleteQuiz(@PathVariable Long id) {
        quizService.deleteQuiz(id);
        return ResponseEntity.noContent().build();
    }
}
