package learnSpace.LearnSpace.CoucheDAO;

import learnSpace.LearnSpace.Entity.Answer;
import learnSpace.LearnSpace.Entity.ImageCour;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AnswerDao extends JpaRepository<Answer,Long> {
}
