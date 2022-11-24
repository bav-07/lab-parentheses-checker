import java.util.Arrays;
import java.util.List;
import java.util.Stack;

public class ParenthesesChecker {

    // write a method called checkParentheses()
    // takes in a String
    // returns a boolean

    // return true if the string contains "correct" pairs of parentheses
    // return false if not!
    // situations to return false:
        // if there's an unequal amount of opening and closing parentheses of a particular type
        // closing bracket at start, opening one at the end
        // opening bracket followed by 2 closing brackets

    public ParenthesesChecker() {

    }

    public boolean checkParentheses(String string) {

        // Have two lists, one with opening and one with closing brackets
        // Use these to compare to the characters in the string
        List<Character> openingParentheses = Arrays.asList('(','{','[','<');
        List<Character> closingParentheses = Arrays.asList(')','}',']','>');

        // Make an empty stack to store opening brackets in one by one
        Stack<Character> unmatchedParentheses = new Stack<>();

        // Make a char array with all non-parentheses characters removed from string
        char[] chars = string.toCharArray();

        // Looping through this char array, if the character is an opening bracket, add it to the Stack
        // If you encounter a closing bracket, compare it to the character at the top of the Stack:
            // If the closing bracket matches with the opening bracket in the stack, we can remove the opening bracket from the stack as it has found a matching pair
            // If the closing bracket does not match the opening bracket at the top of the stack, then the string is grammatically incorrect, so we return false
        // We do this for all characters in the char array
        for (char c : chars){
            if (openingParentheses.contains(c)){
                unmatchedParentheses.push(c);
            }
            if (closingParentheses.contains(c)){
                if (unmatchedParentheses.empty()) {
                    return false;
                }
                if (closingParentheses.indexOf(c) == openingParentheses.indexOf(unmatchedParentheses.peek())){
                    unmatchedParentheses.pop();
                }
                else {
                    return false;
                }
            }
        }

        // If at the end of the for loop our stack is empty, that means all brackets have been successfully matched, so we have a grammatically correct string
        return unmatchedParentheses.empty();
        // If our stack is not empty, we have opening bracket(s) without a matching closing bracket, and hence we return false
    }

}
