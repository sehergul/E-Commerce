package core;

import entities.concretes.User;

public class AbcAuthManager implements AuthService {

	@Override
	public boolean CheckIfTrueMail(User user) {
		System.out.println("Abc ile doðrulandý: " + user.getEmail());
		return true;
	}
	

}
