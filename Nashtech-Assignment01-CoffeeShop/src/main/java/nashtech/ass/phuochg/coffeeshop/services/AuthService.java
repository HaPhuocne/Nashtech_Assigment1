package nashtech.ass.phuochg.coffeeshop.services;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import nashtech.ass.phuochg.coffeeshop.dto.LoginRequest;
import nashtech.ass.phuochg.coffeeshop.dto.SignupRequest;

@Service
public interface AuthService {
    public ResponseEntity<?> authenticateUser(LoginRequest loginRequest);
    public ResponseEntity<?>  signup(SignupRequest signupRequest);
}
