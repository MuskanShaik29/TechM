package Assessment10;
	import java.util.Stack;

	public class Balancedbrackets {

	    public static boolean isBalanced(String str) {
	        Stack<Character> stack = new Stack<>();

	        for (char ch : str.toCharArray()) {
	            if (ch == '(' || ch == '{' || ch == '[') {
	                stack.push(ch);
	            } else if (ch == ')' || ch == '}' || ch == ']') {
	                if (stack.isEmpty()) return false;
	                char top = stack.pop();
	                if (!isMatchingPair(top, ch)) return false;
	            }
	        }
	        return stack.isEmpty(); // If stack is empty, brackets are balanced
	    }

	    private static boolean isMatchingPair(char open, char close) {
	        return (open == '(' && close == ')') ||
	               (open == '{' && close == '}') ||
	               (open == '[' && close == ']');
	    }

	    public static void main(String[] args) {
	        String str = "{[()]}";  // Example input
	        System.out.println("Is Balanced? " + isBalanced(str)); // Output: true
	    }
	}
