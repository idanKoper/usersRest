package M.S.Bit.usersRest.controller;

import M.S.Bit.usersRest.Service.UserService;
import M.S.Bit.usersRest.model.UserEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.NoSuchElementException;

@RestController
public class UserController {

    @Autowired
    private UserService service;

    @GetMapping("/GetAllUsers")
    public List<UserEntity> getAllUsers() {
        return service.listAll();
    }

    @GetMapping("/GetUser/{id}")
    public ResponseEntity<UserEntity> getUser(@PathVariable Integer id) {
        try {
            UserEntity user = service.get(id);
            return new ResponseEntity<>(user, HttpStatus.OK);
        } catch (NoSuchElementException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping("/CreateUser")
    public ResponseEntity<UserEntity> add(@RequestBody UserEntity user) {
        try {
            service.save(user);
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (NoSuchElementException e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @PutMapping("/UpdateUser/{id}")
    public ResponseEntity<?> update(@RequestBody UserEntity user, @PathVariable Integer id) {
        try {
            UserEntity existUser = service.get(id);
            service.save(user);
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (NoSuchElementException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

    }

    @DeleteMapping("/DeleteUser/{id}")
    public ResponseEntity<Void> delete(@PathVariable Integer id) {
        try {
            service.delete(id);
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (NoSuchElementException e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        catch (EmptyResultDataAccessException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

}
