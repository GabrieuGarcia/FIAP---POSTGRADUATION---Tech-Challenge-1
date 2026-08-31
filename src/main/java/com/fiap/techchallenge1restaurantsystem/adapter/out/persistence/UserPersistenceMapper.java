package com.fiap.techchallenge1restaurantsystem.adapter.out.persistence;

import com.fiap.techchallenge1restaurantsystem.domain.user.Address;
import com.fiap.techchallenge1restaurantsystem.domain.user.Email;
import com.fiap.techchallenge1restaurantsystem.domain.user.Password;
import com.fiap.techchallenge1restaurantsystem.domain.user.User;

import java.util.Date;

class UserPersistenceMapper {

    static UserEntity toEntity(User user) {
        UserEntity entity = new UserEntity();
        entity.setId(user.getId());
        entity.setName(user.getName());
        entity.setEmail(user.getEmail().getValue());
        entity.setPassword(user.getPassword().getValue());
        entity.setUserType(user.getUserType());
        entity.setLastUpdate(new Date());
        entity.setAddress(toAddressEntity(user.getAddress()));
        return entity;
    }

    static User toDomain(UserEntity entity) {
        return new User(
                entity.getId(),
                entity.getName(),
                new Email(entity.getEmail()),
                new Password(entity.getPassword()),
                toAddressDomain(entity.getAddress()),
                entity.getUserType()
        );
    }

    private static AddressEntity toAddressEntity(Address address) {
        AddressEntity entity = new AddressEntity();
        entity.setStreet(address.getStreet());
        entity.setNumber(address.getNumber());
        entity.setCity(address.getCity());
        entity.setPostalCode(address.getPostalCode());
        return entity;
    }

    private static Address toAddressDomain(AddressEntity entity) {
        return new Address(entity.getStreet(), entity.getNumber(), entity.getCity(), entity.getPostalCode());
    }
}
