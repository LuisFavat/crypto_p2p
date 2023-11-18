package ar.edu.unq.cryptop2p.security;

import ar.edu.unq.cryptop2p.model.Role;
import ar.edu.unq.cryptop2p.model.UserCrypto;
import ar.edu.unq.cryptop2p.service.UserCryptoService;
import lombok.SneakyThrows;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
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

    @Autowired
    private UserCryptoService userCryptoService;

   
   // public CustomUserDetailsService(UserPersistence userPersistence) {
      //  this.userPersistence = userPersistence;
  //  }

    public Collection<GrantedAuthority> mapToAuthorities(List<Role> roleList){
        return roleList.stream().map(role -> new SimpleGrantedAuthority(role.getName())).collect(Collectors.toList());
    }

    @SneakyThrows
    @Override
    public UserDetails loadUserByUsername(String email) {
        UserCrypto user = userCryptoService.findByEmail(email);
        return new User(user.getEmail(), user.getPassword(), mapToAuthorities(user.getRoles())) ;

    }
}
