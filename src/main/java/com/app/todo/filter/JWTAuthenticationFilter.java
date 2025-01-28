package com.app.todo.filter;

import com.app.todo.entity.User;
import com.app.todo.repo.UserRepo;
import com.app.todo.utils.JwtUtils;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;
import java.util.Optional;

@Component
public class JWTAuthenticationFilter extends OncePerRequestFilter {

    private JwtUtils jwtUtils;
    private UserRepo userRepo;

    public JWTAuthenticationFilter(JwtUtils jwtUtils) {
        this.jwtUtils = jwtUtils;
    }

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {

        String headerContent = request.getHeader("Authorization");

        String userName = null;
        String jwt = null;

        if(headerContent != null && headerContent.startsWith("Token")) {
            jwt = headerContent.substring(5);
            userName = jwtUtils.getUsernameFromToken(jwt);
        }

        if(userName != null && SecurityContextHolder.getContext().getAuthentication() == null) {
            User user = userRepo.findByUserName(userName).get();
//            UsernamePasswordAuthenticationToken usernamePasswordAuthenticationToken =
//                    new UsernamePasswordAuthenticationToken(user, null, user.getRoles());
        }


    }
}
