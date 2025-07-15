package nikdev.ndel.authservice.services;

import nikdev.ndel.authservice.dtos.LoginUserDto;

public interface LoginService {

    String login(LoginUserDto loginUserDto);
}