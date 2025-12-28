package com.content.mgnt.security;

import com.content.mgnt.dto.LoginRequestDTO;
import com.content.mgnt.dto.LoginResponseDTO;
import com.content.mgnt.dto.RegisterRequestDTO;
import com.content.mgnt.dto.RegisterResponseDTO;
import com.content.mgnt.entity.User;
import com.content.mgnt.error.ContentException;
import com.content.mgnt.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;

@Service
@RequiredArgsConstructor
public class AuthService {

    private final AuthenticationManager authenticationManager;
    private final AuthUtil authUtil;
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    public LoginResponseDTO login(LoginRequestDTO loginRequestDTO)  throws Exception{
        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(loginRequestDTO.getLoginId(), loginRequestDTO.getPassword())
        );
        User user = (User) authentication.getPrincipal();
        String token = authUtil.generateAccessToken(user);
        return new LoginResponseDTO(user.getRecId(), user.getLoginId(), token, token, Boolean.FALSE, null);
    }

    // login controller
    public RegisterResponseDTO signup(RegisterRequestDTO registerRequestDTO) throws ContentException {
        User user = userRepository.findByLoginId(registerRequestDTO.getLoginId()).orElse(null);

        if(user != null) throw new ContentException("UserExist");

        user = User.builder()
                .loginId(registerRequestDTO.getLoginId())
                .fullName(registerRequestDTO.getFullName())
                .emailId(registerRequestDTO.getEmailId())
                .active(registerRequestDTO.getActive())
                .roles(registerRequestDTO.getRoles())
                .build();
        user.setPassword(passwordEncoder.encode(registerRequestDTO.getPassword()));
        user = userRepository.save(user);
        return new RegisterResponseDTO(user.getRecId(), user.getLoginId(), Boolean.FALSE, null);
    }
}
