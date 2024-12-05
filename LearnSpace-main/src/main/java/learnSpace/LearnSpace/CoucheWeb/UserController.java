package learnSpace.LearnSpace.CoucheWeb;

import learnSpace.LearnSpace.CoucheDTO.UserDTO;
import learnSpace.LearnSpace.CoucheService.UserInterface;
import learnSpace.LearnSpace.Entity.Cour;
import learnSpace.LearnSpace.Entity.User;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "User")
@AllArgsConstructor
@CrossOrigin("*")
public class UserController {
    private UserInterface userInterface;
    @PostMapping(path = "/AddUser")
    public ResponseEntity<?> AddUser(@RequestBody UserDTO userDTO)
    {
        try {
            userInterface.AddUser(userDTO);
            return ResponseEntity.ok("User added successfully");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Email already exists");
        }
    }
    @GetMapping(path="/GetAllUsers")
    public List<User> ListCours(){return userInterface.GetAllUsers();}
    @DeleteMapping(path="/DeleteUser")
    public void DeleteUser(@RequestParam Long id)
    {
        userInterface.DeleteUser(id);
    }
}
