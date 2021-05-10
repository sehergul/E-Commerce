package business.concretes;

import java.util.List;

import business.abstracts.UserService;
import business.abstracts.VerificationCheckService;
import core.AuthService;
import dataAccess.abstracts.UserDao;
import entities.concretes.User;

public class UserManager implements UserService{

	private UserDao userDao;
	private VerificationCheckService verificationCheckService;
	private ValidationManager validationManager;
	private AuthService authService;
	
	public UserManager(VerificationCheckService verificationCheckService, 
			ValidationManager validationManager, UserDao userDao,AuthService authService) {
		super();
		this.verificationCheckService= verificationCheckService;
		this.validationManager = validationManager;
		this.userDao = userDao;
		this.authService = authService;
	}
	
	@Override
	public void add(User user) {
		if(validationManager.emailFormatValidation(user)==true && validationManager.emailUsedBeforeCheck(user)==true
				&& validationManager.nameValidation(user) && validationManager.passwordValidation(user) 
				&& verificationCheckService.verify(user)==true && authService.CheckIfTrueMail(user)==true) {
			userDao.add(user);
			System.out.println(user.getFirstName() + " sisteme ba�ar�yla kaydedildi!");
		}
		else {
			System.out.println(user.getFirstName() + " sisteme kaydedilemedi!");
		}		
	}

	@Override
	public void delete(User user) {
		System.out.println(user.getFirstName() + " kullan�c�s� ba�ar�yla sistemden silindi!");
		
	}

	@Override
	public void update(User user) {
		System.out.println(user.getFirstName() + " kullan�c�s� ba�ar�yla g�ncellendi!");
		
	}

	@Override
	public List<User> getAll() {
		System.out.println("Kullan�c� Listesi:");
		for(User user : userDao.getAll())
			System.out.println(user.getFirstName() + " " + user.getLastName() + " " + user.getEmail());
		return userDao.getAll();
	}

	@Override
	public boolean login(String email, String password) {
		if(userDao.checkLogin(email, password)) {
			System.out.println("Ba�ar�yla sisteme giri� yap�ld�!");
			return true;}
		else {
			System.out.println("Sisteme giri� yap�lamad�! Parola veya email hatal�!");
			return false;}
	}
	
	

}
