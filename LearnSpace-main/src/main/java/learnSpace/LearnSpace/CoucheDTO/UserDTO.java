package learnSpace.LearnSpace.CoucheDTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class UserDTO {
    private String name;
    private String email;
    private String password;
}
