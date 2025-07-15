package nikdev.ndel.authservice.services;

import nikdev.ndel.authservice.dtos.RegisterUserDto;

public interface RegisterService {

    void register(RegisterUserDto registerUserDto);
}
