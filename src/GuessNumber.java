import java.util.Scanner;

public class GuessNumber {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the value of n: ");
        int n = scanner.nextInt();

        int N = (int) Math.pow(2, n);

        int low = 0;
        int high = N - 1;
        int steps = 0;

        while (low <= high) {
            int guess = low + (high - low) / 2;

            System.out.print("Is your number between " + low + " and " + (high - 1) + "? (Type 'y' for Yes, 'n' for No): ");
            String response = scanner.next().toLowerCase();

            if (response.equals("y")) {
                if (low == high - 1) {
                    System.out.println("Your number is " + low + "!");
                    System.out.println("Number of steps: " + steps);
                    break;
                } else {
                    System.out.println("Intermediary number: " + guess);
                    high = guess;
                }
            } else if (response.equals("n")) {
                low = guess;  // Corrected to update low without adding 1
            } else {
                System.out.println("Invalid input. Please type 'y' for Yes or 'n' for No.");
            }

            steps++;
        }

        scanner.close();
    }
}
