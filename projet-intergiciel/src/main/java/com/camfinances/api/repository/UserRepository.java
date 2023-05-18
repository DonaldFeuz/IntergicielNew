package com.camfinances.api.repository;

import org.springframework.stereotype.Repository;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import com.camfinances.api.model.User;

@Repository
public interface UserRepository extends CrudRepository<User, Long>{
    Optional<User> findByEmailAndMdp(String email, String motDePasse);
}
