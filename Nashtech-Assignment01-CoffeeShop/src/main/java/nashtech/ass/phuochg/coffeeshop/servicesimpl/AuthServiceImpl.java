package nashtech.ass.phuochg.coffeeshop.servicesimpl;

import nashtech.ass.phuochg.coffeeshop.dto.LoginRequest;
import nashtech.ass.phuochg.coffeeshop.dto.SignupRequest;
import nashtech.ass.phuochg.coffeeshop.entities.Account;
import nashtech.ass.phuochg.coffeeshop.entities.Information;
import nashtech.ass.phuochg.coffeeshop.entities.Roles;
import nashtech.ass.phuochg.coffeeshop.exceptions.handlers.ResourceFoundExceptions;
import nashtech.ass.phuochg.coffeeshop.repositories.AccountRepository;
import nashtech.ass.phuochg.coffeeshop.repositories.InfomationRepository;
import nashtech.ass.phuochg.coffeeshop.repositories.RolesRepository;
import nashtech.ass.phuochg.coffeeshop.response.JwtResponse;
import nashtech.ass.phuochg.coffeeshop.response.MessageResponse;
import nashtech.ass.phuochg.coffeeshop.security.jwt.JwtUtils;
import nashtech.ass.phuochg.coffeeshop.security.services.UserDetailsImpl;
import nashtech.ass.phuochg.coffeeshop.services.AuthService;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
@Component
public class AuthServiceImpl implements AuthService {
     @Autowired
	AuthenticationManager authenticationManager;
     @Autowired
     AccountRepository accountRepository;
     @Autowired
     RolesRepository roleRepository;
     @Autowired
     PasswordEncoder encoder;
     @Autowired     
     JwtUtils jwtUtils;
     @Autowired
     InfomationRepository infomationRepository;
     @Autowired
     ModelMapper modelMapper;


    @Override
    public ResponseEntity<?> authenticateUser(LoginRequest loginRequest) {
        // TODO Auto-generated method stub
        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(loginRequest.getEmail() , loginRequest.getPassword()));
        SecurityContextHolder.getContext().setAuthentication(authentication);
        String jwt = jwtUtils.generateJwtToken(authentication);

        UserDetailsImpl userDetails = (UserDetailsImpl) authentication.getPrincipal();
        List<String> roles = userDetails.getAuthorities().stream()
                .map(item -> item.getAuthority())
                .collect(Collectors.toList());
        return ResponseEntity.ok(new JwtResponse(jwt,
                userDetails.getId(),
                userDetails.getUsername(),
                roles.get(0)));
    }
    @Override
    public ResponseEntity<?> signup(SignupRequest signUpRequest) {
        // TODO Auto-generated method stub
        Optional<Account> optionalAcc = accountRepository.findByEmail(signUpRequest.getEmail());
        if (((Optional<?>) optionalAcc).isPresent()){
            return ResponseEntity
                    .badRequest()
                    .body(new MessageResponse("Error: Username is already taken!"));
        }

        // Create new user's account
        Account user = new Account(signUpRequest.getEmail(),
                encoder.encode(signUpRequest.getPassword()));

        String role = signUpRequest.getRole();

        Optional<Roles> optional =  roleRepository.findById(Long.parseLong(role));
        if(optional.isPresent()) {
            Roles r = optional.get();
            user.setRole(r);
           user = accountRepository.save(user);
          
           Information information = modelMapper.map(signUpRequest, Information.class);
           information.setAccount(user);
           infomationRepository.save(information);

            return ResponseEntity.ok(new MessageResponse("User registered successfully!"));
        }
        throw new ResourceFoundExceptions("Role not found");
    }
}
