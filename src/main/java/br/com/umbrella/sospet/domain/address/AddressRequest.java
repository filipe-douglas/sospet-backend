package br.com.umbrella.sospet.domain.address;

public record AddressRequest(Character cep, String street, String neighborhood, String city, String state, Integer number) {

}
