package learnSpace.LearnSpace.CoucheService;

import learnSpace.LearnSpace.CoucheDAO.UserDAO;
import learnSpace.LearnSpace.CoucheDTO.UserDTO;
import learnSpace.LearnSpace.Entity.Cour;
import learnSpace.LearnSpace.Entity.User;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@AllArgsConstructor
@Transactional
@Service
public class UserService implements UserInterface{
    private UserDAO userDAO;
    private org.springframework.security.provisioning.JdbcUserDetailsManager JdbcUserDetailsManager;
    private org.springframework.security.crypto.password.PasswordEncoder PasswordEncoder;
    @Override
    public void AddUser(UserDTO userDTO) throws Exception {
        User user = new User();
        user.setEmail(userDTO.getEmail());
        user.setName(userDTO.getName());
        String encodedPassword = PasswordEncoder.encode(userDTO.getPassword());
        user.setPassword(encodedPassword);
        JdbcUserDetailsManager.createUser(
                org.springframework.security.core.userdetails.User
                        .withUsername(userDTO.getEmail())
                        .password(encodedPassword)
                        .authorities("CLIENT")
                        .build()
        );
        userDAO.save(user);
    }
    public boolean EmailExists(String email) {
        return userDAO.findByEmail(email).isPresent(); // Supposant une méthode dans UserRepository
    }
    @Override
    public List<User> GetAllUsers() {
        List<User> users=userDAO.findAll();
        return users;
    }
    @Override
    public void DeleteUser(Long id)
    {
        User user=userDAO.findById(id).get();
        userDAO.deleteById(id);
    }
}
