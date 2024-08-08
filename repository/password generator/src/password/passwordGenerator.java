package password;
import java.security.SecureRandom;
import java.util.Scanner;
public class passwordGenerator {
	    private static final String LOWERCASE = "abcdefghijklmnopqrstuvwxyz";
	    private static final String UPPERCASE = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
	    private static final String DIGITS = "0123456789";
	    private static final String SPECIAL_CHARACTERS = "!@#$%^&*()-_+=<>?";
	    private static final SecureRandom random = new SecureRandom();

	    public static void main(String[] args) {
	        Scanner scanner = new Scanner(System.in);
	        System.out.print("Enter password length: ");
	        int length = scanner.nextInt();
	        scanner.nextLine();  
	        System.out.print("Include uppercase letters? (y/n): ");
	        boolean includeUppercase = scanner.nextLine().trim().equalsIgnoreCase("y");
	        System.out.print("Include lowercase letters? (y/n): ");
	        boolean includeLowercase = scanner.nextLine().trim().equalsIgnoreCase("y");
	        System.out.print("Include digits? (y/n): ");
	        boolean includeDigits = scanner.nextLine().trim().equalsIgnoreCase("y");
	        System.out.print("Include special characters? (y/n): ");
	        boolean includeSpecialCharacters = scanner.nextLine().trim().equalsIgnoreCase("y");
	        String password = generatePassword(length, includeUppercase, includeLowercase, includeDigits, includeSpecialCharacters);
	        System.out.println("Generated Password: " + password);

	        scanner.close();
	    }

	    private static String generatePassword(int length, boolean includeUppercase, boolean includeLowercase, boolean includeDigits, boolean includeSpecialCharacters) {
	        if (length <= 0) {
	            throw new IllegalArgumentException("Password length must be greater than 0");
	        }
	        StringBuilder characterSet = new StringBuilder();
	        if (includeLowercase) {
	            characterSet.append(LOWERCASE);
	        }
	        if (includeUppercase) {
	            characterSet.append(UPPERCASE);
	        }
	        if (includeDigits) {
	            characterSet.append(DIGITS);
	        }
	        if (includeSpecialCharacters) {
	            characterSet.append(SPECIAL_CHARACTERS);
	        }
	        if (characterSet.length() == 0) {
	            throw new IllegalArgumentException("At least one character set must be selected");
	        }
	        StringBuilder password = new StringBuilder(length);
	        for (int i = 0; i < length; i++) {
	            int randomIndex = random.nextInt(characterSet.length());
	            password.append(characterSet.charAt(randomIndex));
	        }

	        return password.toString();
	    }
	
}
