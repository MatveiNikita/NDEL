package nikdev.ndel.authservice.services.impl;

import lombok.RequiredArgsConstructor;
import nikdev.ndel.authservice.dtos.LoginUserDto;
import nikdev.ndel.authservice.jwt.JwtService;
import nikdev.ndel.authservice.models.User;
import nikdev.ndel.authservice.repositories.UserRepository;
import nikdev.ndel.authservice.services.LoginService;
import nikdev.ndel.authservice.services.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

@Service
@RequiredArgsConstructor
public class LoginServiceImpl implements LoginService {

    private final UserRepository userRepository;
    private final JwtService jwtService;

    @Override
    public String login(LoginUserDto loginUserDto) {
        User user = userRepository.findByEmail(loginUserDto.email())
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Email : " + loginUserDto.email() + " doesn't exists"));
        if (!loginUserDto.password().equals(user.getPassword())){
            throw new ResponseStatusException(HttpStatus.CONFLICT, "Incorrect password");
        }
        return jwtService.createToken(user.getId());
    }
}
