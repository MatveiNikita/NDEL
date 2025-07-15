package nikdev.ndel.authservice.dtos;

public record RegisterUserDto(
        String name,
        String surname,
        String email,
        String password,
        String phoneNumber,
        String dateOfBirth
) {
}
