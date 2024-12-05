package learnSpace.LearnSpace.Entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "quiz_completion")
@Data
public class QuizCompletion {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "user_id", nullable = false)
    private Long userId;

    @Column(name = "quiz_id", nullable = false)
    private Integer quizId;

    @Column(name = "completed", nullable = false)
    private Boolean completed = false;
}
