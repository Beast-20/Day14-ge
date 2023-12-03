import java.util.Arrays;
import java.util.Scanner;

public class Wordsearch {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the number of words in the list:- ");
        int numWords = scanner.nextInt();
        scanner.nextLine();

        String[] wordList = new String[numWords];
        for (int i = 0; i < numWords; i++) {
            System.out.print("Enter word " + (i + 1) + ": ");
            wordList[i] = scanner.nextLine().toLowerCase(); // Convert to lowercase
        }

        Arrays.sort(wordList);

        System.out.print("Enter a word to search: ");
        String searchWord = scanner.nextLine().toLowerCase(); // Convert to lowercase

        boolean found = binarySearch(wordList, searchWord);

        if (found) {
            System.out.println("The word \"" + searchWord + "\" is found in the list.");
        } else {
            System.out.println("The word \"" + searchWord + "\" is not found in the list.");
        }

        scanner.close();
    }

    private static boolean binarySearch(String[] array, String target) {
        int low = 0;
        int high = array.length - 1;

        while (low <= high) {
            int mid = (low + high) / 2;
            int comparison = target.compareTo(array[mid]);

            if (comparison == 0) {
                return true;
            } else if (comparison < 0) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }

        return false;
    }
}
