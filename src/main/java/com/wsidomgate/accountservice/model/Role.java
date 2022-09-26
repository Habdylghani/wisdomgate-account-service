package com.wsidomgate.accountservice.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collation = "rules")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Role {
    @Id
    private String id;
    private ERole name;
}
