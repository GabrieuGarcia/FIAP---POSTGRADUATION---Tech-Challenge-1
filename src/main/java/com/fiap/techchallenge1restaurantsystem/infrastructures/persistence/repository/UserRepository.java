package com.fiap.techchallenge1restaurantsystem.infrastructures.persistence.repository;

import com.fiap.techchallenge1restaurantsystem.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface UserRepository extends JpaRepository<User, UUID> {



}
