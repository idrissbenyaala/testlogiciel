package learnSpace.LearnSpace.CoucheDAO;

import learnSpace.LearnSpace.Entity.ImageCour;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ImageCourDao extends JpaRepository<ImageCour,Long> {

    @Query("select i from ImageCour i where i.cour.id = ?1")
    ImageCour findByCour_Id(Long id);
}
