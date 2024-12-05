package learnSpace.LearnSpace.CoucheWeb;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import learnSpace.LearnSpace.CoucheDTO.CourImageDTO;
import learnSpace.LearnSpace.CoucheService.CourInterface;
import learnSpace.LearnSpace.Entity.Cour;
import learnSpace.LearnSpace.Entity.ImageCour;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping(path = "cour")
@AllArgsConstructor
@CrossOrigin("*")
public class CourController {
    private CourInterface courInterface;
    @GetMapping(path="/GetCours")
    public List<Cour> ListCours(){return courInterface.GetAllCour();}
    @PostMapping("/AddCour")
    public ResponseEntity<?> AddCour(
            @RequestParam("CourRequestDto") String courRequestDto,
            @RequestParam("file") MultipartFile file) {
        System.out.println("xxxxxxxxxxxxxxxxxxxxxxx");
        try {
            // Vérification que les paramètres sont présents
            if (courRequestDto == null || courRequestDto.isEmpty()) {
                return ResponseEntity.badRequest().body("CourRequestDto is missing or empty");
            }

            if (file == null || file.isEmpty()) {
                return ResponseEntity.badRequest().body("File is missing or empty");
            }

            // Log pour tester les données reçues
            System.out.println("Received CourRequestDto: " + courRequestDto);
            System.out.println("Received file: " + file.getOriginalFilename());

            // Tentative de désérialisation pour valider la structure JSON
            try {
                ObjectMapper objectMapper = new ObjectMapper();
                Cour courDto = objectMapper.readValue(courRequestDto, Cour.class);

                // Log des données désérialisées pour validation
                System.out.println("Parsed CourRequestDto: " + courDto);

                // Test des champs du DTO
                if (courDto.getTitle() == null || courDto.getTitle().isEmpty()) {
                    return ResponseEntity.badRequest().body("Title is missing or empty in CourRequestDto");
                }

                if (courDto.getContenu() == null || courDto.getContenu().isEmpty()) {
                    return ResponseEntity.badRequest().body("Contenu is missing or empty in CourRequestDto");
                }
            } catch (JsonProcessingException e) {
                e.printStackTrace();
                return ResponseEntity.badRequest().body("Invalid JSON in CourRequestDto");
            }

            // Appeler la méthode d'ajout
            courInterface.AddCour(courRequestDto, file);

            return ResponseEntity.ok("Course added successfully!");
        } catch (IOException e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error processing request");
        }
    }

    @DeleteMapping(path="DeleteCour")
    public void DeleteCour(@RequestParam Long id)
    {
        courInterface.DeleteCour(id);
    }
    @PutMapping(path="UpdateCour/{id}")
    public void UpdateCour(@PathVariable  Long id, @RequestBody Cour updatedCour)
    {
        courInterface.UpdateCour(id,updatedCour);
    }
    @GetMapping(path="getImagesCour")
    public ImageCour getImagesByCourId(@RequestParam Long courId)
    {
        return  courInterface.getImagesByCourId(courId);
    }
    @GetMapping(path="GetImages")
    public List<ImageCour> Listelogo()throws IOException
    {
        return courInterface.ListeImages();
    }


}
