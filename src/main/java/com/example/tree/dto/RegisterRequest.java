package com.example.tree.dto;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class RegisterRequest {
    private String firstName;
    public String lastName;

    private String email;
    private String password;

    private Role role;

}
