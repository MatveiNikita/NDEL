package nikdev.ndel.authservice.services.impl;

import lombok.RequiredArgsConstructor;
import nikdev.ndel.authservice.dtos.RegisterUserDto;
import nikdev.ndel.authservice.mappers.RegisterUserMapper;
import nikdev.ndel.authservice.models.User;
import nikdev.ndel.authservice.repositories.RegisterRepository;
import nikdev.ndel.authservice.services.RegisterService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class RegisterServiceImpl implements RegisterService {

    private final RegisterRepository registerRepository;
    private final RegisterUserMapper registerUserMapper;

    @Transactional
    @Override
    public void register(RegisterUserDto registerUserDto) {
        User user = registerUserMapper.toEntity(registerUserDto);
        registerRepository.register(user);
    }
}
