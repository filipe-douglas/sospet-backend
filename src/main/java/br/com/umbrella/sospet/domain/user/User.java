package br.com.umbrella.sospet.domain.user;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Table(name = "clients")
@Entity(name = "clients")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(of = "id")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "first_name", nullable = false)
    private String firstName;

    @Column(name = "last_name", nullable = false)
    private String lastName;

    @Column(name = "email", nullable = false)
    private String email;

    @Column(name = "date_of_birth", nullable = false)
    private LocalDateTime dateOfBirth;

    private String cpf;

    public User(UserRequest data) {
        this.firstName = data.first_name();
        this.lastName = data.last_name();
        this.email = data.email();
        this.dateOfBirth = LocalDateTime.parse(data.date_of_birth(), DateTimeFormatter.ISO_DATE_TIME);
        this.cpf = data.cpf();
    }

}
