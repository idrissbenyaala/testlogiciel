package learnSpace.LearnSpace.CoucheService;

import learnSpace.LearnSpace.CoucheDTO.CourDto;
import learnSpace.LearnSpace.Entity.Cour;
import learnSpace.LearnSpace.Entity.ImageCour;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

public interface CourInterface {
    public List<Cour> GetAllCour();
    public void AddCour(String contenu, MultipartFile File) throws IOException;
    public void DeleteCour(Long id);
    public void UpdateCour(Long id,Cour UpdatedCour);
    public ImageCour getImagesByCourId(Long courId);
    public List<ImageCour> ListeImages();
}
