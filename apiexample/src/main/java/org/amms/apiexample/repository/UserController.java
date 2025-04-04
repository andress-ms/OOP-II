package org.amms.apiexample.repository;

import org.amms.apiexample.models.User;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping
public class UserController {
    private final UserRepository userRepository;

    public UserController(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @GetMapping
    public List<User> obtainAll(){
        return userRepository.findAll();
    }

    @GetMapping("/{id}")
    public Optional<User> obtainById(@PathVariable long id) {
        return userRepository.findById(id);
    }

    @PostMapping
    public User create(@RequestBody User user) {
        return userRepository.save(user);
    }

    @PutMapping("/{id}")
    public User update(@PathVariable long id, @RequestBody User newUser) {
        return userRepository.findById(id).map(user -> {
            user.setName(newUser.getName());
            user.setEmail(newUser.getEmail());
            return userRepository.save(user);
        }).orElseGet(()->{
            newUser.setId(id);
            return userRepository.save(newUser);
        });
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable long id) {
        userRepository.deleteById(id);
    }
}
