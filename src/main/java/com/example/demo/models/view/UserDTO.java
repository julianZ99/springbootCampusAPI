package com.example.demo.models.view;

import com.example.demo.models.entity.User;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserDTO {

    private Long id;
    private String email;
    private String firstname;
    private String lastname;

    public UserDTO(User user) {
        this.id=user.getId();
        this.firstname=user.getFirstname();
        this.lastname=user.getLastname();
        this.email=user.getEmail();
    }
}
