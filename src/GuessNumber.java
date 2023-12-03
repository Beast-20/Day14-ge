import java.util.Scanner;

public class GuessNumber {

    public static void main(String[] args) {
        if (args.length != 1) {
            System.out.println("Please provide a number as a command-line argument.");
            return;
        }

        int N = Integer.parseInt(args[0]);
        int low = 0;
        int high = N - 1;

        Scanner scanner = new Scanner(System.in);
        int steps = guessNumber(low, high, scanner);

        System.out.println("Number of steps: " + steps);
        scanner.close();
    }

    private static int guessNumber(int low, int high, Scanner scanner) {
        if (low > high) {
            return 0;
        }

        int mid = (low + high) / 2;

        System.out.println("Is your number between " + low + " and " + high + "? (true/false)");
        boolean response = scanner.nextBoolean();

        if (response) {
            System.out.println("Is your number between " + low + " and " + mid + "? (true/false)");
            response = scanner.nextBoolean();

            if (response) {
                return 1 + guessNumber(low, mid - 1, scanner);
            } else {
                return 1 + guessNumber(mid + 1, high, scanner);
            }
        } else {
            return 1 + guessNumber(mid + 1, high, scanner);
        }
    }
}
