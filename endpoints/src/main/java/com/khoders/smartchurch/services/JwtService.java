package com.khoders.smartchurch.services;

import com.khoders.smartchurch.dto.UserAccountDto;
import com.khoders.smartchurch.entities.UserAccount;
import com.khoders.smartchurch.exception.NotFoundException;
import com.khoders.smartchurch.impl.UserAccountServiceImpl;
import com.khoders.smartchurch.models.JwtRequest;
import com.khoders.smartchurch.models.JwtResponse;
import com.khoders.smartchurch.util.JwtUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

@Service
public class JwtService implements UserDetailsService {

    @Autowired private JwtUtil jwtUtil;
    @Autowired private AuthenticationManager authenticationManager;
    @Autowired private UserAccountServiceImpl userAccountService;

    private UserAccountDto dto;

    public JwtResponse createJwtToken(JwtRequest jwtRequest) throws Exception {
        String username = jwtRequest.getUsername();
        String userPassword = jwtRequest.getUserPassword();
        authenticate(username, userPassword);

        final UserDetails userDetails = loadUserByUsername(username);
       String newGeneratedToken =  jwtUtil.generateToken(userDetails);

       UserAccount userAccount = userAccountService.findEntityById(username).orElseThrow(() -> new NotFoundException("Email Address not found"));
       return new JwtResponse(userAccount, newGeneratedToken);
    }

    @Override
    public UserDetails loadUserByUsername(String emailAddress) throws UsernameNotFoundException {
       UserAccount userAccount = userAccountService.findEntityById(emailAddress).orElse(null);
       if(userAccount != null)
       {
           return new User(
                   userAccount.getEmailAddress(),
                   userAccount.getPassword(),
                   getAuthorities(userAccount)
           );
       }
       else
       {
           throw new UsernameNotFoundException("Email Address is not valid");
       }
    }

    private Set<SimpleGrantedAuthority> getAuthorities(UserAccount userAccount){
        Set<SimpleGrantedAuthority> authorities = new HashSet<>();
        userAccount.getRole().forEach(role -> {
            authorities.add(new SimpleGrantedAuthority("ROLE_"+role.getRoleName()));
        });
        return authorities;
    }

    private void authenticate(String username, String userPassword) throws Exception {
        try {
            authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(username, userPassword));
        }catch(DisabledException | BadCredentialsException e){
           throw new Exception("User is disabled");
        }
    }
}
