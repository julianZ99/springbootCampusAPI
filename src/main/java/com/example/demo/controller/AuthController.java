package com.example.demo.controller;

import java.util.Optional;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.ObjectUtils;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.models.entity.User;
import com.example.demo.models.view.LoginDTO;
import com.example.demo.models.view.LoginResponse;
import com.example.demo.models.view.RegistrationDTO;
import com.example.demo.models.view.UserDTO;
import com.example.demo.service.AuthService;
import com.example.demo.service.JwtService;
import com.example.demo.service.UserService;

@RestController
@RequestMapping("/auth")
public class AuthController {
    private final UserService userService;
    private final JwtService jwtService;
    private final AuthService authService;

    public AuthController(UserService userService, JwtService jwtService, AuthService authService) {
        this.userService = userService;
        this.jwtService = jwtService;
        this.authService = authService;
    }

    @PostMapping(value = "/register")
    public ResponseEntity<UserDTO> registerUser(@RequestBody RegistrationDTO RegistrationDTO) {
        HttpHeaders headers = new HttpHeaders();
        Optional<User> existsMail = userService.findByEmail(RegistrationDTO.getEmail());
        if (ObjectUtils.isEmpty(existsMail)) {
                User savedUser = authService.signup(RegistrationDTO);
                if (savedUser == null) {
                    headers.add("Header", "FAIL");
                    return new ResponseEntity<>(headers, HttpStatus.CONFLICT);
                }
                headers.add("Header", "OK");
                UserDTO userResponse = userService.getBasicDataUserDTO(savedUser);
                return new ResponseEntity<>(userResponse, headers, HttpStatus.OK);
            } else {
                headers.add("Header", "FAIL");
                headers.add("Error-Message", "This email is already registered. It is not possible to create the user.");
                return new ResponseEntity<>(headers, HttpStatus.CONFLICT);
            }
    }

    @PostMapping("/login")
    public ResponseEntity<LoginResponse> authenticate(@RequestBody LoginDTO loginUserDto) {
        User authenticatedUser = authService.authenticate(loginUserDto);

        String jwtToken = jwtService.generateToken(authenticatedUser);
        Long jwtExp = jwtService.getExpirationTime();

        LoginResponse loginResponse = new LoginResponse(jwtToken, jwtExp);

        return ResponseEntity.ok(loginResponse);
    }

}
