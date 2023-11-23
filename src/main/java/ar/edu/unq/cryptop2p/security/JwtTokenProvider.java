
package ar.edu.unq.cryptop2p.security;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

import java.util.Base64;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;
import static  ar.edu.unq.cryptop2p.helpers.CurrentDateTime.*;

@Component
public class JwtTokenProvider {

    //private final String secretKey;
   // private final Long exp_date;
/*
    public JwtTokenProvider(@Value("${app.security.jwt.secret-key}") String secretKey,
                            @Value("${app.security.expiration-time}") Long exp_date){
        this.secretKey = secretKey;
        this.exp_date = exp_date;

    }
*/


    @Value("${app.security.jwt.secret-key}")
    private String secretKey;


    @PostConstruct
    protected void initialize(){
        secretKey = Base64.getEncoder().encodeToString(secretKey.getBytes());
    }


/*
    public String generateToken(UserDetails userDetails) {
        Map<String, Object> claims = new HashMap<>();
        var rol = userDetails.getAuthorities().stream().collect(Collectors.toList()).get(0);
        claims.put("rol", rol);
        return createToken(claims, userDetails.getUsername());
    }

    private String createToken(Map<String, Object> claims, String subject) {
        return Jwts
                .builder()
                .setClaims(claims)
                .setSubject(subject)
                .setIssuedAt(getTimeStamp())
                .setExpiration(getExpirationTime())
                .signWith(SignatureAlgorithm.HS256, secretKey)
                .compact();
    }
*/

    public String generateToken(Authentication authentication){
        String email = authentication.getName();
        Date now = new Date();

        String token = Jwts.builder()
                .setSubject(email)
                .setIssuedAt(getTimeStamp())
                .setExpiration(getExpirationTime())
                .signWith(SignatureAlgorithm.HS512, secretKey)
                .compact();
        return token;
    }

    public String getEmailFromJwt (String token){
        Claims claims = Jwts.parser()
                .setSigningKey(secretKey)
                .parseClaimsJws(token)
                .getBody();
        return claims.getSubject();
    }

    public Boolean validateToken(String token) {
        try {
            Jwts.parser().setSigningKey(secretKey).parseClaimsJws(token);
            return true;
        } catch (Exception ignored) {}
        return false;
    }
}
