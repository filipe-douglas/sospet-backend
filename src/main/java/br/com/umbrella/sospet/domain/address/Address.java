package br.com.umbrella.sospet.domain.address;

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

@Entity(name = "addresses")
@Table(name = "addresses")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(of = "id")
public class Address {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Character cep;

    private String street;
    private String neighborhood;
    private String city;
    private String state;
    private Integer number;

    public Address(AddressRequest data) {
        this.cep = data.cep();
        this.street = data.street();
        this.neighborhood = data.neighborhood();
        this.city = data.city();
        this.state = data.state();
        this.number = data.number();
    }

}
