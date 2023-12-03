import java.util.Scanner;

public class InsertionSort {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the number of words in the list:- ");
        int numWords = scanner.nextInt();
        scanner.nextLine();

        String[] wordList = new String[numWords];
        for (int i = 0; i < numWords; i++) {
            System.out.print("Enter word " + (i + 1) + ":- ");
            wordList[i] = scanner.nextLine();
        }

        insertionSort(wordList);

        System.out.println("Sorted List:");
        for (String word : wordList) {
            System.out.println(word);
        }

        scanner.close();
    }

    private static void insertionSort(String[] array) {
        int n = array.length;

        for (int i = 1; i < n; i++) {
            String key = array[i];
            int j = i - 1;

            while (j >= 0 && array[j].compareTo(key) > 0) {
                array[j + 1] = array[j];
                j = j - 1;
            }
            array[j + 1] = key;
        }
    }
}
