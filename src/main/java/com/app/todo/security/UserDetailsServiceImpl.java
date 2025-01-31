package com.app.todo.security;

import com.app.todo.entity.User;
import com.app.todo.repo.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    @Autowired
    private UserRepo userRepo;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        System.out.println("INSIDE");
        Optional<User> userOptional = userRepo.findByUserName(username);
        User user = userOptional.orElseThrow(() -> new UsernameNotFoundException("User not found!!!"));

        System.out.println("loadUserByUsername????>>>>"+user.toString());

        return userOptional
                .map(SecurityUser::new)
                .orElseThrow(() -> new UsernameNotFoundException("User not found"));
    }
}
