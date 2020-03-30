package people.cl.service;


import org.springframework.security.core.userdetails.UserDetails;

public interface JwtService{
    UserDetails loadUserByUsername(String username);
}
