package dataAccess.concretes;

import java.util.ArrayList;
import java.util.List;

import dataAccess.abstracts.UserDao;
import entities.concretes.User;

public class InMemoryUserDao implements UserDao {

	private List<User> userList = new ArrayList<User>();
	
	@Override
	public void add(User user) {
		userList.add(user);
		
	}

	@Override
	public void delete(User user) {
		userList.remove(user);
		
	}

	@Override
	public void update(User user) {
		System.out.println(user.getFirstName() + " güncellendi!");
		
	}

	@Override
	public List<User> getAll() {
		return userList;
	}
	
	@Override
	public User getByMail(String email) {
		for(User user : userList) {
			if(user.getEmail().equals(email))
				return user;
		}
		return null;	
	}
	
	@Override
	public boolean checkLogin(String email, String password) {

		for(User user : userList) {
			if(user.getEmail().equals(email) && user.getPassword().equals(password))
				return true;}
			return false;
		
	}

	
}
