package com.wsidomgate.accountservice.repository;

import com.wsidomgate.accountservice.model.ERole;
import com.wsidomgate.accountservice.model.Role;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
@Repository
public interface RoleRepository extends MongoRepository<Role,String> {

    Optional<Role> findByName(ERole name);

}
