package com.wsidomgate.accountservice.repository;

import com.wsidomgate.accountservice.model.Account;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface AccountRepository extends MongoRepository<Account, String> {

    Boolean existsByUsername(String username);

    Boolean existsByEmail(String email);

    Optional<Account> findByUsername(String username);
    //List<Account> findAccountsByRatingGreaterThanEqual(Integer 5);
}
