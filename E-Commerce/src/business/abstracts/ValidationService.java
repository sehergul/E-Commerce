package business.abstracts;

import entities.concretes.User;

public interface ValidationService {
	boolean passwordValidation(User user);
	boolean nameValidation(User user);
	boolean emailFormatValidation(User user);
	boolean emailUsedBeforeCheck(User user);
	
}
