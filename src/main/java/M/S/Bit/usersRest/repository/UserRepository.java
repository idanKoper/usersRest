package M.S.Bit.usersRest.repository;
import M.S.Bit.usersRest.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository <User, Integer> {
}
