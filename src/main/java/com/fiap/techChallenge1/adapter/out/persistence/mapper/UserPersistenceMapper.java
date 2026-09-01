package com.fiap.techChallenge1.adapter.out.persistence.mapper;

import com.fiap.techChallenge1.adapter.out.persistence.entities.AddressEntity;
import com.fiap.techChallenge1.adapter.out.persistence.entities.UserEntity;
import com.fiap.techChallenge1.domain.user.Address;
import com.fiap.techChallenge1.domain.user.Email;
import com.fiap.techChallenge1.domain.user.Password;
import com.fiap.techChallenge1.domain.user.User;

import java.util.List;

class UserPersistenceMapper {

    static UserEntity toEntity(User user) {
        UserEntity entity = new UserEntity();
        entity.setId(user.getId());
        entity.setName(user.getName());
        entity.setEmail(user.getEmail().getValue());
        entity.setLogin(user.getLogin());
        entity.setPassword(user.getPassword().getValue());
        entity.setUserType(user.getUserType());
        entity.setLastModifiedDate(user.getLastModifiedDate());
        entity.setAddress(toAddressEntity(user.getAddress()));
        return entity;
    }

    static UserEntity updateEntity(UserEntity entity, User user) {
        entity.setName(user.getName());
        entity.setEmail(user.getEmail().getValue());
        entity.setLogin(user.getLogin());
        entity.setPassword(user.getPassword().getValue());
        entity.setUserType(user.getUserType());
        entity.setLastModifiedDate(user.getLastModifiedDate());
        updateAddressEntity(entity.getAddress(), user.getAddress());
        return entity;
    }

    static User toDomain(UserEntity entity) {
        return new User(
                entity.getId(),
                entity.getName(),
                new Email(entity.getEmail()),
                entity.getLogin(),
                new Password(entity.getPassword()),
                toAddressDomain(entity.getAddress()),
                entity.getUserType(),
                entity.getLastModifiedDate()
        );
    }

    static List<User> toDomain(List<UserEntity> entities) {
        return entities.stream().map(UserPersistenceMapper::toDomain).toList();
    }

    private static AddressEntity toAddressEntity(Address address) {
        AddressEntity entity = new AddressEntity();
        updateAddressEntity(entity, address);
        return entity;
    }

    private static void updateAddressEntity(AddressEntity entity, Address address) {
        entity.setStreet(address.getStreet());
        entity.setNumber(address.getNumber());
        entity.setCity(address.getCity());
        entity.setPostalCode(address.getPostalCode());
    }

    private static Address toAddressDomain(AddressEntity entity) {
        return new Address(entity.getStreet(), entity.getNumber(), entity.getCity(), entity.getPostalCode());
    }
}
