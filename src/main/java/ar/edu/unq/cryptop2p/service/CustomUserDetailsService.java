
package ar.edu.unq.cryptop2p.service;

import ar.edu.unq.cryptop2p.model.Role;
import ar.edu.unq.cryptop2p.model.UserCrypto;
import ar.edu.unq.cryptop2p.model.dto.TokenDto;
import ar.edu.unq.cryptop2p.model.dto.UserLoginDto;
import ar.edu.unq.cryptop2p.model.exceptions.PreconditionFailedException;
import ar.edu.unq.cryptop2p.security.JwtTokenProvider;
import jakarta.servlet.http.HttpServletRequest;
import lombok.SneakyThrows;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;


@Service
@Transactional
public class CustomUserDetailsService implements UserDetailsService {

    private UserCryptoService userCryptoService;

    @Autowired
    public CustomUserDetailsService(UserCryptoService userCryptoService) {
     this.userCryptoService = userCryptoService;
    }

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private JwtTokenProvider jwtTokenProvider;

    public Collection<GrantedAuthority> mapToAuthorities(List<Role> roleList){
        return roleList.stream().map(role -> new SimpleGrantedAuthority(role.getName())).collect(Collectors.toList());
    }

    @SneakyThrows
    @Override
    public UserDetails loadUserByUsername(String email) {
        UserCrypto user = userCryptoService.findByEmail(email);
        return new User(user.getEmail(), user.getPassword(), mapToAuthorities(user.getRoles())) ;

    }

    @Transactional
    public TokenDto login(UserLoginDto userData){
        authenticationManager.authenticate(
         new UsernamePasswordAuthenticationToken(userData.getEmail(),userData.getPassword()));
        UserDetails userDetails = loadUserByUsername(userData.getEmail());
      // var auth =  SecurityContextHolder.getContext().getAuthentication();
       // String jwt = jwtTokenProvider.generateToken(auth);
        String jwt = jwtTokenProvider.generateToken(userDetails);
        return new TokenDto(jwt);
    }
        }
