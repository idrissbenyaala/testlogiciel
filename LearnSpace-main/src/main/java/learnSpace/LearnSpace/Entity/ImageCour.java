package learnSpace.LearnSpace.Entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "ImageCour")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ImageCour {
    public ImageCour(String name,String type,byte[] picbyte,Cour cour)
    {
        this.name=name;
        this.type=type;
        this.picbyte=picbyte;
        this.cour=cour;
    }
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name="id")
    private Long id;
    @Column(name="name")
    private String name;
    @Column(name="type")
    private String type;
    @Column(name="picbyte",length = 500000)
    private byte[] picbyte;
    @ManyToOne
    @JoinColumn(name = "cour_id")
    private Cour cour;
}
