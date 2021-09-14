package di03;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component("pwChangeSvc")
public class PasswordChangeService {
	UserRepository userRepository;
	@Autowired
	public PasswordChangeService(UserRepository userRepository) {
		this.userRepository=userRepository;
	}
	
	public void changePassword(String userId, String oldPw, String newPw) {
		User user = userRepository.findUserByid(userId);
		if(user==null)
			throw new UserNotFoundException();
		if (user.getPassword().equals(oldPw))
			user.setPassword(newPw);
		else
			throw new IllegalArgumentException("illegal password");
	}
}
