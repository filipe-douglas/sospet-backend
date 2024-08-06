package br.com.umbrella.sospet.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.umbrella.sospet.domain.user.User;
import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> findByCpf(String cpf);
    Optional<User> findByEmail(String email);

}
