package com.wsidomgate.accountservice.security.service;

import com.wsidomgate.accountservice.model.Account;
import com.wsidomgate.accountservice.repository.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
@Service
public class AccountDetailsService implements UserDetailsService {
    @Autowired
    AccountRepository userRepository;

    @Override
    @Transactional
    public AccountDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Account user = userRepository.findByUsername(username)
                .orElseThrow(() -> new UsernameNotFoundException("User Not Found with username: " + username));
        return AccountDetails.build(user);
    }
}
