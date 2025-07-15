package nikdev.ndel.authservice.controllers;

import lombok.RequiredArgsConstructor;
import nikdev.ndel.authservice.dtos.RegisterUserDto;
import nikdev.ndel.authservice.services.RegisterService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/registration")
@RequiredArgsConstructor
public class RegisterController {

    private final RegisterService registerService;

    @PostMapping
    public ResponseEntity<?> register(@RequestBody RegisterUserDto registerUserDto){
        registerService.register(registerUserDto);
        return ResponseEntity.ok().build();
    }
}
