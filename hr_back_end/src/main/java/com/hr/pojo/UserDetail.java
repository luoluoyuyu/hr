package com.hr.pojo;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.math.BigInteger;
import java.util.Collection;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true,value = {"accountNonExpired", "accountNonLocked", "credentialsNonExpired","username","authorities"})
public class UserDetail implements UserDetails {

   private BigInteger userId;

   private String name;

   private String password;

   private boolean enable;

   private List<? extends GrantedAuthority> auth;

   private List<String> roles;
   @Override
   public Collection<? extends GrantedAuthority> getAuthorities() {
      return auth;
   }

   @Override
   public String getUsername() {
      return String.valueOf(userId);
   }

   @Override
   public boolean isAccountNonExpired() {
      return true;
   }

   @Override
   public boolean isAccountNonLocked() {
      return true;
   }

   @Override
   public boolean isCredentialsNonExpired() {
      return true;
   }

   @Override
   public boolean isEnabled() {
      return enable;
   }
}
