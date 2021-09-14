package di03_scan;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import di03.AuthException;
import di03.AuthFailLogger;
import di03.AuthInfo;
import di03.User;
import di03.UserNotFoundException;
import di03.UserRepository;

@Component
public class AuthenticationService {
	@Autowired
	AuthFailLogger authFailLogger;
	
	@Autowired
	UserRepository userRepository;
	
	
	public void setFailLogger(AuthFailLogger authFailLogger) {
		this.authFailLogger = authFailLogger;
	}
	
	public void setUserRepository(UserRepository userRepository) {
		this.userRepository = userRepository;
	}
	
	public AuthInfo authenticate(String id, String password) {
		User user = userRepository.findUserByid(id);
		if(user == null)
			throw new UserNotFoundException();
		
		if(!user.getPassword().equals(password)) {
			authFailLogger.insertBadPw(id, password);
			throw new AuthException();
		}
		return new AuthInfo(user.getId());
	}
}
