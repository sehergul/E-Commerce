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
			System.out.println("Oluþturulan parola geçerli!");
			return true;}
			
		else {
			System.out.println("Oluþturulan parola geçersiz!");
			return false;}
	}

	@Override
	public boolean nameValidation(User user) {
		if(user.getFirstName().length()>=2 && user.getLastName().length()>=2) {
			System.out.println("Oluþturulan ad soyad geçerli!");
			return true;}
		else {
			System.out.println("Oluþturulan ad soyad geçersiz!");
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
        	System.out.println(user.getEmail() + " oluþturulan email geçersiz!");
            return false;}
        
        if(pat.matcher(user.getEmail()).matches()==false)
        	System.out.println(user.getEmail() + " oluþturulan email geçersiz!");
        return pat.matcher(user.getEmail()).matches();
        
	}

	@Override
	public boolean emailUsedBeforeCheck(User user) {
		if(userDao.getByMail(user.getEmail())==null) {
			System.out.println("Oluþturulan email kullanýlabilir!");
			return true;}
		else {
			System.out.println(user.getEmail() + " zaten kullanýmda!");
			return false;}
	}


	
	
}
