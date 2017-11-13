package com.tytarenko.service;

import com.tytarenko.dao.UserDao;
import com.tytarenko.entity.User;
import com.tytarenko.entity.UserType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashSet;
import java.util.Set;

/**
 * Implementation of {@link org.springframework.security.core.userdetails.UserDetailsService} interface.
 *
 * @author Vladyslav Tytarenko
 * @version 1.0
 */

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    @Autowired
    private UserDao userDao;

    @Override
    @Transactional(readOnly = true)
    public UserDetails loadUserByUsername(String login) throws UsernameNotFoundException {
        User user = userDao.getByLogin(login);
        Set<GrantedAuthority> grantedAuthoritySet = new HashSet<GrantedAuthority>();
        grantedAuthoritySet.add(new SimpleGrantedAuthority(UserType.USER.name()));
        //grantedAuthoritySet.add(new SimpleGrantedAuthority(UserType.ADMIN.name()));
        return new org.springframework.security.core.userdetails.User(user.getLogin(), user.getPassword(), grantedAuthoritySet);
    }
}
