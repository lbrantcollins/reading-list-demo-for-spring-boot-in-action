package com.collins.readinglist.config;

import com.collins.readinglist.model.Reader;
import com.collins.readinglist.repository.ReaderRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ReaderUserDetailsService  implements UserDetailsService {

    private final ReaderRepository repository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<Reader> user = repository.findById(username);
        return user.orElse(null);
    }
}
