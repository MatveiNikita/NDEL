package nikdev.ndel.authservice.repositories;

import nikdev.ndel.authservice.models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface RegisterRepository extends JpaRepository<User, UUID> {

    @Modifying
    @Query(value = "INSERT INTO users (id, role, name, surname, email, password, phone_number, date_of_birth, created_time) " +
            "VALUES (:#{#u.id}, :#{#u.role.name()}, :#{#u.name}, :#{#u.surname}, :#{#u.email}, :#{#u.password}, :#{#u.phoneNumber}, :#{#u.dateOfBirth}, :#{#u.createdTime})",
            nativeQuery = true)
    void register(User registerUser);
}
