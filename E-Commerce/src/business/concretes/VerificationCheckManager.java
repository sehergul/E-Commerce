package business.concretes;

import java.util.Scanner;

import business.abstracts.VerificationCheckService;
import business.abstracts.VerificationService;
import entities.concretes.User;

public class VerificationCheckManager implements VerificationCheckService{

	private VerificationService verificationService;
	
	public VerificationCheckManager(VerificationService verificationService) {
		super();
		this.verificationService = verificationService;
	}


	@Override
	public boolean verify(User user) {
		int verificationCode = verificationService.send(user);
		Scanner scanner = new Scanner(System.in);
        System.out.print("L�tfen do�rulama kodunu giriniz: ");
        int vCode = scanner.nextInt();
        
		if(verificationCode == vCode) {
			System.out.println("Kod do�ruland�!");
			return true;}
		else {
			System.out.println("Kod do�rulanamad�!");
			return false;}
	}
	
	

}
