package nikdev.ndel.authservice.utils;

import lombok.RequiredArgsConstructor;
import nikdev.ndel.authservice.repositories.UserRepository;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import java.util.UUID;

@RequiredArgsConstructor
@Component
public class CustomLoadByEmail {

    private final UserRepository userRepository;

    public UserDetails loadUserByUsername(String uuid) throws UsernameNotFoundException {
        return userRepository.findById(UUID.fromString(uuid))
                .map(UserDetailsImpl::new)
                .orElseThrow(() -> new UsernameNotFoundException("User with id: " + uuid + " doesn't exists"));
    }
}
