package learnSpace.LearnSpace.CoucheDTO;

import learnSpace.LearnSpace.Entity.ImageCour;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CourImageDTO {
    private Long id;
    private String title;
    private String contenu;
    private List<ImageCour> images;
}
