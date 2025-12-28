package com.content.mgnt.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.*;

import java.util.HashSet;
import java.util.Set;

@Data
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class RegisterRequestDTO {
    @NotBlank(message = "Should not be null or empty.")
    @Size(min=5, max=20, message="Login id must be between 2-20 characters")
    private String loginId;

    @NotBlank(message = "Should not be null or empty.")
    @Size(min=5, max=20, message="Login id must be between 2-20 characters")
    private String password;

    @NotBlank(message = "Should not be null or empty.")
    @Size(min=10, max=50, message="Full name must be between 2-50 characters")
    private String fullName;

    @Email(message = "Provide valid email id")
    private String emailId;

    private int active;
    private String roles;
}
