package business.concretes;

import java.util.Random;

import business.abstracts.VerificationService;
import entities.concretes.User;

public class VerificationManager implements VerificationService{

	@Override
	public int send(User user) {
		Random random = new Random();
        int verificationCode = random.nextInt(500)*10;
        System.out.println("Kod: " + verificationCode);
		return verificationCode;
		
	}

}
