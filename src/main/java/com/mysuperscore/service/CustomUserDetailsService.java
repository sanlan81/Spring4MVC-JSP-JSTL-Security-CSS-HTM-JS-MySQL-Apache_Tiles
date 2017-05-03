package com.mysuperscore.service;

import com.mysuperscore.dao.SongDaoJDBC;
import com.mysuperscore.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service("customUserDetailsService")
public class CustomUserDetailsService implements UserDetailsService {

    @Autowired
    SongDaoJDBC songDaoJdbc;

    @Transactional(readOnly=true)
    public UserDetails loadUserByUsername(String ssoId) throws UsernameNotFoundException {
        User user = songDaoJdbc.findUsername(ssoId);
        System.out.println("User : " + user.getUsername());
        if(user==null){
            System.out.println("User not found");
            throw new UsernameNotFoundException("Username not found");
        }
        return new org.springframework.security.core.userdetails.User(user.getUsername(), user.getPassword(),
               true, true, true, true, getGrantedAuthorities());
    }


    private List<GrantedAuthority> getGrantedAuthorities(){
        List<GrantedAuthority> authorities = new ArrayList<GrantedAuthority>();

            authorities.add(new SimpleGrantedAuthority("ROLE_USER"));

        return authorities;
    }

}
