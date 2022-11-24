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

    //

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
        if (unmatchedParentheses.empty()) {
            return true;
        }
        return false;
    }

}
