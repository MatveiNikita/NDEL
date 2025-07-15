package nikdev.ndel.authservice.models;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import nikdev.ndel.authservice.models.roles.Role;
import org.hibernate.annotations.CreationTimestamp;

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

    @NotBlank
    private String name;

    @NotBlank
    private String surname;

    @Email
    @Column(nullable = false, unique = true) //nullable - е допускает появления null в БД, а @NotNull в java программе
    private String email;

    @Column(nullable = false)
    private String password;
    
    private String phoneNumber;

    private Date dateOfBirth;
    @CreationTimestamp
    private LocalDateTime createdTime;
}
