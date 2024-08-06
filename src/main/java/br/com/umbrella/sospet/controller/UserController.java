package br.com.umbrella.sospet.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.umbrella.sospet.domain.user.User;
import br.com.umbrella.sospet.domain.user.UserRequest;
import br.com.umbrella.sospet.domain.user.UserResponse;
import br.com.umbrella.sospet.repositories.UserRepository;

@RestController
@RequestMapping("users")
public class UserController {

    @Autowired
    private UserRepository repository;

    @GetMapping
    public ResponseEntity getAll() {
        var allUser = repository.findAll();
        return ResponseEntity.ok(allUser);
    }

    @PostMapping
    public ResponseEntity<UserRequest> registerClient(@RequestBody UserRequest data) {

        Optional<User> userCpf = this.repository.findByCpf(data.cpf());
        Optional<User> userEmail = this.repository.findByEmail(data.email());

        if (userCpf.isPresent() && userEmail.isPresent()) {
            return ResponseEntity.ok().build();
        }
        
        User newUser = new User(data);
        repository.save(newUser);

        return ResponseEntity.ok(data);

    }

}
