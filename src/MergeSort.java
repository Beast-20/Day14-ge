import java.util.Arrays;
import java.util.Scanner;

public class MergeSort {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the number of strings in the list: ");
        int numStrings = scanner.nextInt();
        scanner.nextLine(); // Consume the newline character

        String[] stringList = new String[numStrings];

        System.out.println("Enter the strings:");
        for (int i = 0; i < numStrings; i++) {
            stringList[i] = scanner.nextLine();
        }

        mergeSort(stringList);

        System.out.println("Sorted List:");
        for (String str : stringList) {
            System.out.println(str);
        }

        scanner.close();
    }

    private static void mergeSort(String[] array) {
        if (array.length > 1) {
            int mid = array.length / 2;
            String[] leftArray = Arrays.copyOfRange(array, 0, mid);
            String[] rightArray = Arrays.copyOfRange(array, mid, array.length);

            mergeSort(leftArray);
            mergeSort(rightArray);

            merge(array, leftArray, rightArray);
        }
    }

    private static void merge(String[] result, String[] left, String[] right) {
        int i = 0, j = 0, k = 0;

        while (i < left.length && j < right.length) {
            if (left[i].compareTo(right[j]) < 0) {
                result[k++] = left[i++];
            } else {
                result[k++] = right[j++];
            }
        }

        while (i < left.length) {
            result[k++] = left[i++];
        }

        while (j < right.length) {
            result[k++] = right[j++];
        }
    }
}
