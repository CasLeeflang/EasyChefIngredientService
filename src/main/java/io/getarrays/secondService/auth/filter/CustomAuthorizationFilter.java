package io.getarrays.secondService.auth.filter;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.interfaces.DecodedJWT;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;

import static java.util.Arrays.stream;
import static org.springframework.http.HttpHeaders.AUTHORIZATION;

@Slf4j
public class CustomAuthorizationFilter extends OncePerRequestFilter {


    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        if(request.getServletPath().equals("/api/public")){
            filterChain.doFilter(request, response);
        }else {
            try {
                if (checkJWTToken(request, response)) {
                    String authorizationHeader = request.getHeader(AUTHORIZATION);
                    String token = authorizationHeader.substring("Bearer ".length());


                    if (token != null) {
                        setUpSpringAuthentication(token);
                    } else {
                        SecurityContextHolder.clearContext();
                    }
                } else {
                    SecurityContextHolder.clearContext();
                }
                filterChain.doFilter(request, response);
            } catch (Exception exception) {
                log.error(exception.getMessage());
            }
        }
    }

    private Claims validateToken(HttpServletRequest request) {
        String jwtToken = request.getHeader(AUTHORIZATION).replace("Bearer ", "");
        return Jwts.parser().setSigningKey("secret".getBytes()).parseClaimsJws(jwtToken).getBody();
    }


    private void setUpSpringAuthentication(String token) {
        Algorithm algorithm = Algorithm.HMAC256("secret".getBytes());
        // creates verifier object to verify tokens
        JWTVerifier verifier = JWT.require(algorithm).build();
        DecodedJWT decodedJWT = verifier.verify(token);

        String username = decodedJWT.getSubject();

        String[] roles = decodedJWT.getClaim("roles").asArray(String.class);
        Collection<SimpleGrantedAuthority> authorities = new ArrayList<>();
        stream(roles).forEach(role -> {
            authorities.add(new SimpleGrantedAuthority(role));
        });

        UsernamePasswordAuthenticationToken authenticationToken = new UsernamePasswordAuthenticationToken(username, null, authorities);
        SecurityContextHolder.getContext().setAuthentication(authenticationToken);


    }

    private boolean checkJWTToken(HttpServletRequest request, HttpServletResponse res) {
        String authenticationHeader = request.getHeader(AUTHORIZATION);
        if (authenticationHeader == null || !authenticationHeader.startsWith("Bearer "))
            return false;
        return true;
    }
}
