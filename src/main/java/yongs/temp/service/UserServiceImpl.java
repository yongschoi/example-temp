package yongs.temp.service;

import java.util.ArrayList;
import java.util.List;

import javax.jws.WebService;

import org.springframework.stereotype.Service;

import yongs.temp.inf.UserService;
import yongs.temp.vo.User;

@WebService(serviceName = "UserService")
@Service
public class UserServiceImpl implements UserService {
	private static User user1;
	private static User user2;
	private static User user3;

	private static List<User> userList = new ArrayList<>();

	static {
		user1 = new User(0, "tom", "tom@gmail.com");
		user2 = new User(1, "jim", "jim@gmail.com");
		user3 = new User(2, "jack", "jack@gmail.com");

		userList.add(0, user1);
		userList.add(1, user2);
		userList.add(2, user3);
	}

	@Override
	public String getUserName(int userId) {
		return userList.get(userId).getUserName();
	}

	@Override
	public User getUser(int userId) {
		return (User) userList.get(userId);
	}

	@Override
	public List<User> getUserList(int userId) {
		return userList;
	}
}
