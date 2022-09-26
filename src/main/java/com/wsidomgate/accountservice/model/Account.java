package com.wsidomgate.accountservice.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Document("accounts")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Account {
    @Id
    private String id;
    private String firstName;
    private String lastName;
    private String username;
    private String password;
    private String email;
    private double rating;
    @DBRef
    private Set<Role> roles = new HashSet<>();
    List<Account> followerList;
    List<Post> posts;
    List<Question> questions;
    List<Solution> solutions;
    public Account(String username, String email, String password) {
        this.username = username;
        this.email = email;
        this.password = password;
    }
}
