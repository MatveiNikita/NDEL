package nikdev.ndel.authservice.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import nikdev.ndel.authservice.models.roles.Role;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.UUID;

@Entity
@Table(name = "users")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;
    @Enumerated(EnumType.STRING)
    private Role role;
    private String name;
    private String surname;
    private String email;
    private String password;
    private String phoneNumber;
    private Date dateOfBirth;
    private LocalDateTime createdTime;
}
