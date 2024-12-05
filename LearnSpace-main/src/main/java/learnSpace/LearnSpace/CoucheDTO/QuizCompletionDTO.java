package learnSpace.LearnSpace.CoucheDTO;

import lombok.Data;

@Data
public class QuizCompletionDTO {
    private Long userId;
    private Integer quizId;
    private Boolean completed;
}