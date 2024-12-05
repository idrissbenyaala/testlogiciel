package learnSpace.LearnSpace.CoucheDTO;

import learnSpace.LearnSpace.Entity.ImageCour;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@NoArgsConstructor
@Data
public class CourDto {
    private String Contenu;
    private String title;
    private List<ImageCour> images;
    public CourDto( String contenu,String titre, List<ImageCour> images) {
        this.Contenu = contenu;
        this.images = images;
        this.title=titre;
    }
}
