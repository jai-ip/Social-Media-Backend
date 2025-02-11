package com.app.todo.filter;

import com.app.todo.entity.User;
import com.app.todo.repo.UserRepo;
import com.app.todo.security.SecurityUser;
import com.app.todo.utils.JwtUtils;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.web.authentication.WebAuthenticationDetails;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;

@Component
public class JWTAuthenticationFilter extends OncePerRequestFilter {

    @Autowired
    private JwtUtils jwtUtils;
    @Autowired
    private UserRepo userRepo;

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {

        String headerContent = request.getHeader(HttpHeaders.AUTHORIZATION);

        String userName = null;
        String jwt = null;

        if(headerContent != null && headerContent.startsWith("Token")) {
            jwt = headerContent.substring(5);
            userName = jwtUtils.getUsernameFromToken(jwt);
        }

        if(userName != null && SecurityContextHolder.getContext().getAuthentication() == null) {
            User user = userRepo.findByUserName(userName)
                    .orElseThrow(() -> new UsernameNotFoundException("User name not found"));
            var userDetails = new SecurityUser(user);
            var authToken = new UsernamePasswordAuthenticationToken(userDetails, null, userDetails.getAuthorities());
            authToken.setDetails(new WebAuthenticationDetails(request));
            SecurityContextHolder.getContext().setAuthentication(authToken);
        }

        filterChain.doFilter(request, response);
    }
}
