package topragservice.store.Sklad.token;
//
//import io.jsonwebtoken.Claims;
//import io.jsonwebtoken.Jwts;
//import io.jsonwebtoken.SignatureAlgorithm;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.beans.factory.annotation.Value;
//import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
//import org.springframework.security.core.Authentication;
//import org.springframework.stereotype.Component;
//import org.springframework.util.StringUtils;
//
//import javax.crypto.SecretKey;
//import javax.crypto.spec.SecretKeySpec;
//import javax.servlet.http.HttpServletRequest;
//import java.time.Instant;
//import java.util.Base64;
//import java.util.Collections;
//import java.util.Date;
//
//@Component
//public class TokenProvider {
//
//    @Value("${custom.token.expiration}")
//    private Long expiration;
//
//    @Value("${custom.token}")
//    private String secretKey;
//
//    private SecretKey secretKeySpec;
//
//    @Autowired
//    public TokenProvider(@Value("${custom.token}") String secretKey) {
//        byte[] decodedKey = Base64.getDecoder().decode(secretKey);
//        this.secretKeySpec = new SecretKeySpec(decodedKey, SignatureAlgorithm.HS512.getJcaName());
//    }
//
//    public String generateToken() {
//        Instant now = Instant.now();
//        Instant expiryDate = now.plusSeconds(expiration);
//
//        return Jwts.builder()
//                .setIssuedAt(Date.from(now))
//                .setExpiration(Date.from(expiryDate))
//                .signWith(SignatureAlgorithm.HS512, secretKeySpec)
//                .compact();
//    }
//
//    public boolean validateToken(String token) {
//        try {
//            Jwts.parser().setSigningKey(secretKeySpec).parseClaimsJws(token);
//            return true;
//        } catch (Exception e) {
//            return false;
//        }
//    }
//
//    public Authentication getAuthentication(String token) {
//        Claims claims = Jwts.parser()
//                .setSigningKey(secretKeySpec)
//                .parseClaimsJws(token)
//                .getBody();
//
//        // извлекаем имя пользователя из токена
//        String username = claims.getSubject();
//
//        if (StringUtils.hasText(username)) {
//            // возвращаем аутентификацию с правильными деталями пользователя
//            return new UsernamePasswordAuthenticationToken(username, null, Collections.emptyList());
//        }
//
//        return null;
//    }
//
//
//    public String resolveToken(HttpServletRequest request) {
//        String bearerToken = request.getHeader("Authorization");
//        if (StringUtils.hasText(bearerToken) && bearerToken.startsWith("Bearer ")) {
//            return bearerToken.substring(7);
//        }
//        return null;
//    }
//}
