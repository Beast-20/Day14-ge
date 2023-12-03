import java.util.Scanner;

public class BubbleSort {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the number of integers in the list:- ");
        int numInts = scanner.nextInt();
        int[] intList = new int[numInts];

        System.out.println("Enter the integers:- ");
        for (int i = 0; i < numInts; i++) {
            intList[i] = scanner.nextInt();
        }

        bubbleSort(intList);

        System.out.println("Sorted List:- ");
        for (int num : intList) {
            System.out.print(num + " ");
        }

        scanner.close();
    }

    private static void bubbleSort(int[] array) {
        int n = array.length;
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                if (array[j] > array[j + 1]) {
                    int temp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = temp;
                }
            }
        }
    }
}
