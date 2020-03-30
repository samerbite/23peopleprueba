package people.cl.service;

import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class JwtServiceImpl implements UserDetailsService {
    @Override
    public UserDetails loadUserByUsername(String username){

        return new User(username, "23people", new ArrayList<>());
        }
}
