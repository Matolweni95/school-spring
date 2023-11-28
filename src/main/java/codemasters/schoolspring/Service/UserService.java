package codemasters.schoolspring.Service;
import java.util.List;
import codemasters.schoolspring.Models.User;

/**
 * @author Phathu Mandane 
 */


public interface UserService {
    
    User registerUser(User user);

    User getUserById(Long id);

    List<User> getAllUsers();

    User updateUser(User user, Long id);

    void deleteUser(Long id);
}
