import java.util.*;
//racecar
//0123456
public class StackExercise {
    public static String strPrompt(String text){
        Scanner scanner = new Scanner(System.in);
        System.out.print(text);
        return scanner.nextLine();
    }

    // Expected time complexity = O(n/2)
    public static boolean isPalindrome(String text){

        // Create a stack to count the instances of equal letters of left and right side of word (mirrored letters)
        // Example: racecar -> rac - e - car (rac is car but mirrored, middle letter can be ignored)
        Stack<Character> letterStack = new Stack<Character>();

        // Get the letters reading from left and right and compare if they are equal
        // If so, the letter is then added to the stack. Else, not added
        for(int i = 0; i < text.length() / 2; i++){
            int left = text.charAt(i);
            int right = text.charAt((text.length()-1) - i);

            if (left == right){
                letterStack.push(text.charAt(i));
            }
        }

        // Checks the length of mirrored letters from the loop
        // If the number of mirrored letters is equal to the rounded half of the word length, it is a palindrome
        // Else, it is not
        if(letterStack.size() == Math.abs(text.length()/2)){
            return true;
        }
        else{
            return false;
        }
    }

    public static void main(String[] args) {
        String input = strPrompt("Enter a word: ");
        if(isPalindrome(input)){System.out.println("Yep! It's a palindrome!");}
        else{System.out.println("Nope! It's not a palindrome...");}
    }
}
