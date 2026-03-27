import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Scanner;

public class PasswordTool {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean running = true;

        System.out.println("Password Strength and Hashing Tool");

        while (running) {
            printMenu();
            System.out.print("Choose an option: ");
            String option = scanner.nextLine();

            switch (option) {
                case "1":
                    checkPasswordStrength(scanner);
                    break;
                case "2":
                    hashPassword(scanner);
                    break;
                case "3":
                    checkAndHashPassword(scanner);
                    break;
                case "0":
                    running = false;
                    System.out.println("Exiting application...");
                    break;
                default:
                    System.out.println("Invalid option. Please try again.");
            }

            System.out.println();
        }

        scanner.close();
    }

    public static void printMenu() {
        System.out.println("1. Check password strength");
        System.out.println("2. Hash a password");
        System.out.println("3. Check strength and hash password");
        System.out.println("0. Exit");
    }

    public static void checkPasswordStrength(Scanner scanner) {
        System.out.print("Enter password: ");
        String password = scanner.nextLine();

        String strength = evaluateStrength(password);
        System.out.println("Password strength: " + strength);

        printPasswordFeedback(password);
    }

    public static void hashPassword(Scanner scanner) {
        System.out.print("Enter password: ");
        String password = scanner.nextLine();

        String hashedPassword = sha256(password);
        System.out.println("SHA-256 hash: " + hashedPassword);
    }

    public static void checkAndHashPassword(Scanner scanner) {
        System.out.print("Enter password: ");
        String password = scanner.nextLine();

        String strength = evaluateStrength(password);
        System.out.println("Password strength: " + strength);

        printPasswordFeedback(password);

        String hashedPassword = sha256(password);
        System.out.println("SHA-256 hash: " + hashedPassword);
    }

    public static String evaluateStrength(String password) {
        int score = 0;

        if (password.length() >= 8) {
            score++;
        }

        if (containsUppercase(password)) {
            score++;
        }

        if (containsLowercase(password)) {
            score++;
        }

        if (containsDigit(password)) {
            score++;
        }

        if (containsSpecialCharacter(password)) {
            score++;
        }

        if (password.length() >= 12) {
            score++;
        }

        if (score <= 2) {
            return "Weak";
        } else if (score <= 4) {
            return "Medium";
        } else {
            return "Strong";
        }
    }

    public static void printPasswordFeedback(String password) {
        if (password.length() < 8) {
            System.out.println("- Password should have at least 8 characters.");
        }

        if (!containsUppercase(password)) {
            System.out.println("- Add at least one uppercase letter.");
        }

        if (!containsLowercase(password)) {
            System.out.println("- Add at least one lowercase letter.");
        }

        if (!containsDigit(password)) {
            System.out.println("- Add at least one digit.");
        }

        if (!containsSpecialCharacter(password)) {
            System.out.println("- Add at least one special character.");
        }

        if (password.length() >= 8 &&
                containsUppercase(password) &&
                containsLowercase(password) &&
                containsDigit(password) &&
                containsSpecialCharacter(password)) {
            System.out.println("- Your password meets the main security criteria.");
        }
    }

    public static boolean containsUppercase(String password) {
        for (char ch : password.toCharArray()) {
            if (Character.isUpperCase(ch)) {
                return true;
            }
        }
        return false;
    }

    public static boolean containsLowercase(String password) {
        for (char ch : password.toCharArray()) {
            if (Character.isLowerCase(ch)) {
                return true;
            }
        }
        return false;
    }

    public static boolean containsDigit(String password) {
        for (char ch : password.toCharArray()) {
            if (Character.isDigit(ch)) {
                return true;
            }
        }
        return false;
    }

    public static boolean containsSpecialCharacter(String password) {
        for (char ch : password.toCharArray()) {
            if (!Character.isLetterOrDigit(ch)) {
                return true;
            }
        }
        return false;
    }

    public static String sha256(String input) {
        try {
            MessageDigest digest = MessageDigest.getInstance("SHA-256");
            byte[] hashBytes = digest.digest(input.getBytes());

            StringBuilder hexString = new StringBuilder();

            for (byte b : hashBytes) {
                String hex = Integer.toHexString(0xff & b);
                if (hex.length() == 1) {
                    hexString.append('0');
                }
                hexString.append(hex);
            }

            return hexString.toString();
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException("Error: SHA-256 algorithm not found.");
        }
    }
}