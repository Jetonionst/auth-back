package com.example.SOLIDBankApp4.service.controller;


import com.example.SOLIDBankApp4.dao.TransactionDAO;
import com.example.SOLIDBankApp4.entity.User;
import com.example.SOLIDBankApp4.entity.account.Account;
import com.example.SOLIDBankApp4.entity.account.AccountType;
import com.example.SOLIDBankApp4.entity.account.AccountWithdraw;
import com.example.SOLIDBankApp4.entity.transaction.TransactionDeposit;
import com.example.SOLIDBankApp4.entity.transaction.TransactionWithdraw;
import com.example.SOLIDBankApp4.filter.JwtUtil;
import com.example.SOLIDBankApp4.service.BankCore;
import com.example.SOLIDBankApp4.service.UserService;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;
import java.net.URI;
import java.util.List;
import java.util.stream.Collectors;

@RestController("/")
public class AuthController  {
    @Autowired
    UserService userService;
    @Autowired
    AuthenticationManager authenticationManager;
    JwtUtil jwtUtil;


    @PostMapping("/register")
    public ResponseEntity<User> save(@RequestBody User user) {
        User userEntity = userService.save(user);
        URI uri = URI.create(ServletUriComponentsBuilder
                .fromCurrentRequest().path("/{username}")
                .buildAndExpand(userEntity.getUsername()).toUriString());
        return ResponseEntity.created(uri).build();
    }


    @PostMapping("/authenticate")
    public ResponseEntity<String> authenticateUser(@Valid @RequestBody User user, HttpServletRequest request, HttpServletResponse response) {
        user.setRole("ROLE_USER");
        Authentication authentication = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(user.getUsername(), user.getPassword(),user.getAuthorities()));
        SecurityContextHolder.getContext().setAuthentication(authentication);
        String jwt = jwtUtil.createAccessToken(user.getUsername(), request.getRequestURL().toString(), user.getAuthorities().stream().map(GrantedAuthority::getAuthority).collect(Collectors.toList()));
        Cookie cookie = new Cookie("token", jwt);
        cookie.setHttpOnly(true);
        response.addCookie(cookie);
        return ResponseEntity.ok(jwt);
    }

}