package pl.wb.demo.security.service;

import org.springframework.security.core.userdetails.UserDetailsService;
import pl.wb.demo.security.entity.User;
import pl.wb.demo.security.user.CrmUser;

//from https://www.baeldung.com/spring-security-authentication-with-a-database about UserDetailsService interface

// "The UserDetailsService interface is used to retrieve user-related data.
// It has one method named loadUserByUsername() which can be overridden to customize the process of finding the user.
//It is used by the DaoAuthenticationProvider to load details about the user during authentication".
// Without this interface code will not compile.
public interface UserService extends UserDetailsService {

	User findByUserName(String userName);

	User findByUserEmail(String userEmail);

	void save(CrmUser crmUser);
}
