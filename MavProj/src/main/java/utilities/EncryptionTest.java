package utilities;

import jbcrypt.BCrypt;
/**
 * Accounts used for project:
 * 
 * Username: bye.felicia; Password: interwebs
 * @author Admin
 *
 */
public class EncryptionTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		String password = "interwebs";
		String hashed_password = BCrypt.hashpw(password, BCrypt.gensalt());
		
		System.out.println(hashed_password);
		
		if (BCrypt.checkpw(password, hashed_password))
			System.out.println("The password matches.");
		else
			System.out.println("The password does not match.");

	}
	
	

}
