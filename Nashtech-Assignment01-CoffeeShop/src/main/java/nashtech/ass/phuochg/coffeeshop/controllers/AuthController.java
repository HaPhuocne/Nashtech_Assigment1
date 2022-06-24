package nashtech.ass.phuochg.coffeeshop.controllers;

import java.util.List;
import java.util.Optional;

import java.util.stream.Collectors;

import javax.validation.Valid;

import nashtech.ass.phuochg.coffeeshop.entities.Account;
import nashtech.ass.phuochg.coffeeshop.entities.Information;
import nashtech.ass.phuochg.coffeeshop.entities.Roles;
import nashtech.ass.phuochg.coffeeshop.repositories.AccountRepository;
import nashtech.ass.phuochg.coffeeshop.repositories.InfomationRepository;
import nashtech.ass.phuochg.coffeeshop.repositories.RolesRepository;
import nashtech.ass.phuochg.coffeeshop.request.LoginRequest;
import nashtech.ass.phuochg.coffeeshop.request.SignupRequest;
import nashtech.ass.phuochg.coffeeshop.response.JwtResponse;
import nashtech.ass.phuochg.coffeeshop.response.MessageResponse;
import nashtech.ass.phuochg.coffeeshop.security.jwt.JwtUtils;
import nashtech.ass.phuochg.coffeeshop.security.services.UserDetailsImpl;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@EnableAutoConfiguration
@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/auth")
public class AuthController {

    final private AuthenticationManager authenticationManager;
   
    final private AccountRepository accounrR;

    final private RolesRepository roleRepository;
    
    final private InfomationRepository infomationRepository;

    final private PasswordEncoder encoder;

    final private JwtUtils jwtUtils;

    public AuthController (AuthenticationManager authenticationManager, AccountRepository accounrR,
    		RolesRepository roleRepository, PasswordEncoder encoder, JwtUtils jwtUtils ,InfomationRepository infomationRepository) {
        this.authenticationManager = authenticationManager;
        this.accounrR = accounrR;
        this.roleRepository = roleRepository;
		this.infomationRepository = infomationRepository;
        this.encoder = encoder;
        this.jwtUtils = jwtUtils;
    }

    @PostMapping("/signin")
    public ResponseEntity<?> authenticateUser(@Valid @RequestBody LoginRequest loginRequest) {

        // TODO, authenticate when login
        // Username, pass from client
        // com.nashtech.rookies.security.WebSecurityConfig.configure(org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder)
//        authenticationManagerBuilder.userDetailsService(userDetailsService).passwordEncoder(passwordEncoder());
        // on this step, we tell to authenticationManager how we load data from database
        // and the password encoder
        Authentication authentication = authenticationManager.authenticate(
            new UsernamePasswordAuthenticationToken(loginRequest.getUsername(), loginRequest.getPassword()));

        // if go there, the user/password is correct
        SecurityContextHolder.getContext().setAuthentication(authentication);
        // generate jwt to return to client
        String jwt = jwtUtils.generateJwtToken(authentication);

        UserDetailsImpl userDetails = (UserDetailsImpl) authentication.getPrincipal();
        List<String> roles = userDetails.getAuthorities().stream()
            .map(item -> item.getAuthority())
            .collect(Collectors.toList());

        return ResponseEntity.ok(new JwtResponse(jwt,
                                                 userDetails.getId(),                                                 
                                                 userDetails.getEmail(),
                                                 roles.get(0)));
    
    }
    
    @PostMapping("/signup")
    public ResponseEntity<?> registerUser(@Valid @RequestBody SignupRequest signUpRequest) {
    	Optional<Account> optionalAcc = accounrR.findByEmail(signUpRequest.getEmail());
        if (optionalAcc.isPresent()){
            return ResponseEntity
                .badRequest()
                .body(new MessageResponse("Error: Email is already taken!"));
        }
   
//         Create new user's account
        Account account = new Account(signUpRequest.getEmail(),
                             encoder.encode(signUpRequest.getPassword()));

        String strRoles = signUpRequest.getRole();
            
        Optional<Roles> optionalRole= roleRepository.findById(Long.parseLong(strRoles));
        if(optionalRole.isPresent()) {
        	Roles roles = optionalRole.get();
        	account.setRoles(roles);
   
             accounrR.save(account);
             Information info = new Information(signUpRequest.getName(),signUpRequest.getAddress(),
            		 				signUpRequest.getPhoneNumber(),account);
             infomationRepository.save(info);
             return ResponseEntity.ok(new MessageResponse("User registered successfully!"));
        }
        new MessageResponse("Error: Email is already taken!");
		return null;
    }
}