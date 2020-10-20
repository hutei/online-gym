package com.hutei.Service.details;

import com.hutei.dao.UserRepository;
import com.hutei.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class MyUserDetailsService implements UserDetailsService {

    @Autowired
    UserRepository repository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
         Optional<User> user = Optional.ofNullable(repository.findByUsername(username));

        user.orElseThrow(() -> new UsernameNotFoundException("Not found:"+ username ));

        return user.map(MyUserDetails::new).get();
    }
}
