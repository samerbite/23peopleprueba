package people.cl.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;
import people.cl.Dto.JwtResponse;
import people.cl.configuration.JwtTokenUtil;
import people.cl.service.JwtServiceImpl;

@RestController
@CrossOrigin
@RequestMapping(value ="/23people/api", headers = {
        "Content-Type=application/json",
        "Accept=application/json"
})
public class JwtController {
    @Autowired
    private AuthenticationManager authenticationManager;
    @Autowired
    private JwtTokenUtil jwtTokenUtil;
    @Autowired
    private JwtServiceImpl jwtService;

    @GetMapping(value = "/autenticate")
    public ResponseEntity<?> createAuthenticationToken(){
        String username = "pancho";
        UserDetails userDetails = jwtService.loadUserByUsername(username);
        String token = jwtTokenUtil.generateToken(userDetails);
        return ResponseEntity.ok(new JwtResponse(token));

    }
}
