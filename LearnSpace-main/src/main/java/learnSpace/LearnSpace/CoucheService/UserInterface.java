package learnSpace.LearnSpace.CoucheService;

import learnSpace.LearnSpace.CoucheDAO.UserDAO;
import learnSpace.LearnSpace.CoucheDTO.UserDTO;
import learnSpace.LearnSpace.Entity.User;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


public interface UserInterface {
    public void AddUser(UserDTO userDTO) throws Exception;
    public List<User> GetAllUsers();
    public void DeleteUser(Long id);
}
