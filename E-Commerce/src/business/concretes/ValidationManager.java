package business.concretes;

import java.util.regex.Pattern;

import business.abstracts.ValidationService;
import dataAccess.abstracts.UserDao;
import entities.concretes.User;

public class ValidationManager implements ValidationService{

	private UserDao userDao;
	
	public ValidationManager(UserDao userDao) {
		this.userDao = userDao;
	}
	
	@Override
	public boolean passwordValidation(User user) {
		if(user.getEmail().length()>=6) {
			System.out.println("Olu�turulan parola ge�erli!");
			return true;}
			
		else {
			System.out.println("Olu�turulan parola ge�ersiz!");
			return false;}
	}

	@Override
	public boolean nameValidation(User user) {
		if(user.getFirstName().length()>=2 && user.getLastName().length()>=2) {
			System.out.println("Olu�turulan ad soyad ge�erli!");
			return true;}
		else {
			System.out.println("Olu�turulan ad soyad ge�ersiz!");
			return false;}
	}

	@Override
	public boolean emailFormatValidation(User user) {
		String emailRegex = "^[a-zA-Z0-9_+&*-]+(?:\\." +
                "[a-zA-Z0-9_+&*-]+)*@" +
                "(?:[a-zA-Z0-9-]+\\.)+[a-z" +
                "A-Z]{2,7}$";
        Pattern pat = Pattern.compile(emailRegex);
        if (user.getEmail() == null) {
        	System.out.println(user.getEmail() + " olu�turulan email ge�ersiz!");
            return false;}
        
        if(pat.matcher(user.getEmail()).matches()==false)
        	System.out.println(user.getEmail() + " olu�turulan email ge�ersiz!");
        return pat.matcher(user.getEmail()).matches();
        
	}

	@Override
	public boolean emailUsedBeforeCheck(User user) {
		if(userDao.getByMail(user.getEmail())==null) {
			System.out.println("Olu�turulan email kullan�labilir!");
			return true;}
		else {
			System.out.println(user.getEmail() + " zaten kullan�mda!");
			return false;}
	}


	
	
}
