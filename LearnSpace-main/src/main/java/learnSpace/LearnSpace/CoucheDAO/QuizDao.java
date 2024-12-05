package learnSpace.LearnSpace.CoucheDAO;

import learnSpace.LearnSpace.Entity.ImageCour;
import learnSpace.LearnSpace.Entity.Quiz;
import org.springframework.data.jpa.repository.JpaRepository;

public interface QuizDao extends JpaRepository<Quiz,Long> {

}
