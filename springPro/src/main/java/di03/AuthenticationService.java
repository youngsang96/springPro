package di03;

public class AuthenticationService {
	AuthFailLogger authFailLogger;
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
