package learnSpace.LearnSpace.CoucheDAO;

import learnSpace.LearnSpace.Entity.ImageCour;
import learnSpace.LearnSpace.Entity.Question;
import org.springframework.data.jpa.repository.JpaRepository;

public interface QuestionDao extends JpaRepository<Question,Long> {
}
