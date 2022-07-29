package cybersoft.javabackend.java16giragv.security.service;

import cybersoft.javabackend.java16giragv.user.model.GiraUser;
import cybersoft.javabackend.java16giragv.user.repository.GiraUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {
    @Autowired
    private GiraUserRepository repository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<GiraUser> userOpt = repository.findByUsername(username);

        if (userOpt.isEmpty())
            return null;

        GiraUser currentUser = userOpt.get();

        return new User(currentUser.getUsername(), currentUser.getPassword(), getGrantedAuthorities(currentUser));
    }

    private List<GrantedAuthority> getGrantedAuthorities(GiraUser user) {
        List<GrantedAuthority> authorities = new ArrayList<GrantedAuthority>();

        user.getGroups().forEach(group -> authorities.add(
                new SimpleGrantedAuthority(group.getCode())
        ));

        return authorities;
    }

}
