import java.util.Stack;
import java.util.Deque;
import java.util.ArrayDeque;

public class UseCase13PalindromeCheckerApp {

    public static boolean stackMethod(String word) {
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < word.length(); i++) {
            stack.push(word.charAt(i));
        }

        for (int i = 0; i < word.length(); i++) {
            if (word.charAt(i) != stack.pop()) {
                return false;
            }
        }
        return true;
    }

    public static boolean dequeMethod(String word) {
        Deque<Character> deque = new ArrayDeque<>();
        for (int i = 0; i < word.length(); i++) {
            deque.addLast(word.charAt(i));
        }

        while (deque.size() > 1) {
            if (deque.removeFirst() != deque.removeLast()) {
                return false;
            }
        }
        return true;
    }

    public static boolean twoPointerMethod(String word) {
        int start = 0;
        int end = word.length() - 1;

        while (start < end) {
            if (word.charAt(start) != word.charAt(end)) {
                return false;
            }
            start++;
            end--;
        }
        return true;
    }

    public static void main(String[] args) {
        String word = "racecar";

        long start1 = System.nanoTime();
        boolean r1 = stackMethod(word);
        long end1 = System.nanoTime();

        long start2 = System.nanoTime();
        boolean r2 = dequeMethod(word);
        long end2 = System.nanoTime();

        long start3 = System.nanoTime();
        boolean r3 = twoPointerMethod(word);
        long end3 = System.nanoTime();

        System.out.println("Stack Method: " + r1 + " Time: " + (end1 - start1) + " ns");
        System.out.println("Deque Method: " + r2 + " Time: " + (end2 - start2) + " ns");
        System.out.println("Two Pointer Method: " + r3 + " Time: " + (end3 - start3) + " ns");
    }
}
