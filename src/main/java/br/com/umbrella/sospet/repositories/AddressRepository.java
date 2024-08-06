package br.com.umbrella.sospet.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.umbrella.sospet.domain.address.Address;

public interface AddressRepository extends JpaRepository<Address, Long> {

}
