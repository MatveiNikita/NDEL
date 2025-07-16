package nikdev.ndel.authservice.jwt;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@RequiredArgsConstructor
public class JwtService {

    private final JwtUtils jwtUtils;

    public String createToken(UUID id){
        return jwtUtils.generateJwtFromId(id);
    }

    public boolean validToke(String token){
        return jwtUtils.validToken(token);
    }

    public String extractUserId(String token){
        return jwtUtils.getUserIdFromJwt(token);
    }

    public String stripBearerPrefix(String token){
        return jwtUtils.stripBearerPrefix(token);
    }
}
