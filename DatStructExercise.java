import java.util.*;

public class StackExercise {
    public static String strPrompt(String text){
        Scanner scanner = new Scanner(System.in);
        System.out.print(text);
        return scanner.nextLine();
    }

    // Expected time complexity = O(n/2)
    public static boolean isPalindrome(String word){

        // Standardize string to lowercase
        String text = word.toLowerCase();

        // Create a stack and queue to count the instances of equal letters of left and right side of word (mirrored letters)
        // Example: racecar -> rac - e - car (rac is car but mirrored, middle letter can be ignored)
        Stack<Character> letterStack = new Stack<>();
        Queue<Character> letterQueue = new LinkedList<Character>();

        // Add halves of the characters of word into stack/queue
        // If the left scan is equal to right scan, remove the element. Else, do nothing
        for(int i = 0; i < text.length() / 2; i++){
            char left = text.charAt(i);
            char right = text.charAt((text.length()-1) - i);

            letterStack.push(left);
            letterQueue.add(right);

            if (left == right){
                letterStack.pop();
                letterQueue.remove();
            }
        }

        // Returns true if the stack/queue ends up with no elements, meaning the word is a palindrome
        // If there are remaining elements, it means there are dissimilarities in the word (not a palindrome)

        System.out.println("Stack process ended with = " + letterStack);
        System.out.println("Queue process ended with = " + letterQueue);

        if(letterStack.size() == 0 && letterQueue.size() == 0){ return true; }
        else { return false; }
    }

    public static void main(String[] args) {
        String input = strPrompt("Enter a word: ");
        System.out.println("--------------------------------");
        if(isPalindrome(input)){ System.out.println("Yep! It's a palindrome!"); }
        else{ System.out.println("Nope! It's not a palindrome..."); }
    }
}
