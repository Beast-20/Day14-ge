import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Info {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter the message:");
        String message = scanner.nextLine();

        String firstName = getInput("Enter your first name: ", "[A-Z]{1}[a-zA-Z]{2,}", scanner);
        String lastName = getInput("Enter your last name: ", "[A-Z]{1}[a-zA-Z]{2,}", scanner);
        String phoneNumber = getInput("Enter your phone number (format: 91 xxxxxxxxxx): ", "91\\s[0-9]{10}", scanner);

        SimpleDateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy");
        String currentDate = dateFormat.format(new Date());

        String modifiedMessage = replacePattern(message, "<<name>>", firstName);
        modifiedMessage = replacePattern(modifiedMessage, "<<full name>>", firstName + " " + lastName);
        modifiedMessage = replacePattern(modifiedMessage, "91-xxxxxxxxxx", phoneNumber);
        modifiedMessage = replacePattern(modifiedMessage, "\\d{2}/\\d{2}/\\d{4}", currentDate);

        System.out.println("Modified Message:");
        System.out.println(modifiedMessage);

        scanner.close();
    }

    private static String getInput(String prompt, String regex, Scanner scanner) {
        String input;
        do {
            System.out.print(prompt);
            input = scanner.nextLine();
        } while (!input.matches(regex));
        return input;
    }

    private static String replacePattern(String input, String pattern, String replacement) {
        Pattern regex = Pattern.compile(pattern);
        Matcher matcher = regex.matcher(input);
        return matcher.replaceAll(replacement);
    }
}
