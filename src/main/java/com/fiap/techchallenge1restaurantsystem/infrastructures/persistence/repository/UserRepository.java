package com.fiap.techchallenge1restaurantsystem.infrastructures.persistence.repository;

import com.fiap.techchallenge1restaurantsystem.infrastructures.persistence.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface UserRepository extends JpaRepository<UserEntity, UUID> {



}
