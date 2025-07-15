package nikdev.ndel.authservice.mappers;

import nikdev.ndel.authservice.dtos.RegisterUserDto;
import nikdev.ndel.authservice.models.User;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface RegisterUserMapper {

    User toEntity(RegisterUserDto registerUserDto);
}
