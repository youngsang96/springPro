package ch02_DIXML;

import java.util.Arrays;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import di03.AuthFailLogger;
import di03.AuthenticationService;
import di03.PasswordChangeService;
import di03.User;
import di03.UserRepository;

/*
1. container : @Configuration
2. bean  :@Bean
3  wired 
*/


@Configuration
public class ContainerAnno {
	
	@Bean
	public User user1() {
		return new User("bkchoi", "1234");
	}
	@Bean
	public User user2() {
		return new User("madvirus", "qwer");
	}
	@Bean
	public UserRepository userRepository() {
		UserRepository userRepo = new UserRepository();
		userRepo.setUsers(Arrays.asList(user1(),user2()));
		return userRepo;
	}
	@Bean
	public AuthFailLogger authFailLogger() {
		AuthFailLogger logger = new AuthFailLogger();
		logger.setThreshold(2);
		return logger;
	}
	@Bean
	public AuthenticationService authenticationService() {
		AuthenticationService authSvc = new AuthenticationService();
		authSvc.setFailLogger(authFailLogger());
		authSvc.setUserRepository(userRepository());
		return authSvc;
	}
	@Bean("pwChangeSvc")
	public PasswordChangeService pwChangeSvc() {
		return new PasswordChangeService(userRepository());
	}
	
}
