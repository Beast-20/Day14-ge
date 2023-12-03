import java.util.Scanner;

class Node<T> {
    T data;
    Node<T> next;

    Node(T data) {
        this.data = data;
        this.next = null;
    }
}

class UnorderedList<T> {
    private Node<T> head;

    UnorderedList() {
        this.head = null;
    }

    void insert(T data) {
        Node<T> newNode = new Node<>(data);
        newNode.next = head;
        head = newNode;
    }

    void remove(T data) {
        Node<T> current = head;
        Node<T> prev = null;

        while (current != null && !current.data.equals(data)) {
            prev = current;
            current = current.next;
        }

        if (current != null) {
            if (prev == null) {
                head = current.next;
            } else {
                prev.next = current.next;
            }
        }
    }

    boolean search(T data) {
        Node<T> current = head;
        while (current != null) {
            if (current.data.equals(data)) {
                return true;
            }
            current = current.next;
        }
        return false;
    }

    void display() {
        Node<T> current = head;
        while (current != null) {
            System.out.print(current.data + " ");
            current = current.next;
        }
        System.out.println();
    }
}

public class UnorderedListDemo {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        UnorderedList<String> wordList = new UnorderedList<>();

        System.out.println("Enter words (enter 'done' to finish): ");
        String inputWord;
        while (!(inputWord = scanner.next()).equalsIgnoreCase("done")) {
            wordList.insert(inputWord);
        }

        System.out.print("Enter a word to search in the list: ");
        String searchWord = scanner.next();

        if (wordList.search(searchWord)) {
            System.out.println("Word found in the list. Removing it.");
            wordList.remove(searchWord);
        } else {
            System.out.println("Word not found in the list. Adding it.");
            wordList.insert(searchWord);
        }

        System.out.println("Updated List: ");
        wordList.display();

        scanner.close();
    }
}
