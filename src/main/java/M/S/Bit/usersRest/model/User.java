package M.S.Bit.usersRest.model;
import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

enum Gender{
    M,F,O
}
@Entity
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @NotEmpty(message = "First Name may not be empty")
    @Size(min = 1, max = 20)
    private String first_name;

    @NotEmpty(message = "Last Name may not be empty")
    @Size(min = 1, max = 80)
    private String last_name;

    @Pattern(regexp=".+@.+\\..+", message="Please provide a valid email address")
    private String email;

    @Enumerated(EnumType.STRING)
    private Gender gender;

    private String password;

    public User() {
    }

    public User(Integer id, String email, String firstName, String lastName, Gender gender, String password) {
        this.id = id;
        this.email = email;
        this.first_name = firstName;
        this.last_name = lastName;
        this.gender = gender;
        this.password = password;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getFirst_name() {
        return first_name;
    }

    public void setFirst_name(String firstName) {
        this.first_name = firstName;
    }

    public String getLast_name() {
        return last_name;
    }

    public void setLast_name(String lastName) {
        this.last_name = lastName;
    }

    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
