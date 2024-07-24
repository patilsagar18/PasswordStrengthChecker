import java.util.Scanner;

public class PasswordStrengthChecker {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Prompt the user to input a password
        System.out.print("Enter a password: ");
        String password = scanner.nextLine();

        // Check the strength of the password
        String strength = checkPasswordStrength(password);

        // Provide feedback on the password strength
        System.out.println("Password strength: " + strength);

        scanner.close();
    }

    public static String checkPasswordStrength(String password) {
        int length = password.length();
        boolean hasUppercase = false;
        boolean hasLowercase = false;
        boolean hasDigit = false;
        boolean hasSpecialChar = false;

        for (char c : password.toCharArray()) {
            if (Character.isUpperCase(c)) hasUppercase = true;
            if (Character.isLowerCase(c)) hasLowercase = true;
            if (Character.isDigit(c)) hasDigit = true;
            if (isSpecialCharacter(c)) hasSpecialChar = true;
        }

        if (length >= 8 && hasUppercase && hasLowercase && hasDigit && hasSpecialChar) {
            return "Strong";
        } else if (length >= 6 && ((hasUppercase && hasLowercase) || (hasLowercase && hasDigit) || (hasUppercase && hasDigit))) {
            return "Medium";
        } else {
            return "Weak";
        }
    }

    public static boolean isSpecialCharacter(char c) {
        String specialCharacters = "!@#$%^&*()-_=+<>?";
        return specialCharacters.indexOf(c) != -1;
    }
}
