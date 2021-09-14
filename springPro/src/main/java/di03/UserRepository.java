package di03;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class UserRepository {
	private Map<String, User> userMap = new HashMap<String, User>();
	
	@Autowired
	public void setUsers(List<User> users) {
		for(User u : users) {
			userMap.put(u.getId(), u);
		}
	}
	public User findUserByid(String id) {
		return userMap.get(id);
	}
}
