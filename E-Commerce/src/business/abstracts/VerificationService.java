package business.abstracts;

import entities.concretes.User;

public interface VerificationService {
	int send(User user);
}
