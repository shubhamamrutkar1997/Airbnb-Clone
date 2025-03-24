package com.AirbnbClone.AirbnbClone.Entity;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import static jakarta.persistence.CascadeType.ALL;

@Entity
@Data  //annotation is a convenient way to generate boilerplate code for Java classes. such as getters and setters,
       //toString(), Hashcode().

@AllArgsConstructor // In Lombok, @AllArgsConstructor is an annotation that automatically generates a constructor
                    // with all the fields as parameters. This is particularly useful when you need to create
                    // an object with all its fields initialized.

@NoArgsConstructor  //In Lombok, the @NoArgsConstructor annotation is used to generate a no-argument constructor
                   // (a constructor without any parameters). It's particularly helpful when working with JPA
                   // entities or DTOs where a default constructor is often required.


public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // To generate the primary key
    private Long id;
    private String firstName;
    private String lastName;
    private String email;
    private String password;
}
