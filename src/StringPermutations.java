import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class StringPermutations {

    public static void main(String[] args) {
        String inputString = "abc";

        List<String> iterativePermutations = generatePermutationsIterative(inputString);
        System.out.println("Iterative Permutations: " + iterativePermutations);

        // Recursive method
        List<String> recursivePermutations = generatePermutationsRecursive(inputString);
        System.out.println("Recursive Permutations: " + recursivePermutations);

    
        boolean arraysEqual = Arrays.equals(
                iterativePermutations.toArray(new String[0]),
                recursivePermutations.toArray(new String[0])
        );

        System.out.println("Are the arrays equal? " + arraysEqual);
    }

    
    private static List<String> generatePermutationsIterative(String input) {
        List<String> result = new ArrayList<>();
        result.add("");

        for (char c : input.toCharArray()) {
            List<String> newPermutations = new ArrayList<>();
            for (String perm : result) {
                for (int i = 0; i <= perm.length(); i++) {
                    newPermutations.add(perm.substring(0, i) + c + perm.substring(i));
                }
            }
            result = newPermutations;
        }

        return result;
    }

    private static List<String> generatePermutationsRecursive(String input) {
        List<String> result = new ArrayList<>();
        generatePermutationsRecursiveHelper("", input, result);
        return result;
    }

    private static void generatePermutationsRecursiveHelper(String prefix, String remaining, List<String> result) {
        int n = remaining.length();
        if (n == 0) {
            result.add(prefix);
        } else {
            for (int i = 0; i < n; i++) {
                generatePermutationsRecursiveHelper(
                        prefix + remaining.charAt(i),
                        remaining.substring(0, i) + remaining.substring(i + 1),
                        result
                );
            }
        }
    }
}
