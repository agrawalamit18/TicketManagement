package com.content.mgnt.controller;


import com.content.mgnt.dto.Error;
import com.content.mgnt.dto.LoginRequestDTO;
import com.content.mgnt.dto.LoginResponseDTO;
import com.content.mgnt.dto.RegisterRequestDTO;
import com.content.mgnt.dto.RegisterResponseDTO;
import com.content.mgnt.error.ContentException;
import com.content.mgnt.repository.UserRepository;
import com.content.mgnt.security.AuthService;
import jakarta.validation.Valid;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@Getter
@Setter
@RequiredArgsConstructor
@RequestMapping("/user")
public class AdminController {
    public final UserRepository userRepository;
    public final AuthService authService;

    @PostMapping("/login")
    public ResponseEntity<LoginResponseDTO> login(@Valid @RequestBody LoginRequestDTO loginRequestDTO) {
        LoginResponseDTO loginResponseDTO = null;
        try {
            loginResponseDTO = authService.login(loginRequestDTO);
        } catch (Exception e) {
            List<Error> errors = new ArrayList<Error>();
            errors.add(new Error(e.getMessage(),
                    "Incorrect login credential. Please try again."));
            loginResponseDTO = new LoginResponseDTO(0, null,null,null,
                    Boolean.TRUE,errors);
        }
        return ResponseEntity.ok(loginResponseDTO);
    }

    @PostMapping("/create")
    public ResponseEntity<RegisterResponseDTO> create(@Valid @RequestBody RegisterRequestDTO registerRequestDTO) {
        //RegisterResponseDTO response = new RegisterResponseDTO (1,registerRequestDTO.getLoginId());
        RegisterResponseDTO response = null;
        try {
            response = authService.signup(registerRequestDTO);
        } catch (ContentException e) {
            List<Error> errors = new ArrayList<Error>();
            errors.add(new Error(e.getMessage(), "Error occurred"));
            response = new RegisterResponseDTO(0, null,
                    Boolean.TRUE, errors);
        } catch (Exception e) {
            List<Error> errors = new ArrayList<Error>();
            errors.add(new Error(e.getMessage(), "Error occurred"));
            response = new RegisterResponseDTO(0, null,
                    Boolean.TRUE,errors);
        }
        return ResponseEntity.ok(response);
    }

    @PostMapping("/update")
    public String update(@RequestBody String onboardDoctorRequestDto) {
        return "update";
    }

    @GetMapping("/getUserDetails/{userId}")
    public String getUserDetails(@PathVariable Long userId) {
        return "getUserDetails "  + userId;
    }

    @GetMapping("/deactivate/{userId}")
    public String deactivate(@PathVariable Long userId) {
        return "deactivate " + userId;
    }

    @GetMapping("/activate/{userId}")
    public String activate(@PathVariable Long userId) {
        return "activate " + userId;
    }
}
