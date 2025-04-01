import java.util.Stack;
public class MathEvalute {
    public static int evaluate(String expression) {
            Stack<Integer> numbers = new Stack<>();
            Stack<Character> operators = new Stack<>();
    
            for (int i = 0; i < expression.length(); i++) {
                char c = expression.charAt(i);
    
                if (Character.isDigit(c)) {
                    int num = 0;
                    while (i < expression.length() && Character.isDigit(expression.charAt(i))) {
                        num = num * 10 + (expression.charAt(i) - '0');
                        i++;
                    }
                    numbers.push(num);
                    i--;
                } else if (c == '+' || c == '-' || c == '*' || c == '/') {
                    while (!operators.isEmpty() && precedence(c) <= precedence(operators.peek())) {
                        numbers.push(applyOperation(operators.pop(), numbers.pop(), numbers.pop()));
                    }
                    operators.push(c);
                }
            }
    
            while (!operators.isEmpty()) {
                numbers.push(applyOperation(operators.pop(), numbers.pop(), numbers.pop()));
            }
    
            return numbers.pop();
        }
    
        private static int precedence(char op) {
            return (op == '+' || op == '-') ? 1 : (op == '*' || op == '/') ? 2 : 0;
        }
    
        private static int applyOperation(char op, int b, int a) {
            switch (op) {
                case '+': return a + b;
                case '-': return a - b;
                case '*': return a * b;
                case '/': return a / b;
            }
            return 0;
        }
    
        public static void main(String[] args) {
            String expression1 = "10 + 2 * 6";
            String expression2 = "100 * (2 + 12) / 14";
    
            System.out.println("Result: " + evaluate(expression1)); // Output: 22
            System.out.println("Result: " + evaluate(expression2)); // Output: 100
        }
    }
    
    

