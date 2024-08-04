package com.ms.userpg.Model;

import com.ms.userpg.Entity.Role;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.Set;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class UserResponse {
    private int id;
    private String firstName;
    private String lastName;
    private String maidenName;
    private String gender;
    private String email;
    private String userName;
    private String image;
}
