import business.concretes.UserManager;
import business.concretes.ValidationManager;
import business.concretes.VerificationCheckManager;
import business.concretes.VerificationManager;
import core.AbcAuthManager;
import core.GoogleAuthManagerAdapter;
import dataAccess.concretes.InMemoryUserDao;
import entities.concretes.User;

public class Main {

	public static void main(String[] args) {
		
		User user1 = new User("Engin", "Demiroð", "engindemirog@gmail.com","123456789");
		UserManager userManager = new UserManager(new VerificationCheckManager(new VerificationManager())
				,new ValidationManager(new InMemoryUserDao()) , new InMemoryUserDao(), new GoogleAuthManagerAdapter());
		userManager.add(user1);
		userManager.login(user1.getEmail(), user1.getPassword());
		
		System.out.println("\n--------\n");
		
		User user2 = new User("Babür", "Robot", "iyiailerobotu@om","babür42");
		UserManager userManager2 = new UserManager(new VerificationCheckManager(new VerificationManager())
				,new ValidationManager(new InMemoryUserDao()) , new InMemoryUserDao(),new GoogleAuthManagerAdapter());
		userManager2.add(user2);
		userManager2.login(user2.getEmail(), user2.getPassword());

		
		System.out.println("\n--------\n");
		
		
		User user3 = new User("Seher", "Gül", "sehernege@gmail.com","seher12345");
		UserManager userManager3 = new UserManager(new VerificationCheckManager(new VerificationManager())
				,new ValidationManager(new InMemoryUserDao()) , new InMemoryUserDao(),new GoogleAuthManagerAdapter());
		userManager3.add(user3);
		userManager3.login(user3.getEmail(), user3.getPassword());

		
		System.out.println("\n--------\n");

		
		User user4 = new User("Yüce", "Honos", "hapsu@gmail.com","mustesna");
		UserManager userManager4 = new UserManager(new VerificationCheckManager(new VerificationManager())
				,new ValidationManager(new InMemoryUserDao()) , new InMemoryUserDao(), new AbcAuthManager());
		userManager4.add(user4);
		userManager4.login(user4.getEmail(), user4.getPassword());
		
		
		System.out.println("\n--------\n");

		
		
		

	}

}
