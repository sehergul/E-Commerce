package business.abstracts;

import entities.concretes.User;

public interface VerificationCheckService {
	boolean verify(User user);
}
