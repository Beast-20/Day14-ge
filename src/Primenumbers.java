public class Primenumbers {

    public static void main(String[] args) {
        System.out.println("Prime numbers in the range 0 to 1000:");

        for (int number = 2; number <= 1000; number++) {
            if (isPrime(number)) {
                System.out.print(number + " ");
            }
        }
    }

    private static boolean isPrime(int num) {
        if (num <= 1) {
            return false;
        }

        for (int i = 2; i <= Math.sqrt(num); i++) {
            if (num % i == 0) {
                return false;
            }
        }

        return true;
    }
}
