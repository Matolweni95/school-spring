package codemasters.schoolspring.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.CrossOrigin;

import codemasters.schoolspring.Entity.User;
import codemasters.schoolspring.Repo.UserRepository;

@Service
@CrossOrigin
public class UserService {

    @Autowired
    private UserRepository repo;

     //create

     public void SaveUser(User user){
        repo.save(user);
    }

    //get User

    public User getUser(Integer id) {
        Optional<User> user = repo.findById(id);
            if(user.isPresent()){
                return user.get();
            }

            return new User();
    }

    //get all users

    public List<User> getAllUsers(){
        return (List<User>) repo.findAll();
    }
    
}
