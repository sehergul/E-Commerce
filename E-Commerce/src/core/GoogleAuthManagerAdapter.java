package core;

import entities.concretes.User;
import google.GoogleAuthManager;

public class GoogleAuthManagerAdapter implements AuthService{


	@Override
	public boolean CheckIfTrueMail(User user) {
		GoogleAuthManager googleAuthManager = new GoogleAuthManager();
		if(googleAuthManager.checkIfTrueMail(user)==true)
			System.out.println("Google ile doðrulandý: " + user.getEmail());
		return true;
	
	}

	
	
}
