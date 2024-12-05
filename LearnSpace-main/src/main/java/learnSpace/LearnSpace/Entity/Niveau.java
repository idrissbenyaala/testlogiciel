package learnSpace.LearnSpace.Entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@Entity
@NoArgsConstructor
@Data
public class Niveau {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long Niveau_id;
    private String nomN;
    @ManyToOne
    @JoinColumn(name = "Quiz_id")
    private Quiz Quizid;
    private Long demarche;
    private Long NombreQ;
    @ManyToOne
    @JoinColumn(name = "Cour_id")
    private Cour courId;
}
