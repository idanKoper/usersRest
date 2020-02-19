package M.S.Bit.usersRest.dao;

import M.S.Bit.usersRest.model.User;
import M.S.Bit.usersRest.repository.UserRepository;
import org.mindrot.jbcrypt.BCrypt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepo;

    public List<User> listAll()
    {
        return userRepo.findAll();
    }

    private String hashPassword(String plainTextPassword){
        return BCrypt.hashpw(plainTextPassword, BCrypt.gensalt());
    }

    public void save (User user){
        String passwordEncrypt = hashPassword(user.getPassword());
        user.setPassword(passwordEncrypt);
        userRepo.save(user);
    }

    public User get(Integer id){
        return userRepo.findById(id).get();
    }

    public void delete(Integer id){
        userRepo.deleteById(id);
    }

}
