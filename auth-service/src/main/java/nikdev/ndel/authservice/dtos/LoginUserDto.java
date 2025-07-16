package nikdev.ndel.authservice.dtos;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;

public record LoginUserDto(
        @Email
        @NotBlank
        String email,
        @NotBlank
        String password
) {
}
