package learnSpace.LearnSpace.CoucheWeb;

import learnSpace.LearnSpace.CoucheService.QuizCompletionService;
import learnSpace.LearnSpace.Entity.QuizCompletion;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("quiz")
public class QuizCompletionController {

    @Autowired
    private QuizCompletionService quizCompletionService;

    // Fetch completed quizzes for the authenticated user
    @GetMapping("/completed")
    public ResponseEntity<List<Integer>> getCompletedQuizzes() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if (authentication == null) {
            System.out.println("No authentication found"); // Debugging step
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
        } else {
            System.out.println("Authentication details: " + authentication.toString());
            System.out.println("User name: " + authentication.getName());
        }


        System.out.println("Authenticated user: " + authentication.getName());
        Long userId = Long.valueOf(authentication.getName()); // Assuming the username is userId
        List<QuizCompletion> completedQuizzes = quizCompletionService.getCompletedQuizzes(userId);
        List<Integer> completedQuizIds = completedQuizzes.stream()
                .map(QuizCompletion::getQuizId)
                .collect(Collectors.toList());
        return ResponseEntity.ok(completedQuizIds);
    }


    @PostMapping("/complete")
    public ResponseEntity<Void> markQuizAsCompleted(@RequestParam Integer quizId) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        Long userId = Long.valueOf(authentication.getName()); // Assuming username is userId
        System.out.println("User " + userId + " completed quiz " + quizId); // Debug log
        quizCompletionService.markQuizAsCompleted(userId, quizId);
        return ResponseEntity.ok().build();
    }

}
