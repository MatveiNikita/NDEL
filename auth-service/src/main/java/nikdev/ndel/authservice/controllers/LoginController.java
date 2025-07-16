package nikdev.ndel.authservice.controllers;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import nikdev.ndel.authservice.dtos.LoginUserDto;
import nikdev.ndel.authservice.services.LoginService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/login")
@RequiredArgsConstructor
public class LoginController {

    private final LoginService loginService;

    @PostMapping
    public ResponseEntity<String> login(@Valid @RequestBody LoginUserDto loginUserDto){
        String token = loginService.login(loginUserDto);
        return ResponseEntity.ok(token);
    }
}
