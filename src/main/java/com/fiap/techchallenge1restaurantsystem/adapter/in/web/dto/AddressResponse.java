package com.fiap.techchallenge1restaurantsystem.adapter.in.web.dto;

import com.fiap.techchallenge1restaurantsystem.domain.user.Address;

public record AddressResponse(
        String street,
        String number,
        String city,
        String postalCode
) {

    public static AddressResponse from(Address address) {
        return new AddressResponse(address.getStreet(), address.getNumber(), address.getCity(), address.getPostalCode());
    }
}
