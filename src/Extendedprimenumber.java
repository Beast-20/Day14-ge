import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Extendedprimenumber {

    public static void main(String[] args) {
        List<Integer> primeNumbers = new ArrayList<>();

        for (int number = 2; number <= 1000; number++) {
            if (isPrime(number)) {
                primeNumbers.add(number);
            }
        }

        System.out.println("Prime numbers that are anagrams:");
        printAnagramPairs(primeNumbers);

        System.out.println("\nPrime numbers that are palindromes:");
        printPalindromeNumbers(primeNumbers);
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

    private static void printAnagramPairs(List<Integer> primeNumbers) {
        for (int i = 0; i < primeNumbers.size(); i++) {
            for (int j = i + 1; j < primeNumbers.size(); j++) {
                int num1 = primeNumbers.get(i);
                int num2 = primeNumbers.get(j);

                if (areAnagrams(num1, num2)) {
                    System.out.println(num1 + " and " + num2 + " are anagrams.");
                }
            }
        }
    }

    private static boolean areAnagrams(int num1, int num2) {
        char[] chars1 = String.valueOf(num1).toCharArray();
        char[] chars2 = String.valueOf(num2).toCharArray();

        Arrays.sort(chars1);
        Arrays.sort(chars2);

        return Arrays.equals(chars1, chars2);
    }

    private static void printPalindromeNumbers(List<Integer> primeNumbers) {
        for (int num : primeNumbers) {
            if (isPalindrome(num)) {
                System.out.println(num + " is a palindrome.");
            }
        }
    }

    private static boolean isPalindrome(int num) {
        String strNum = String.valueOf(num);
        return strNum.equals(new StringBuilder(strNum).reverse().toString());
    }
}
