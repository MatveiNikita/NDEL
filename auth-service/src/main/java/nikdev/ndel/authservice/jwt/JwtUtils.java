package nikdev.ndel.authservice.jwt;

import io.jsonwebtoken.*;
import io.jsonwebtoken.security.Keys;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.security.Key;
import java.util.Base64;
import java.util.Date;
import java.util.UUID;

@Component
public class JwtUtils {

    @Value("jwt.secret.key")
    private String SECRET_VALUE;
    @Value("jwt.expire.time")
    private long EXPIRE_TIME;
    private Key secretKey;

    @PostConstruct
    public void init(){
        byte[] keyBates = Base64.getDecoder().decode(SECRET_VALUE);
        this.secretKey = Keys.hmacShaKeyFor(keyBates);
    }

    public String generateJwtFromId(UUID uuid){
        Date now = new Date();
        Date expire = new Date(now.getTime() + EXPIRE_TIME);
        return Jwts.builder()
                .setSubject(uuid.toString())
                .setIssuedAt(now)
                .setExpiration(expire)
                .signWith(secretKey, SignatureAlgorithm.HS256)
                .compact();
    }

    public String getUserIdFromJwt(String token){
        return parseToken(token).getBody().getSubject();
    }

    public boolean validToken(String token){
        try {
            Date expiration = parseToken(token).getBody().getExpiration();
            return expiration.after(new Date());
        } catch (JwtException | IllegalArgumentException exception){
            return false;
        }
    }

    private Jws<Claims> parseToken(String token){
        return Jwts.parserBuilder()
                .setSigningKey(SECRET_VALUE)
                .build()
                .parseClaimsJws(token);
    }

    private String stripBearerPrefix(String token){
        if (token != null && token.startsWith("Bearer ")){
            return token.substring(7).trim();
        }
        return token;
    }
}
