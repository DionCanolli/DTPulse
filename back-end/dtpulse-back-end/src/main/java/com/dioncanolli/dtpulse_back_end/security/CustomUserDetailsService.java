package com.dioncanolli.dtpulse_back_end.security;

import com.dioncanolli.dtpulse_back_end.entity.Role;
import com.dioncanolli.dtpulse_back_end.service.MyService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CustomUserDetailsService implements UserDetailsService {

    private final MyService myService;

    public CustomUserDetailsService(MyService myService) {
        this.myService = myService;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        com.dioncanolli.dtpulse_back_end.entity.User user = myService.findUserByEmail(username);
        if (user == null) {
            throw new UsernameNotFoundException("User not found");
        }

        List<SimpleGrantedAuthority> authorities = new ArrayList<>();
        authorities.add(new SimpleGrantedAuthority(user.getRole().getRoleName()));

        return new User(user.getEmail(), user.getPassword(), authorities);
    }
}
