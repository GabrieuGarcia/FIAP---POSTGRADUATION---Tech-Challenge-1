package com.fiap.techChallenge1.adapter.in.web.dto.response;

import com.fiap.techChallenge1.domain.user.Address;

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
