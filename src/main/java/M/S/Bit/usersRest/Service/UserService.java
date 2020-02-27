package M.S.Bit.usersRest.Service;

import M.S.Bit.usersRest.model.UserEntity;
import M.S.Bit.usersRest.repository.UserRepository;
import org.mindrot.jbcrypt.BCrypt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepo;

    public List<UserEntity> listAll()
    {
        return userRepo.findAll();
    }

    private String hashPassword(String plainTextPassword){
        return BCrypt.hashpw(plainTextPassword, BCrypt.gensalt());
    }

    public void save (UserEntity user){
        String passwordEncrypt = hashPassword(user.getPassword());
        user.setPassword(passwordEncrypt);
        userRepo.save(user);
    }

    public UserEntity get(Integer id){
        return userRepo.findById(id).get();
    }

    public void delete(Integer id){
        userRepo.deleteById(id);
    }

}
