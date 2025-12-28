package com.content.mgnt.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.*;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

@Data
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class LoginRequestDTO {

    @NotBlank(message = "Should not be null or empty.")
    @Size(min=5, max=50, message="loginId can not be empty.")
    private String loginId;

    @NotBlank(message = "Should not be null or empty.")
    private String password;
}