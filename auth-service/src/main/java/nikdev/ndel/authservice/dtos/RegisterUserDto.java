package nikdev.ndel.authservice.dtos;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;

public record RegisterUserDto(
        @NotBlank
        String name,
        @NotBlank
        String surname,
        @NotBlank
        @Email
        String email,
        @NotBlank
        String password,
        @NotBlank
        String phoneNumber,
        @NotBlank
        String dateOfBirth
) {
}
