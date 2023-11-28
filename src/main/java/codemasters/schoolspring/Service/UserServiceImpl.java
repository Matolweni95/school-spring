package codemasters.schoolspring.Service;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import codemasters.schoolspring.Models.User;
import codemasters.schoolspring.Repo.UserRepository;

/**
 * @author Phathu Mandane 
 */


@Service
public class UserServiceImpl implements UserService{
    @Autowired
    private UserRepository userRepository;

    //private final String FILE_PATH = "C:\\Users\\User\\Desktop\\users\\src\\main\\images";

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public User registerUser(User user) {
    // Check if the user object or email is null
    if (user == null || user.getEmail() == null) {
        try {
            throw new Exception("User or email cannot be null");
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
    
    return userRepository.save(user);
}


    @Override
    public User getUserById(Long id) {

        return userRepository.findById(id)
        .orElseThrow(() -> new UsernameNotFoundException("User not found with"+id));
    }

    // private boolean userAlreadyExists(String emailId) {

    //     return userRepository.findByEmailId(emailId).isPresent();
    // }

    @Override
    public List<User> getAllUsers() {

        return (List<User>) userRepository.findAll();
    }

    @Override
    public User updateUser(User user, Long id) {

        return userRepository.findById(id).map(existingUser -> {
            existingUser.setName(user.getName());
            existingUser.setEmail(user.getEmail());
            //existingUser.setRole(user.getRole());
            //existingUser.setAvatarURL(user.getAvatarURL());
            return userRepository.save(existingUser);
        }).orElseThrow(() -> new UsernameNotFoundException("User could not be found!")); // Handle the case when the Optional is empty
    }


    @Override
    public void deleteUser(Long id) {
    if (!userRepository.existsById(id)) {
        try {
            throw new Exception("User not found!");
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
    userRepository.deleteById(id);
    }


    // @Override
    // public Optional<User> findByEmail(String email) {
    //     // TODO Auto-generated method stub
    //     throw new UnsupportedOperationException("Unimplemented method 'findByEmail'");
    // }

    public Optional<User> findByEmail(String email){

        return userRepository.findByEmail(email);
        
    }





    
} 
