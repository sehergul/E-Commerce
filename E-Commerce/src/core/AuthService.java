package core;

import entities.concretes.User;

public interface AuthService {
	boolean CheckIfTrueMail(User user);
}
