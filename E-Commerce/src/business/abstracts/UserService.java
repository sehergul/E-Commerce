package business.abstracts;

import java.util.List;

import entities.concretes.User;

public interface UserService {
	void add(User user);
	void delete(User user);
	void update(User user);
	List<User> getAll();
	boolean login(String email, String password);

}
