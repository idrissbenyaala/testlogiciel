package learnSpace.LearnSpace.Entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@AllArgsConstructor
@Entity
@NoArgsConstructor
@Data
public class Cour {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id;
    private String title;
    private String Contenu;
    @Transient
    @OneToMany(mappedBy = "cour",fetch = FetchType.LAZY)
    private List<ImageCour> imageCours;
}
